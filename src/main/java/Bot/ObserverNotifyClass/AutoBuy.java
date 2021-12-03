package Bot.ObserverNotifyClass;

import Bot.ObserverNotifyClass.Observer;
import GoodsDb.Db;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AutoBuy implements Observer {
    public void update (){
        JSONObject mainDbObject = Db.getDb();
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods"); //autoEatGoodsArray을 선언하고, 자동구매 식료품들의 JSONObject정보들을 담음
        JSONArray autoNotEatGoodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods"); //autoNotEatGoodsArray을 선언하고, 자동구매 비식료품들의 JSONObject정보들을 담음


    }
}
