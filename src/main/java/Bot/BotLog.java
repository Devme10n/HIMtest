package Bot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;
//물품관리봇이 자동구매를 한 뒤 로그를 남기는 클래스(로그를 생성하는 인스턴스를 하나만 두기 위해 싱글톤 패턴으로 설계함)
public class BotLog {
    private static final BotLog BOTLOG_INSTANCE = new BotLog();
    private static JSONArray botLog; //자동구매를 한 물품의 로그가 저장되어있는 botLog. 클래스 내부에서만 접근 가능

    //생성자에서 allGoodsDb를 인스턴스가 생성될 때 1번만 초기 형태를 만들어줌
    private BotLog(){
        botLog = new JSONArray();

    }
    //Db클래스의 botLog를 전달해주는 메소드
    public static JSONArray getLog(){
        return botLog;
    }
    //코드와 이름과 수량을 전달받아 자동구매 로그를 만든다
    public static void putLog(String code, String name, String qty){
        LocalDate nowdate = LocalDate.now(); //오늘날짜 받음
        JSONObject object = new JSONObject(); //배열에 넣을 오브젝트 실행
        //오늘의 년월일을 넣을 변수들 선언
        int y = nowdate.getYear();
        int m = nowdate.getMonthValue();
        int d = nowdate.getDayOfMonth();
        //봇이 자동구매를 한 날짜와 자동구매 한 물건의 코드, 이름, 자동구매수량을 오브젝트에 넣어서 로그를 만듬
        object.put("addYear", Integer.toString(y));
        object.put("addMonth", Integer.toString(m));
        object.put("addDay", Integer.toString(d));
        object.put("code", code);
        object.put("name", name);
        object.put("quantity", qty);

        botLog.add(object); //만든 오브젝트를 배열에 추가함
    }
}
