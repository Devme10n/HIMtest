package Bot.ObserverNotifyClass;

import Bot.ObserverNotifyClass.Observer;
import GoodsDb.Db;
import Bot.BotLog;
import java.lang.String;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AutoBuy implements Observer {
    QuantityCheck quantityCheck = new QuantityCheck();
    public void update (){
        System.out.println("업데이트 성공함"); //testttttttttttttttttttttttttttttt
        JSONObject mainDbObject = Db.getDb();
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods"); //autoEatGoodsArray을 선언하고, 자동구매 식료품들의 JSONObject정보들을 담음
        JSONArray autoNotEatGoodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods"); //autoNotEatGoodsArray을 선언하고, 자동구매 비식료품들의 JSONObject정보들을 담음

        autoEatGoodsArray = quantityCheck.check(autoEatGoodsArray);
        autoNotEatGoodsArray = quantityCheck.check(autoNotEatGoodsArray);

    }
}

class QuantityCheck {
    String numPurchas;
    String numValue;
    public JSONArray check(JSONArray array) {
        for(int i=0; i<array.size(); i++){
            JSONObject object = (JSONObject) array.get(i); //자동구매 비식료품 배열에서 i가 가리키는 값 추출
            numValue = (String) object.get("quantity");
            if (Integer.parseInt(numValue) == 0){
                numPurchas = (String) object.get("autoBuy");
                object.put("quantity", numPurchas);
                System.out.println("<자동구매 완료>"); //testttttttttttttttttttttttttttttttttttttt
                BotLog.putLog((String)object.get("code"), (String)object.get("name"), (String)object.get("autoBuy"));
            }

        }
        return array;
    }
}
