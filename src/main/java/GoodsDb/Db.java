package GoodsDb;
//추가 라이브러리 불러옴
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

//싱글톤패턴을 적용해서 db인스턴스가 한개만 있을 수 있도록 함.
public class Db extends Subject {
    private static final Db DB_INSTANCE = new Db();
    private static JSONObject allGoodsDb; //물품의 모든 정보가 저장되어있는 allGoodsDb. 클래스 내부에서만 접근 가능

    //생성자에서 allGoodsDb를 인스턴스가 생성될 때 1번만 초기 형태를 만들어줌
    private Db(){
        String firstValue = "{\"eatGoods\":[],\"notEatGoods\":[],\"autoEatGoods\":[],\"autoNotEatGoods\":[]}";
        try{
            JSONParser jsonParser = new JSONParser();
            allGoodsDb = (JSONObject) jsonParser.parse(firstValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    //Db클래스의 인스턴스를 전달해주는 메소드
    public static Db getInstance(){
        return DB_INSTANCE;
    }
    //Db클래스의 allGoodsDb를 전달해주는 메소드
    public static JSONObject getDb(){
        return allGoodsDb;
    }
    //전달받은 JSONObject를 allGoodsDb에 덮어쓰는 메소드
    public static void putDb(JSONObject put){
        allGoodsDb = put;
        notifyObservers(); //부모클래스인 Subject 클래스의 notifyObservers 메소드 호출, 메인DB가 변경됨을 통보 대상인 Observer 인터페이스에게 통보

    }
}
