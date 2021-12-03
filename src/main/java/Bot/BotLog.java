package Bot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;

public class BotLog {
    private static final BotLog BOTLOG_INSTANCE = new BotLog();
    private static JSONArray botLog; //물품의 모든 정보가 저장되어있는 allGoodsDb. 클래스 내부에서만 접근 가능

    //생성자에서 allGoodsDb를 인스턴스가 생성될 때 1번만 초기 형태를 만들어줌
    private BotLog(){
        botLog = new JSONArray();

    }
    //BotLog클래스의 인스턴스를 전달해주는 메소드
    public static BotLog getInstance(){
        return BOTLOG_INSTANCE;
    }
    //Db클래스의 botLog를 전달해주는 메소드
    public static JSONArray getLog(){
        return botLog;
    }
    //전달받은 JSONArray를 botLog에 덮어쓰는 메소드
    public static void putLog(String code, String name, String qty){
        LocalDate nowdate = LocalDate.now(); //오늘날짜 받아오는거
        JSONObject object = new JSONObject();
        int y = nowdate.getYear();
        int m = nowdate.getMonthValue();
        int d = nowdate.getDayOfMonth();

        object.put("addYear", Integer.toString(y));
        object.put("addMonth", Integer.toString(m));
        object.put("addDay", Integer.toString(d));
        object.put("code", code);
        object.put("name", name);
        object.put("quantity", qty);

        botLog.add(object);
    }
}
