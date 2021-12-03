package Bot.ObserverNotifyClass;

import Bot.BotLog;
import Bot.ObserverNotifyClass.Observer;
import GoodsDb.Db;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;

public class ExpNotification implements Observer {
    static String[] alarmArray;
    ExpCheck expCheck = new ExpCheck();
    public void update(){
        JSONObject mainDbObject = Db.getDb();
        JSONArray eatGoodsArray = (JSONArray) mainDbObject.get("eatGoods"); //eatGoodsArray을 선언하고, 식료품들의 JSONObject정보들을 담음
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods"); //autoEatGoodsArray을 선언하고, 자동구매 식료품들의 JSONObject정보들을 담음

        expCheck.check(eatGoodsArray);
        expCheck.check(autoEatGoodsArray);


    }
    public void putAlarm (String[] array){
        String a = alarmArray[1];

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
                    System.out.println("<유통기한 지난 물품 발견>"); //testttttttttttttttttttttttttttttttttttttt
                else {
                    if (Integer.parseInt(checkMonth) <= m) {
                        if (Integer.parseInt(checkMonth) < m)
                            System.out.println("<유통기한 지난 물품 발견>"); //testttttttttttttttttttttttttttttttttttttt
                        else {
                            if (Integer.parseInt(checkDay) <= d) {
                                if (Integer.parseInt(checkDay) < d)
                                    System.out.println("<유통기한 지난 물품 발견>"); //testttttttttttttttttttttttttttttttttttttt
                                else
                                    System.out.println("<유통기한이 오늘까지인 물품 발견>"); //testttttttttttttttttttttttttttttttttttttt
                            }
                            if ((Integer.parseInt(checkDay) - d) <= 3){
                                int countDown = Integer.parseInt(checkDay) - d;
                                System.out.println("<유통기한이 n일 남은 물품 발견>"); //testttttttttttttttttttttttttttttttttttttt
                            }
                        }

                    }
                }
            }


        }

    }
}