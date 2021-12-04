package GoodsDb.DbUse;

import GoodsDb.Db;
import GoodsDb.DbPrint.DbPrinter;
import Util.UserInput;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Objects;

public class DbUse {
    DbPrinter dbPrinter = new DbPrinter();
    String userSel;
    String index;
    JSONArray goodsArray;
    String amountUse;
    String oldValue;
    int newValue;
    public void use() {
        JSONObject mainDbObject = Db.getDb(); //물품 전체 db를 JSONObject로 가져옴
        goodsArray = new JSONArray();
        System.out.println("\n<물건 사용 기능에 들어오셨습니다.> \n");
        userSel = UserInput.selFive(" 어떤 분류를 선택하시겠습니까? (식료품 = 1, 비식료품 = 2, 자동구매 식료품 = 3, 자동구매 비식료품 = 4, 나가기 = 5) :");
        switch (userSel){
            case "1" :
                dbPrinter.eatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("eatGoods");
                index = "eatGoods";
                break;
            case "2" :
                dbPrinter.notEatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("notEatGoods");
                index = "notEatGoods";
                break;
            case "3" :
                dbPrinter.autoEatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("autoEatGoods");
                index = "autoEatGoods";
                break;
            case "4" :
                dbPrinter.autoNotEatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods");
                index = "autoNotEatGoods";
                break;
            case "5" :
                return;
        }
        if (goodsArray.size() == 0){
            use();
            return;
        }
        execute(mainDbObject, goodsArray, index);
    }
    void execute(JSONObject mainDbObject, JSONArray array, String index) {
        JSONObject object = new JSONObject();
        userSel = UserInput.integer("\n\n 몇번 물품을 사용하시겠습니까? :");
        if (Integer.parseInt(userSel) > goodsArray.size()){
            System.out.println("error.리스트에 있는 번호를 입력해주세요.");
            execute(mainDbObject, array, index);
            return;
        }
        JSONObject goodsObject = (JSONObject) array.get(Integer.parseInt(userSel)-1); //배열에서 추출
        oldValue = (String) goodsObject.get("quantity");
        amountUse = UserInput.integer(" 사용량은 몇개인가요? :");
        if (Integer.parseInt(amountUse) > Integer.parseInt(oldValue)) {
            System.out.println("error.사용하려는 양이 기존의 양보다 많습니다.");
            execute(mainDbObject, array, index);
            return;
        }
        newValue = Integer.parseInt(oldValue) - Integer.parseInt(amountUse);
        if ((Objects.equals(index, "eatGoods") && newValue == 0) || (Objects.equals(index, "notEatGoods") && newValue == 0))
            array.remove(Integer.parseInt(userSel)-1);
        else
            goodsObject.put("quantity", Integer.toString(newValue));

        switch (index){
            case "eatGoods" :
                mainDbObject.put("eatGoods", array);
                break;
            case "notEatGoods" :
                mainDbObject.put("notEatGoods", array);
                break;
            case "autoEatGoods" :
                mainDbObject.put("autoEatGoods", array);
                break;
            case "autoNotEatGoods" :
                mainDbObject.put("autoNotEatGoods", array);
                break;
        }
        Db.putDb(mainDbObject);
        System.out.println("물품을 사용했습니다.");
    }
}
