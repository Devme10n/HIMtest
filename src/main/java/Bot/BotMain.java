package Bot;

import GoodsDb.*;
import Bot.ObserverNotify.AutoBuy;
import Bot.ObserverNotify.ExpConfirm;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//처음
public class BotMain {
    JSONArray array = new JSONArray(); //JSONArray타입의 배열 선언
    PrintBotLog printBotLog = new PrintBotLog();
    PrintAlarm printAlarm = new PrintAlarm();
    //Observer인터페이스에 통보대상 클래스를 추가해주는 메소드
    public static void main() {
        AutoBuy autoBuy = new AutoBuy(); //@@여기에 마지막 행동@@
        ExpConfirm expNotification = new ExpConfirm(); //@@여기에 마지막 행동@@

        //자동구매를 하는 클래스와 유통기한을 체크해서 알람을 보내는 클래스를 Observer 인터페이스에 통보대상으로 추가
        Db.attach(autoBuy);
        Db.attach(expNotification);
    }
    //
    public void printBotLog() {
        printBotLog.print();
    }
    public void printAlarm() {
        printAlarm.print();
    }
}
abstract class Print{
    JSONArray array = new JSONArray(); //JSONArray타입의 배열 선언

    abstract void print(); //추상클래스 print 선언
}
class PrintBotLog extends Print {
    public void print(){
        array = BotLog.getLog();
        //만약 자동구매 로그 내역이 없다면 봇이 아직 자동구매를 하지 않았다고 출력함
        if (array.size() == 0) {
            System.out.println("\nerror. 봇은 아직 자동구매를 하지 않았습니다.");
            return;
        }
        System.out.println("\n==========봇 자동구매 로그==========");
        for(int i=0; i<array.size(); i++){
            System.out.println("\n ===>"+(i+1)+"번 로그");
            JSONObject obj = (JSONObject) array.get(i);
            System.out.print("자동구매한 날짜 = "+obj.get("addYear")+"년 "+obj.get("addMonth")+"월 "+obj.get("addDay")+"일");
            System.out.print(" // 코드 = "+obj.get("code"));
            System.out.print(" // 이름 = "+obj.get("name"));
            System.out.print(" // 구매개수 = "+obj.get("quantity"));
            System.out.println("\n");
        }
        System.out.println("\n");
    }
}
class PrintAlarm extends Print {
    public void print() {
        List<String> array = ExpConfirm.alarmArray;
        if (array.size() == 0)
            System.out.println("# 유통기한 알림 없음.");
        for(int i=0; i<array.size() ; i++){
            System.out.println(array.get(i));
        }
    }
}