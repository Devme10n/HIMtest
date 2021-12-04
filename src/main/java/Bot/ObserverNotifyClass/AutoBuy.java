package Bot.ObserverNotifyClass;

import Bot.ObserverNotifyClass.Observer;
import GoodsDb.Db;
import Bot.BotLog;
import java.lang.String;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AutoBuy implements Observer {
    QuantityCheck quantityCheck = new QuantityCheck();
    public void update (){
        JSONObject mainDbObject = Db.getDb();
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods"); //autoEatGoodsArray을 선언하고, 자동구매 식료품들의 JSONObject정보들을 담음
        JSONArray autoNotEatGoodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods"); //autoNotEatGoodsArray을 선언하고, 자동구매 비식료품들의 JSONObject정보들을 담음

        autoEatGoodsArray = quantityCheck.check(autoEatGoodsArray, "y");
        autoNotEatGoodsArray = quantityCheck.check(autoNotEatGoodsArray, "n");

    }
}

class QuantityCheck {
    String numPurchas;
    String numValue;
    LocalDate nowdate = LocalDate.now(); //오늘날짜 받아오는거
    int y = nowdate.getYear();
    int m = nowdate.getMonthValue();
    int d = nowdate.getDayOfMonth();

    public JSONArray check(JSONArray array, String eat) {
        for(int i=0; i<array.size(); i++){
            JSONObject object = (JSONObject) array.get(i); //자동구매 비식료품 배열에서 i가 가리키는 값 추출
            numValue = (String) object.get("quantity");
            if (Integer.parseInt(numValue) == 0){
                numPurchas = (String) object.get("autoBuy");
                object.put("quantity", numPurchas);
                if (eat == "y") {
                    if (d <= 15)
                        object.put("expDay", Integer.toString(d+15));
                    else{
                        if (m == 12){
                            object.put("expYear", Integer.toString(y+1));
                            object.put("expMonth", "1");
                            object.put("expDay", Integer.toString(d));
                        }
                        else{
                            object.put("expMonth", Integer.toString(m+1));
                            object.put("expDay", Integer.toString(d));
                        }
                    }
                }
                BotLog.putLog((String)object.get("code"), (String)object.get("name"), (String)object.get("autoBuy"));
            }

        }
        return array;
    }
}
