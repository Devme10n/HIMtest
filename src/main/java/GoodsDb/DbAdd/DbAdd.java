package GoodsDb.DbAdd;
//추가 라이브러리 불러옴

import GoodsDb.Db;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

//다른 패키지의 클래스들 불러옴
import Util.UserInput;
import GoodsDb.DbAdd.DbAddUnderClass.*;

//사용자가 물품 추가를 선택하면 물품의 유통기한 여부나 자동구매 여부에 따라 물품종류를 나눠주는 클래스
public class DbAdd{
    UserInput userInput = new UserInput();
    DbAddInterface dbAddInt = new DbAddInterface();
    String userSel;
    int selInt;

    //물품종류를 조건에 맞춰서 나눠주는 메소드
    public void add(){
        //여기 I/O 적용해야함
        System.out.println("\n <물건 추가 기능에 들어오셨습니다.> \n");
        userSel = userInput.selTwo("물건이 유통기한이 있나요? (Yes = 1, No = 2 입력) :");
        if (userSel.equals("1"))
            selInt = 1;
        else
            selInt = 2;

        userSel = userInput.selTwo("자동구매를 설정할 물건인가요? (Yes = 1, No = 2 입력) :");
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
    private final BasicAdd BASIC_ADD;
    private final ExpDateProperty EXP_DATE;
    private final AutoBuyProperty AUTO_BUY;

    //생성자로 처음 한번 하위 클래스들의 상수에 주소값을 넣어서 초기화를 시켜줌
    public DbAddInterface(){
        BASIC_ADD = new BasicAdd();
        EXP_DATE = new ExpDateProperty();
        AUTO_BUY = new AutoBuyProperty();
    }
    //식료품 추가 메소드
    public void eatGoodsAdd()  {
        JSONObject mainDbObject = Db.getdb(); //물품 전체 db를 JSONObject로 가져옴
        JSONArray eatGoodsArray = (JSONArray) mainDbObject.get("eatGoods"); //식료품들의 JSONObject정보들을 담을 JSONArray 선언
        JSONObject eatGoodsInfo = new JSONObject(); // 식료품 속성들의 정보가 들어갈 JSONObject 선언

        System.out.println("\n <식료품의 추가를 선택하셨습니다.> \n");

        eatGoodsInfo = BASIC_ADD.add("A");
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
        JSONObject mainDbObject = Db.getdb(); //물품 전체 db를 JSONObject로 가져옴
        JSONArray notEatGoodsArray = (JSONArray) mainDbObject.get("notEatGoods"); //비식료품들의 JSONObject정보들을 담을 JSONArray 선언
        JSONObject notEatGoodsInfo = new JSONObject(); // 비식료품 속성들의 정보가 들어갈 JSONObject 선언

        System.out.println("\n <비식료품의 추가를 선택하셨습니다.> \n");

        notEatGoodsInfo = BASIC_ADD.add("B");

        notEatGoodsArray.add(notEatGoodsInfo);//비식료품의 정보를 받는 배열에 식료품 하나의 정보가 모두 담긴 오브젝트를 삽입
        mainDbObject.put("notEatGoods", notEatGoodsArray); // 물품 전체 db에 추가된 비식료품 JSONArray를 넣음
        Db.putdb(mainDbObject); //물품 전체 db를 물품 전체 db원본에 최신화시켜줌

    }
    //자동구매를 설정한 식료품 추가 메소드
    public void autoEatGoodsAdd() {
        JSONObject mainDbObject = Db.getdb();
        JSONArray autoEatGoodsArray = (JSONArray) mainDbObject.get("autoEatGoods");
        JSONObject autoEatGoodsInfo = new JSONObject();

        System.out.println("\n <자동구매 식료품의 추가를 선택하셨습니다.> \n");

        autoEatGoodsInfo = BASIC_ADD.add("C");
        autoEatGoodsInfo.put("expYear",EXP_DATE.add("Y"));
        autoEatGoodsInfo.put("expMonth",EXP_DATE.add("M"));
        autoEatGoodsInfo.put("expDay",EXP_DATE.add("D"));
        autoEatGoodsInfo.put("autoBuy", AUTO_BUY.add());

        autoEatGoodsArray.add(autoEatGoodsInfo);
        mainDbObject.put("autoEatGoods", autoEatGoodsArray);
        Db.putdb(mainDbObject);

    }
    //자동구매를 설정한 비식료품 추가 메소드
    public void autoNotEatGoodsAdd() {
        JSONObject mainDbObject = Db.getdb();
        JSONArray autoNotEatGoodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods");
        JSONObject autoNotEatGoodsInfo;

        System.out.println("\n <자동구매 비식료품의 추가를 선택하셨습니다.> \n");

        autoNotEatGoodsInfo = BASIC_ADD.add("D");
        autoNotEatGoodsInfo.put("autoBuy", AUTO_BUY.add());

        autoNotEatGoodsArray.add(autoNotEatGoodsInfo);
        mainDbObject.put("autoNotEatGoods", autoNotEatGoodsArray);
        Db.putdb(mainDbObject);
    }
}
//식료품, 비식료품, 자동구매 식료품, 자동구매 비식료품들이 기본적으로 가지고 있는 겹치는 속성들을 하나로 묶어주는 클래스
class BasicAdd {
    private final CodeProperty CODE;
    private final NameProperty NAME;
    private final QtyProperty QTY;
    private final AddDateProperty ADD_DATE;

    public BasicAdd(){
        CODE = CodeProperty.getInstance();
        NAME = new NameProperty();
        QTY = new QtyProperty();
        ADD_DATE = new AddDateProperty();
    }

    JSONObject add(String code){
        JSONObject goodsInfo = new JSONObject();
        goodsInfo.put("code", CODE.add(code));
        goodsInfo.put("name", NAME.add());
        goodsInfo.put("quantity",QTY.add());
        goodsInfo.put("addYear",ADD_DATE.add("Y"));
        goodsInfo.put("addMonth",ADD_DATE.add("M"));
        goodsInfo.put("addDay",ADD_DATE.add("D"));
        return goodsInfo;
    }

}