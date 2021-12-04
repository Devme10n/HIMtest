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

    static UserInput userInput = new UserInput();
    static String userSell;
    static DbAdd dbAdd = new DbAdd();
    static DbUse dbUse = new DbUse();
    static DbDelete dbDelete = new DbDelete();
    static DbPrint dbPrint = new DbPrint();
    static BotMain botMain = new BotMain();

    public static void main(String[] args) {

        DbPrinter printertest = new DbPrinter();
        printertest.eatGoodsPrint();

        Calendar date1 = Calendar.getInstance();


        String s1 = "2016";
        int i1 = Integer.parseInt(s1);
        date1.set(i1, 7, 15);
        System.out.println(date1);



        Gson gson = new Gson();


        String asdf = input( "name에 넣을 값은? :");
        System.out.println("asdf");

        JSONObject jsonObjectt = new JSONObject();
        jsonObjectt.put("name", asdf);
        jsonObjectt.put("id", 1);
        String jsonStr = gson.toJson(jsonObjectt);

        System.out.println(jsonStr);
        jsonObjectt.put("id", 2);

        jsonStr = gson.toJson(jsonObjectt);

        System.out.println(jsonStr);

        test2.test22();
        Db test12 = Db.getInstance();

        botMain.main();

        DbAdd add = new DbAdd();
        DbDelete delete = new DbDelete();
        DbUse use = new DbUse();

        add.add();
        botMain.printAlarm();
        use.use();
        printertest.allGoodsPrint();
        botMain.printBotLog();
        add.add();
        delete.delete();
        printertest.allGoodsPrint();
        use.use();
        add.add();
        printertest.allGoodsPrint();
        String testString;
        int testInt = 1;
        testString = "asfd" + testInt;


    }
    public void login() {
        UserDateSet.userListSet();
        String n = input( "로그인 1 회원가입 2 를 입력해주세요.");

        if (n.equals("1")) {
            Login.login();
        } else {
            Register.register();
            Login.login();
        }
    }
    public void mainMenu() {
        System.out.println("\n <메인 메뉴에 들어오셨습니다.> \n");
        botMain.printAlarm();
        System.out.print("1. 물품 추가 \n 2. 물품 사용 \n 3. 물품 삭제 \n 4. 물품 리스트 출력 \n 5. 자동구매 로그 확인 \n 로그인 메뉴로 돌아가시려면 q를 입력해주세요.");
        userSell = userInput.selFive("어떤 기능을 선택하시겠습니까? :");
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