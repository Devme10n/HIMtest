package Bot;

import GoodsDb.*;
import Bot.ObserverNotifyClass.AutoBuy;
import Bot.ObserverNotifyClass.ExpNotification;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BotMain {
    JSONArray array = new JSONArray();
    public static void main() {

        AutoBuy autoBuy = new AutoBuy(); //@@여기에 마지막 행동@@
        ExpNotification expNotification = new ExpNotification(); //@@여기에 마지막 행동@@

        Db.attach(autoBuy); //AutoBuy 클래스를 통보 대상 클래스로 Observer 인터페이스로 추가
        Db.attach(expNotification); //ExpNotification 클래스를 통보 대상 클래스로 Observer 인터페이스로 추가
    }
    public void printBotLog() {

        array = BotLog.getLog();
        System.out.println("\n\n ==========봇 자동구매 로그==========");
        for(int i=0; i<array.size(); i++){
            System.out.println("\n ===>"+(i+1)+"번 로그");
            JSONObject obj = (JSONObject) array.get(i);
            System.out.print("자동구매한 날짜 = "+obj.get("addYear")+"년 "+obj.get("addMonth")+"월 "+obj.get("addDay")+"일");
            System.out.print(" // 코드 = "+obj.get("code"));
            System.out.print(" // 이름 = "+obj.get("name"));
            System.out.print(" // 구매개수 = "+obj.get("quantity"));
        }


    }
    public void printAlarm() {
        System.out.println("프린트알람 진입");//testttttttttttttttttttttttttttttttttt
        List<String> array = ExpNotification.alarmArray;
        for(int i=0; i<array.size() ; i++){
            System.out.println("\n" +array.get(i));
        }
    }
}
