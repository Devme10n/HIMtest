package GoodsDb.DbPrint;

import Util.UserInput;
import GoodsDb.DbPrint.DbPrinter;

import java.util.Objects;

public class DbPrint {
    String userSel;
    DbPrinter dbPrinter = new DbPrinter();
    public void print() {
        System.out.println("\n<물품 출력 기능에 들어오셨습니다.> \n");

        userSel = UserInput.selThree(" 물품 출력을 어떻게 하시겠습니까? (전체 출력 = 1, 부분 출력 = 2, 나가기 = 3) :");
        if (Objects.equals(userSel, "3"))
            return;
        if (Objects.equals(userSel, "1")) {
            dbPrinter.allGoodsPrint();
            return;
        }
        userSel = UserInput.selFive(" 어떤 분류를 선택하시겠습니까? (식료품 = 1, 비식료품 = 2, 자동구매 식료품 = 3, 자동구매 비식료품 = 4, 나가기 = 5) :");
        switch (userSel){
            case "1" :
                dbPrinter.eatGoodsPrint();
                break;
            case "2" :
                dbPrinter.notEatGoodsPrint();
                break;
            case "3" :
                dbPrinter.autoEatGoodsPrint();
                break;
            case "4" :
                dbPrinter.autoNotEatGoodsPrint();
                break;
            case "5" :
                return;
        }
        //메인으로 가면됨

    }
}
