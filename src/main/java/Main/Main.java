package Main;

import GoodsDb.DbAdd.DbAdd;
import GoodsDb.DbUse.DbUse;
import GoodsDb.DbDelete.DbDelete;
import GoodsDb.DbPrint.DbPrint;
import User.Login;
import User.Register;
import User.UserDateSet;
import Bot.BotMain;
import Util.UserInput;


public class Main {
    //사용자의 선택을 받을 문자열타입 변수 선언과 이 클래스에서 사용할 다른 클래스들의 인스턴스를 실행해서 주소변수에 할당
    static String userSell;
    static DbAdd dbAdd = new DbAdd();
    static DbUse dbUse = new DbUse();
    static DbDelete dbDelete = new DbDelete();
    static DbPrint dbPrint = new DbPrint();
    static BotMain botMain = new BotMain();

    //프로그램이 실행되면 맨 처음 실행되서 로그인 메소드를 호출해줌
    public static void main(String[] args) {
        BotMain.main();
        System.out.println("\n<HIM 프로그램이 실행되었습니다.>");
        login();
    }
    //로그인을 관리해줄 메소드
    public static void login() {
        UserDateSet.userListSet();
        System.out.println("\n<로그인 메뉴에 들어오셨습니다.> \n");
        System.out.print(" 1. 로그인 \n 2. 회원가입 \n 3. 프로그램을 종료");
        String userSell = UserInput.selThree( "\n\n 어떤 기능을 선택하시겠습니까? :");
        //사용자가 프로그램 종료를 선택했으면 호출했던 메소드로 돌아감
        if (userSell.equals("3"))
            return;
        //사용자의 선택에 따라 로그인이나 회원가입을 진행함
        if (userSell.equals("1")) {
            Login.login();
        } else {
            Register.register();
            Login.login();
        }
        mainMenu(); //로그인이 끝난 뒤 메인메뉴 메소드 호출
        login(); //사용자가 프로그램 종료를 선택하기 전까지 계속 재귀
    }
    //메인메뉴를 관리해줄 메소드
    public static void mainMenu() {
        System.out.println("\n<메인 메뉴에 들어오셨습니다.> \n");
        //메인메뉴에서는 항상 맨 위에 유통기한 알림을 출력해줌
        System.out.println("==========유통기한 알림==========");
        botMain.printAlarm();
        System.out.print("\n 1. 물품 추가 \n 2. 물품 사용 \n 3. 물품 삭제 \n 4. 물품 리스트 출력 \n 5. 자동구매 로그 확인 \n 6. 로그인 메뉴로 돌아가기\n");
        userSell = UserInput.selSix("\n 어떤 기능을 선택하시겠습니까? :");

        //사용자의 선택에 따라 메소드들을 실행해줌
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
        mainMenu(); //사용자가 로그인 메뉴로 돌아가기를 선택하기 전까지 재귀
    }

}