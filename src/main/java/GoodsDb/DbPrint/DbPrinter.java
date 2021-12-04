package GoodsDb.DbPrint;

import GoodsDb.Db;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DbPrinter {

    public void eatGoodsPrint(){
        JSONObject mainDbObject = Db.getDb();
        JSONArray eatGoodsArray = (JSONArray) mainDbObject.get("eatGoods");
        System.out.println("\n\n========== 식료품 ==========");
        if (eatGoodsArray.size() == 0)
            System.out.println(" 식료품 없음");
        for(int i=0; i<eatGoodsArray.size(); i++) {
            System.out.println("\n ===>"+(i+1)+"번 물품");
            JSONObject eatGoodsObject = (JSONObject) eatGoodsArray.get(i); //배열에서 추출
            Printer eatGoodsPrinter = new ExpPrinter(new BasicPrinter(eatGoodsObject));
            eatGoodsPrinter.print();
        }

    }
    public void notEatGoodsPrint(){
        JSONObject mainDbObject = Db.getDb();
        JSONArray notEatGoodsArray = (JSONArray) mainDbObject.get("notEatGoods");
        System.out.println("\n\n========== 비식료품 ==========");
        if (notEatGoodsArray.size() == 0)
            System.out.println(" 비식료품 없음");
        for(int i=0; i<notEatGoodsArray.size(); i++) {
            System.out.println("\n ===>"+(i+1)+"번 물품");
            JSONObject notEatGoodsObject = (JSONObject) notEatGoodsArray.get(i); //배열에서 추출
            Printer notEatGoodsPrinter = new BasicPrinter(notEatGoodsObject);
            notEatGoodsPrinter.print();
        }

    }
    public void autoEatGoodsPrint(){
        JSONObject mainDbObject = Db.getDb();
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods");
        System.out.println("\n\n========== 자동구매 식료품 ==========");
        if (autoEatGoodsArray.size() == 0)
            System.out.println(" 자동구매 식료품 없음");
        for(int i=0; i<autoEatGoodsArray.size(); i++) {
            System.out.println("\n ===>"+(i+1)+"번 물품");
            JSONObject autoEatGoodsObject = (JSONObject) autoEatGoodsArray.get(i); //배열에서 추출
            Printer autoEatGoodsPrinter = new AutoBuyPrinter(new ExpPrinter(new BasicPrinter(autoEatGoodsObject)));
            autoEatGoodsPrinter.print();
        }
    }
    public void autoNotEatGoodsPrint(){
        JSONObject mainDbObject = Db.getDb();
        JSONArray autoNotEatGoodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods");
        System.out.println("\n\n========== 자동구매 비식료품 ==========");
        if (autoNotEatGoodsArray.size() == 0)
            System.out.println(" 자동구매 비식료품 없음");
        for(int i=0; i<autoNotEatGoodsArray.size(); i++) {
            System.out.println("\n ===>"+(i+1)+"번 물품");
            JSONObject autoNotEatGoodsObject = (JSONObject) autoNotEatGoodsArray.get(i); //배열에서 추출
            Printer autoNotEatGoodsPrinter = new AutoBuyPrinter(new BasicPrinter(autoNotEatGoodsObject));
            autoNotEatGoodsPrinter.print();
        }
    }
    //전체 물품 출력
    public void allGoodsPrint() {
        eatGoodsPrint();
        notEatGoodsPrint();
        autoEatGoodsPrint();
        autoNotEatGoodsPrint();
    }


}

abstract class Printer {
    JSONObject obj;
    public abstract JSONObject print();
}

class BasicPrinter extends Printer { //기본적인 것들 프린트


    public BasicPrinter(JSONObject object) {
        obj = object;
    }

    public JSONObject print() {
        System.out.print(" 코드 = "+obj.get("code"));
        System.out.print(" // 이름 = "+obj.get("name"));
        System.out.print(" // 수량 = "+obj.get("quantity"));
        System.out.print(" // 추가일 = "+obj.get("addYear")+"년 "+obj.get("addMonth")+"월 "+obj.get("addDay")+"일");
        return obj;
    }
}

abstract class PrinterDecorator extends Printer {
    private final Printer decoratedPrinter;

    public PrinterDecorator(Printer decoratedPrinter) {
        this.decoratedPrinter = decoratedPrinter;
    }

    public JSONObject print() {
        obj = decoratedPrinter.print();
        return obj;
    }
}

class ExpPrinter extends PrinterDecorator {
    public ExpPrinter(Printer decoratedPrinter) { super(decoratedPrinter); }

    public JSONObject print() {
        obj = super.print();
        printExp(obj);
        return obj;
    }
    private void printExp(JSONObject inObj) {
        System.out.print(" // 유통기한 = "+inObj.get("expYear")+"년 "+inObj.get("expMonth")+"월 "+inObj.get("expDay")+"일");
    }
}

class AutoBuyPrinter extends PrinterDecorator {
    public AutoBuyPrinter(Printer decoratedPrinter) { super(decoratedPrinter); }

    public JSONObject print() {
        obj = super.print();
        printExp(obj);
        return obj;
    }
    private void printExp(JSONObject inObj) {
        System.out.println(" // 자동구매 개수 = "+inObj.get("autoBuy"));
    }
}