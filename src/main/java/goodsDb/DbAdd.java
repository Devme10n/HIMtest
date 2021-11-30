package goodsDb;
//추가 라이브러리 불러옴
import java.time.LocalDate;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

//다른 패키지의 클래스들 불러옴
import util.UserInput;

//사용자가 물품 추가를 선택하면 물품의 유통기한 여부나 자동구매 여부에 따라 물품종류를 나눠줌
public class DbAdd{
    UserInput userInput = new UserInput();
    DbAddInterface dbAddInt = new DbAddInterface();
    String userSel;
    int selInt;

    //물품종류를 조건에 맞춰서 나눠주는 메소드
    public void add(){
        //여기 I/O 적용해야함
        System.out.println("\n <물건 추가 기능에 들어오셨습니다.> \n");
        userSel = userInput.integer("물건이 유통기한이 있나요? (Yes = 1, No = 2 입력) :");
        if (userSel.equals("1"))
            selInt = 1;
        else
            selInt = 2;

        userSel = userInput.integer("자동구매를 설정할 물건인가요? (Yes = 1, No = 2 입력) :");
        if (userSel.equals("1"))
            selInt += 10;
        else
            selInt += 20;


        switch (selInt) {
            case 11 -> dbAddInt.autoEatGoodsAdd();
            case 12 -> dbAddInt.autoNotEatGoodsAdd();
            case 21 -> dbAddInt.eatGoodsAdd();
            case 22 -> dbAddInt.notEatGoodsAdd();
            default -> {
                System.out.println("error");
                add();
            }
        }
    }
}

//식료품, 비식료품, 자동식료품, 자동비식료품을 구성요소인 하위 클래스들을 조합한 메소드를 통해 추가해줄 통합인터페이스 클래스(퍼사드 패턴)
class DbAddInterface {
    //하위 클래스들의 주소값을 저장할 상수들을 선언
    private final CodeProperty CODE;
    private final NameProperty NAME;
    private final QtyProperty QTY;
    private final AddDateProperty ADD_DATE;
    private final ExpDateProperty EXP_DATE;
    private final AutoBuyProperty AUTO_BUY;

    //생성자로 처음 한번 하위 클래스들의 상수에 주소값을 넣어서 초기화를 시켜줌
    public DbAddInterface(){
        CODE = CodeProperty.getInstance();
        NAME = new NameProperty();
        QTY = new QtyProperty();
        ADD_DATE = new AddDateProperty();
        EXP_DATE = new ExpDateProperty();
        AUTO_BUY = new AutoBuyProperty();
    }
    //식료품 추가 메소드
    public void eatGoodsAdd()  {
        Db dbInstance = Db.getInstance(); //db인스턴스의 주소를 가져옴
        JSONObject mainDbObject = Db.getdb(); //물품 전체 db를 JSONObject로 가져옴
        JSONArray eatGoodsArray = (JSONArray) mainDbObject.get("eatGoods"); //식료품들의 JSONObject정보들을 담을 JSONArray 선언
        JSONObject eatGoodsInfo = new JSONObject(); // 식료품 속성들의 정보가 들어갈 JSONObject 선언

        System.out.println("\n <식료품의 추가를 선택하셨습니다.> \n");

        eatGoodsInfo.put("code", CODE.add("A"));
        eatGoodsInfo.put("name", NAME.add());
        eatGoodsInfo.put("quantity",QTY.add());
        eatGoodsInfo.put("addYear",ADD_DATE.add("Y"));
        eatGoodsInfo.put("addMonth",ADD_DATE.add("M"));
        eatGoodsInfo.put("addDay",ADD_DATE.add("D"));
        eatGoodsInfo.put("expYear",EXP_DATE.add("Y"));
        eatGoodsInfo.put("expMonth",EXP_DATE.add("M"));
        eatGoodsInfo.put("expDay",EXP_DATE.add("D"));

        eatGoodsArray.add(eatGoodsInfo); //식료품의 정보를 받는 JSONArray에 식료품 속성들의 정보가 모두 담긴 오브젝트를 삽입
        mainDbObject.put("eatGoods", eatGoodsArray); // 물품 전체 db에 추가된 식료품 JSONArray를 넣음
        Db.putdb(mainDbObject); //물품 전체 db를 물품 전체 db원본에 최신화시켜줌

        System.out.println(eatGoodsInfo); // test

    }
    //비식료품 추가 메소드
    public void notEatGoodsAdd()  {
        Db dbInstance = Db.getInstance(); //db인스턴스의 주소를 가져옴
        JSONObject mainDbObject = Db.getdb(); //물품 전체 db를 JSONObject로 가져옴
        JSONArray notEatGoodsArray = (JSONArray) mainDbObject.get("notEatGoods"); //비식료품들의 JSONObject정보들을 담을 JSONArray 선언
        JSONObject notEatGoodsInfo = new JSONObject(); // 비식료품 속성들의 정보가 들어갈 JSONObject 선언

        System.out.println("\n <비식료품의 추가를 선택하셨습니다.> \n");

        notEatGoodsInfo.put("code", CODE.add("B"));
        notEatGoodsInfo.put("name", NAME.add());
        notEatGoodsInfo.put("quantity",QTY.add());
        notEatGoodsInfo.put("addYear",ADD_DATE.add("Y"));
        notEatGoodsInfo.put("addMonth",ADD_DATE.add("M"));
        notEatGoodsInfo.put("addDay",ADD_DATE.add("D"));

        notEatGoodsArray.add(notEatGoodsArray);//비식료품의 정보를 받는 배열에 식료품 하나의 정보가 모두 담긴 오브젝트를 삽입
        mainDbObject.put("notEatGoods", notEatGoodsArray); // 물품 전체 db에 추가된 비식료품 JSONArray를 넣음
        Db.putdb(mainDbObject); //물품 전체 db를 물품 전체 db원본에 최신화시켜줌

    }
    //자동구매를 설정한 식료품 추가 메소드
    public void autoEatGoodsAdd() {
        Db dbInstance = Db.getInstance();
        JSONObject mainDbObject = Db.getdb();
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods");
        JSONObject autoEatGoodsInfo = new JSONObject();

        System.out.println("\n <자동구매 식료품의 추가를 선택하셨습니다.> \n");

        autoEatGoodsInfo.put("code", CODE.add("C"));
        autoEatGoodsInfo.put("name", NAME.add());
        autoEatGoodsInfo.put("quantity",QTY.add());
        autoEatGoodsInfo.put("addYear",ADD_DATE.add("Y"));
        autoEatGoodsInfo.put("addMonth",ADD_DATE.add("M"));
        autoEatGoodsInfo.put("addDay",ADD_DATE.add("D"));
        autoEatGoodsInfo.put("expYear",EXP_DATE.add("Y"));
        autoEatGoodsInfo.put("expMonth",EXP_DATE.add("M"));
        autoEatGoodsInfo.put("expDay",EXP_DATE.add("D"));
        autoEatGoodsInfo.put("AUTO_BUY", AUTO_BUY.add());

        autoEatGoodsArray.add(autoEatGoodsInfo);
        mainDbObject.put("autoEatGoods", autoEatGoodsArray);
        Db.putdb(mainDbObject);

    }
    //자동구매를 설정한 비식료품 추가 메소드
    public void autoNotEatGoodsAdd() {
        Db dbInstance = Db.getInstance();
        JSONObject mainDbObject = Db.getdb();
        JSONArray autoNotEatGoodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods");
        JSONObject autoNotEatGoodsInfo = new JSONObject();

        System.out.println("\n <자동구매 비식료품의 추가를 선택하셨습니다.> \n");

        autoNotEatGoodsInfo.put("code", CODE.add("D"));
        autoNotEatGoodsInfo.put("name", NAME.add());
        autoNotEatGoodsInfo.put("quantity",QTY.add());
        autoNotEatGoodsInfo.put("addYear",ADD_DATE.add("Y"));
        autoNotEatGoodsInfo.put("addMonth",ADD_DATE.add("M"));
        autoNotEatGoodsInfo.put("addDay",ADD_DATE.add("D"));
        autoNotEatGoodsInfo.put("AUTO_BUY", AUTO_BUY.add());

        autoNotEatGoodsArray.add(autoNotEatGoodsInfo);
        mainDbObject.put("autoNotEatGoods", autoNotEatGoodsArray);
        Db.putdb(mainDbObject);
    }
}

//여기부터 하위 클래스들

//하위 클래스들의 상속에서 가장 상위에 있는 클래스. 사용자에게 입력을 받는 userInput인스턴스를 생성하고 출력용 문자열 out을 선언
class Property{
    UserInput userInput = new UserInput();
    static String out;
}
//Property클래스를 상속해서 반환타입이 없는 추상메소드 add를 구현한 추상클래스
abstract class PropertyAdd extends Property{
    abstract String add();
}

//Property클래스를 상속해서 문자열을 반환하는 추상메소드 add를 구현한 추상클래스
abstract class StrPropertyAdd extends Property{
    abstract String add(String sel);
}

//물품들의 코드는 겹치면 안되기 떄문에 싱글톤 패턴으로 코드추가 하위클래스를 구현(싱글톤 패턴)
class CodeProperty extends StrPropertyAdd{
    private static final CodeProperty cpaInstance = new CodeProperty();
    //물품의 종류마다 다르게 저장될 코드들의 정수 저장값들
    private static int eatGoodsCode = 1;
    private static int notEatGoodsCode = 1;
    private static int autoEatGoodsCode = 1;
    private static int autoNotEatGoodsCode = 1;

    private CodeProperty(){}
    //물품의 종류마다 앞의 로마자가 달라지고 발급순서대로 정수가 1씩 늘어나도록 코드를 발급해주는 메소드
    @Override
    public String add(String sel){
        switch (sel) {
            case "A" -> {
                out = "A" + eatGoodsCode;
                eatGoodsCode += 1;
                return out;
            }
            case "B" -> {
                out = "B" + notEatGoodsCode;
                notEatGoodsCode += 1;
                return out;
            }
            case "c" -> {
                out = "C" + autoEatGoodsCode;
                autoEatGoodsCode += 1;
                return out;
            }
            case "D" -> {
                out = "D" + autoNotEatGoodsCode;
                autoNotEatGoodsCode += 1;
                return out;
            }
            default -> {
                return out = "error";
            }
        }
    }
    //클래스의 인스턴스 주소값을 넘겨주는 메소드
    public static CodeProperty getInstance(){
        return cpaInstance;
    }

}

//물건의 이름 속성값을 추가하는 하위클래스
class NameProperty extends PropertyAdd{
    @Override
    public String add(){
        out = userInput.simple("물건의 이름은 무엇인가요? :");
        return out;
    }

}
//물건의 개수 속성값을 추가하는 하위클래스
class QtyProperty extends PropertyAdd{
    @Override
    public String add(){
        out = userInput.integer("물건의 수량은 몇개인가요? :");
        if (out.equals("error"))
            add();
        return out;
    }
}
//물건의 추가날짜 속성값을 추가하는 하위클래스
class AddDateProperty extends StrPropertyAdd{
    LocalDate now = LocalDate.now(); //오늘날짜 받아오는거
    @Override
    public String add(String sel){
        switch(sel){
            case "Y":
                int y = now.getYear();
                out = Integer.toString(y);
                return out;
            case "M":
                int m = now.getMonthValue();
                out = Integer.toString(m);
                return out;
            case "D":
                int d = now.getDayOfMonth();
                out = Integer.toString(d);
                return out;
            default:
                return out = "error";
        }
    }
}

//물건의 유통기한 속성값을 추가하는 하위클래스
class ExpDateProperty extends StrPropertyAdd{

    int check;
    @Override
    public String add(String sel){
        switch (sel) {
            case "Y" -> {
                out = userInput.year("물건의 유통기한은 몇년까지인가요? :");
                if (out.equals("error"))
                    add("Y");
                return out;
            }
            case "M" -> {
                out = userInput.month("물건의 유통기한은 몇월까지인가요? :");
                if (out.equals("error"))
                    add("M");
                return out;
            }
            case "D" -> {
                out = userInput.day("물건의 유통기한은 몇일까지인가요? :");
                if (out.equals("error"))
                    add("D");
                return out;
            }
            default -> {
                return out = "error";
            }
        }
    }
}
//물건의 자동구매 개수값을 추가하는 하위클래스
class AutoBuyProperty extends PropertyAdd{
    @Override
    public String add(){

        out = userInput.integer("물건이 다 떨어지면 몇개씩 자동구매 할까요? :");
        if (out.equals("error")){
            add();
        }
        return out;
    }
}
