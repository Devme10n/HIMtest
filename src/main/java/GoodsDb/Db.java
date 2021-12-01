package GoodsDb;
//추가 라이브러리 불러옴
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//싱글톤패턴을 적용해서 db인스턴스가 한개만 있을 수 있도록 함.
public class Db {
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
    public static JSONObject getdb(){
        return allGoodsDb;
    }
    //전달받은 JSONObject를 allGoodsDb에 덮어쓰는 메소드
    public static void putdb(JSONObject put){
        System.out.println(put); // testtttttttttttttttttttttttttttttttttttttttttttttttttt
        allGoodsDb = put;
    }
}
