package Bot.ObserverNotifyClass;

import Bot.BotLog;
import Bot.ObserverNotifyClass.Observer;
import java.util.*;
import GoodsDb.Db;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;

public class ExpNotification implements Observer {
    public static List<String> alarmArray;

    ExpCheck expCheck = new ExpCheck();
    public void update(){
        JSONObject mainDbObject = Db.getDb();
        JSONArray eatGoodsArray = (JSONArray) mainDbObject.get("eatGoods"); //eatGoodsArray을 선언하고, 식료품들의 JSONObject정보들을 담음
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods"); //autoEatGoodsArray을 선언하고, 자동구매 식료품들의 JSONObject정보들을 담음
        ExpNotification.alarmArray = new ArrayList<String>();
        expCheck.check(eatGoodsArray);
        expCheck.check(autoEatGoodsArray);


    }
}
class ExpCheck {
    String checkYear;
    String checkMonth;
    String checkDay;
    LocalDate nowdate = LocalDate.now(); //오늘날짜 받아오는거

    int y = nowdate.getYear();
    int m = nowdate.getMonthValue();
    int d = nowdate.getDayOfMonth();

    public void check(JSONArray array) {

        for(int i=0; i<array.size(); i++){
            JSONObject object = (JSONObject) array.get(i); //자동구매 비식료품 배열에서 i가 가리키는 값 추출
            checkYear = (String) object.get("expYear");
            checkMonth = (String) object.get("expMonth");
            checkDay = (String) object.get("expDay");





            if (Integer.parseInt(checkYear) <= y) {
                if (Integer.parseInt(checkYear) < y)
                    ExpNotification.alarmArray.add( "# "+object.get("addYear") +"년 "+object.get("addMonth")+"월 "+object.get("addDay")+"일에 추가된 "+object.get("code")+"코드의 "+object.get("name")+" 이(가) 유톻기한이 지났습니다.");

                else {
                    if (Integer.parseInt(checkMonth) <= m) {
                        if (Integer.parseInt(checkMonth) < m)
                            ExpNotification.alarmArray.add( "# "+object.get("addYear") +"년 "+object.get("addMonth")+"월 "+object.get("addDay")+"일에 추가된 "+object.get("code")+"코드의 "+object.get("name")+"이(가) 유톻기한이 지났습니다.");

                        else {
                            if (Integer.parseInt(checkDay) <= d) {
                                if (Integer.parseInt(checkDay) < d)
                                    ExpNotification.alarmArray.add( "# "+object.get("addYear") +"년 "+object.get("addMonth")+"월 "+object.get("addDay")+"일에 추가된 "+object.get("code")+"코드의 "+object.get("name")+" 이(가) 유톻기한이 지났습니다.");

                                else
                                    ExpNotification.alarmArray.add( "# "+object.get("addYear") +"년 "+object.get("addMonth")+"월 "+object.get("addDay")+"일에 추가된 "+object.get("code")+"코드의 "+object.get("name")+" 이(가) 유톻기한이 오늘까지 입니다.");
                            }
                            if ((Integer.parseInt(checkDay) - d) <= 3){
                                int countDown = Integer.parseInt(checkDay) - d;
                                ExpNotification.alarmArray.add( "# "+object.get("addYear") +"년 "+object.get("addMonth")+"월 "+object.get("addDay")+"일에 추가된 "+object.get("code")+"코드의 "+object.get("name")+" 이(가) 유톻기한이 "+countDown+"일 남았습니다.");
                            }
                        }

                    }
                }
            }


        }

    }
}