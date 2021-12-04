package Main;

import GoodsDb.DbAdd.DbAdd;
import GoodsDb.DbPrint.DbPrint;
import User.Login;
import User.Register;
import User.UserDateSet;
import GoodsDb.DbDelete.DbDelete;
import GoodsDb.DbUse.DbUse;
import Bot.BotMain;
import Util.UserInput;


public class Main {

    static String userSell;
    static DbAdd dbAdd = new DbAdd();
    static DbUse dbUse = new DbUse();
    static DbDelete dbDelete = new DbDelete();
    static DbPrint dbPrint = new DbPrint();
    static BotMain botMain = new BotMain();

    public static void main(String[] args) {
        botMain.main();
        System.out.println("\n<HIM 프로그램이 실행되었습니다.> \n");
        login();
        return;
    }
    public static void login() {
        UserDateSet.userListSet();
        System.out.println("\n<로그인 메뉴에 들어오셨습니다.> \n");
        System.out.print(" 1. 로그인 \n 2. 회원가입 \n 3. 프로그램을 종료");
        String userSell = UserInput.selThree( "\n\n 어떤 기능을 선택하시겠습니까? :");
        if (userSell.equals("3"))
            return;
        if (userSell.equals("1")) {
            Login.login();
        } else {
            Register.register();
            Login.login();
        }
        mainMenu();
        login();
    }
    public static void mainMenu() {
        System.out.println("\n<메인 메뉴에 들어오셨습니다.> \n");
        System.out.println("==========유통기한 알림==========");
        botMain.printAlarm();
        System.out.print("\n 1. 물품 추가 \n 2. 물품 사용 \n 3. 물품 삭제 \n 4. 물품 리스트 출력 \n 5. 자동구매 로그 확인 \n 6. 로그인 메뉴로 돌아가기\n");
        userSell = UserInput.selSix("\n 어떤 기능을 선택하시겠습니까? :");

        switch(userSell) {
            case "1" :
                dbAdd.add();
                break;
            case "2" :
                dbUse.use();
                break;
            case "3" :
                dbDelete.delete();
                break;
            case "4" :
                dbPrint.print();
                break;
            case "5" :
                botMain.printBotLog();
                break;
            case "6" :
                return;
        }
        mainMenu();

    }

}