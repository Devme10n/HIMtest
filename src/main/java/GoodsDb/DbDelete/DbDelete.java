package GoodsDb.DbDelete;

import Util.UserInput;
import GoodsDb.DbPrint.DbPrinter;
import GoodsDb.Db;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DbDelete {
    UserInput userInput = new UserInput();
    DbPrinter dbPrinter = new DbPrinter();
    String userSel;
    String index;
    JSONArray goodsArray;
    public void delete() {
        JSONObject mainDbObject = Db.getdb(); //물품 전체 db를 JSONObject로 가져옴
        goodsArray = new JSONArray();
        System.out.println("\n <물건 삭제 기능에 들어오셨습니다.> \n");
        userSel = userInput.selFour("어떤 분류를 선택하시겠습니까? (식료품 = 1, 비식료품 = 2, 자동구매 식료품 = 3, 자동구매 비식료품 = 4 입력) :");
        switch (userSel){
            case "1" :
                dbPrinter.eatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("eatGoods");
                index = "eatGoods";
                break;
            case "2" :
                dbPrinter.notEatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("notEatGoods");
                index = "notEatGoods";
                break;
            case "3" :
                dbPrinter.autoEatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("autoEatGoods");
                index = "autoEatGoods";
                break;
            case "4" :
                dbPrinter.autoNotEatGoodsPrint();
                goodsArray = (JSONArray) mainDbObject.get("autoNotEatGoods");
                index = "autoNotEatGoods";
                break;
        }
        if (goodsArray.size() == 0){
            System.out.println("error.해당 분류에는 물품이 없습니다.");
            delete();
            return;
        }
        excut(mainDbObject, goodsArray, index);
    }
    void excut(JSONObject mainDbObject, JSONArray array, String index) {
        userSel = userInput.integer("\n\n 몇번 물품을 삭제하시겠습니까? :");
        if (Integer.parseInt(userSel) > goodsArray.size()){
            System.out.println("error.리스트에 있는 번호를 입력해주세요.");
            excut(mainDbObject, array, index);
            return;
        }
        array.remove(Integer.parseInt(userSel)-1);
        switch (index){
            case "eatGoods" :
                mainDbObject.put("eatGoods", array);
                break;
            case "notEatGoods" :
                mainDbObject.put("notEatGoods", array);
                break;
            case "autoEatGoods" :
                mainDbObject.put("autoEatGoods", array);
                break;
            case "autoNotEatGoods" :
                mainDbObject.put("autoNotEatGoods", array);
                break;
        }
        Db.putdb(mainDbObject);
        System.out.println("물품을 삭제했습니다.");
    }
}
