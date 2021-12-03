package Bot;

import GoodsDb.*;
import Bot.ObserverNotifyClass.AutoBuy;
import Bot.ObserverNotifyClass.ExpNotification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BotMain {
    public static void main() {

        AutoBuy autoBuy = new AutoBuy(); //@@여기에 마지막 행동@@
        ExpNotification expNotification = new ExpNotification(); //@@여기에 마지막 행동@@

        Db.attach(autoBuy); //AutoBuy 클래스를 통보 대상 클래스로 Observer 인터페이스로 추가
        Db.attach(expNotification); //ExpNotification 클래스를 통보 대상 클래스로 Observer 인터페이스로 추가
    }
    public void botLog(){

    }
}
