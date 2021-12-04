package Main;

import java.util.*;

import GoodsDb.Db;
import GoodsDb.DbAdd.DbAdd;
import GoodsDb.DbPrint.DbPrint;
import User.Login;
import User.Register;
import User.UserDateSet;
import User.test2;
import GoodsDb.DbPrint.DbPrinter;
import GoodsDb.DbDelete.DbDelete;
import GoodsDb.DbUse.DbUse;
import Bot.BotMain;
import Util.UserInput;

import com.google.gson.Gson;
import org.json.simple.JSONObject;



public class Main {
    static Scanner sc = new Scanner(System.in);

    static String userSell;
    static DbAdd dbAdd = new DbAdd();
    static DbUse dbUse = new DbUse();
    static DbDelete dbDelete = new DbDelete();
    static DbPrint dbPrint = new DbPrint();
    static BotMain botMain = new BotMain();

    public static void main(String[] args) {
        login();
    }
    public static void login() {
        UserDateSet.userListSet();
        String n = input( "로그인 1 회원가입 2 를 입력해주세요.");

        if (n.equals("1")) {
            Login.login();
        } else {
            Register.register();
            Login.login();
        }
    }
    public static void mainMenu() {
        System.out.println("\n <메인 메뉴에 들어오셨습니다.> \n");
        System.out.println("\n\n ==========유통기한 알림==========");
        botMain.printAlarm();
        System.out.print("1. 물품 추가 \n 2. 물품 사용 \n 3. 물품 삭제 \n 4. 물품 리스트 출력 \n 5. 자동구매 로그 확인 \n 로그인 메뉴로 돌아가시려면 q를 입력해주세요.");
        userSell = UserInput.selFive("어떤 기능을 선택하시겠습니까? :");
        if (userSell == "q")
            return;
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
        }
        mainMenu();

    }


    public static String input(String meg) {
        System.out.print(meg);
        return sc.next();

    }
}