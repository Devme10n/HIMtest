package Main;

import java.util.*;

import GoodsDb.Db;
import GoodsDb.DbAdd.DbAdd;
import User.Login;
import User.Register;
import User.UserDateSet;
import User.test2;
import GoodsDb.DbPrint.DbPrinter;

import com.google.gson.Gson;
import org.json.simple.JSONObject;



public class Main {
    static Scanner sc = new Scanner(System.in);

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

        DbAdd add = new DbAdd();

        add.add();
        printertest.allGoodsPrint();
        add.add();
        printertest.allGoodsPrint();
        add.add();
        printertest.allGoodsPrint();


        UserDateSet.userListSet();
        String n = input( "로그인 1 회원가입 2 를 입력해주세요.");

        if (n.equals("1")) {
            Login.login();
        } else {
            Register.register();
            Login.login();
        }

        System.out.println("\n" +
                "⡿⢯⠷⡫⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠓⢋⣭⣷⠶⢶⣾⡛⠛⠉⠉⠉⠉⢉⡙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣟\n" +
                "⣴⣶⣛⣱⣄⣆⡏⠙⣿⣿⡿⠟⠁⠀⢀⣴⠟⠉⣠⠞⠉⡼⠁⠀⠀⢄⠀⠀⠀⠀⠉⠒⠦⣉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢟⠡⢁\n" +
                "⠭⢀⢖⢯⠞⡷⠯⠂⢨⠋⠄⠀⠀⢠⠋⠀⠀⡴⠁⠀⠀⠁⠀⠀⠀⠀⢱⡄⠀⠀⠀⠀⠠⡀⠑⠆⠙⢿⣿⣿⣿⣿⣿⣿⣿⢿⡕⣑⠔⠋\n" +
                "⣤⣀⡀⠘⠀⢉⣿⡳⠁⠀⠀⠀⡰⠁⠀⠀⡸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡄⠀⠀⢠⡀⠘⠆⠀⠘⢷⡝⣿⣿⣿⣿⣿⣟⡽⠛⢹⢀⡤\n" +
                "⣿⣧⣤⠴⣁⠜⣻⠁⠀⠀⠀⠀⠀⢠⠀⠀⠃⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⢿⡄⠀⠀⠁⣄⠘⣧⠀⠀⠹⣮⢿⣿⣿⡟⡯⠀⣀⠞⠋⠀\n" +
                "⣿⣿⣷⣿⡿⢥⡏⠀⠀⠀⢀⠁⠀⡆⠀⠀⠀⠀⡀⠀⠀⠀⠀⣧⠀⠀⠀⠀⠈⣷⠀⠀⢣⢹⣆⠸⣧⠸⠀⠹⣧⣯⣿⠁⣇⠞⠁⠀⣀⠜\n" +
                "⡿⣿⣮⡟⣿⣿⠀⣸⠀⠀⠀⠀⢀⡁⠀⢀⠀⠀⡁⠀⡀⡄⠀⣾⡆⠀⡀⢸⡀⢻⣡⢀⢸⡆⣿⣆⢻⡆⡇⠀⠹⣽⠗⠊⠁⠀⡠⠚⠁⠀\n" +
                "⣾⣿⢿⣿⣭⡟⠀⡇⠀⠀⡆⠀⢸⠃⠀⢸⠀⢸⣧⠀⢃⣿⡀⣿⣷⠀⡇⢸⣇⢸⡟⡎⡌⣧⣰⣿⣜⣧⣇⠘⡄⢻⢋⣀⡼⠊⠀⠀⠀⠀\n" +
                "⣿⠿⣿⣿⢿⡇⣸⡇⠀⠀⠁⠀⢸⡂⠐⡌⡄⢸⡿⡆⢸⣿⡇⣿⣸⡄⣿⣿⣿⢸⡗⢻⢿⣿⣼⢟⣷⣿⡏⠀⢸⡘⡜⡇⠀⠀⠀⠀⠀⢰\n" +
                "⣿⢿⡷⠷⣾⣇⣿⢁⠀⠀⠀⠀⢸⡇⠀⡇⣇⢹⡇⢃⣸⣿⣺⣿⡋⡇⣿⣿⣿⣼⠃⠸⣾⣿⡟⢘⣻⣿⣿⡇⠸⣱⠏⣿⠀⠀⠀⠀⠀⢸\n" +
                "⣷⣏⣹⣿⣿⣿⣿⢸⠀⠀⡇⠀⢸⣷⠀⢷⢸⣸⡗⢙⣸⣿⣻⣿⡂⠃⣿⣿⠉⣿⠀⢀⣧⣿⣿⣿⡻⡿⣿⣧⠀⡛⡆⠃⠀⠀⠀⠀⠀⢠\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠃⠀⠀⣿⡆⢸⡆⣟⡇⠘⣿⡯⢀⣯⡀⢸⢻⠃⠀⡟⠀⠸⡁⡩⣿⠻⠇⠇⣿⣿⠰⠃⠃⠀⠀⠀⠀⠀⠀⣾\n" +
                "⣿⣿⣾⠿⢹⣿⣿⡇⠀⠀⢸⠀⠀⢹⣿⣀⡿⣸⣧⣴⣾⣿⣿⣿⡛⠘⠀⠀⠀⠁⠀⠀⠳⣝⣋⢜⠄⠀⣿⣿⡀⡇⠀⠀⠀⠀⠀⠀⠀⣿\n" +
                "⠻⡓⠙⠛⣿⢸⣿⣇⠀⠀⡜⣧⢀⠈⣿⣷⣾⣷⡟⣇⣼⡾⢿⠻⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⢿⣿⡇⢸⠊⠀⠀⠀⠀⠀⠀⣿\n" +
                "⣿⠿⠤⠀⣿⢸⣿⣿⠀⠀⡇⣿⣞⡄⢹⣿⣿⣇⠙⠊⠣⢭⡥⣞⠄⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⢹⡇⠀⠀⠀⠀⠀⡒⡸\n" +
                "⠛⠃⠀⢠⢻⢸⣿⣿⡀⢰⡇⣿⣏⢿⡀⢿⣿⣮⠁⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣷⢸⣿⡀⣁⠀⢀⢪⡛⣱\n" +
                "⠀⠀⠀⢸⢸⢸⣿⣿⡇⠘⣿⣿⣿⣜⣿⡈⣿⣯⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⠈⣿⣇⠉⠑⠗⠌⠛⠛\n" +
                "⠀⠀⠀⠸⡆⣿⣿⣿⣿⠀⣿⣿⢿⡿⣿⣇⠸⣿⣞⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠀⠀⠀⢀⣴⣿⣿⣿⢻⡀⣿⣿⣤⣤⣤⣤⣤⣼\n" +
                "⠀⠀⠀⣷⣻⣿⣿⣿⣿⡆⢸⡏⣺⣷⣿⣿⡀⢿⣿⣞⡽⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⠇⣿⣿⣹⣿⣿⣿⣿⣿\n" +
                "⠀⠀⢠⠙⣽⣿⣿⣿⣿⣇⠄⢿⣿⣿⣿⣿⣇⠘⣿⣿⣿⣽⣥⣯⣖⣆⣤⡤⣄⣀⣀⣀⣴⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⡏⣿⣿⣿⣿⣿\n" +
                "⠀⣐⢍⡄⣿⣿⣿⣿⣿⣿⢸⢸⣿⣿⣿⣿⣿⠀⢻⣿⣿⣿⣿⣜⣽⢿⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⡇⢻⣿⣿⣿⣿\n" +
                "⠞⢣⡞⣸⣿⣿⣿⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⡇⢸⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢠⣿⣿⣇⢸⣿⣿⣿⣿\n" +
                "⣰⢟⣾⣿⣿⣿⣿⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⣇⡆⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⢸⣿⣿⣿⠸⣿⣿⣿⣿\n" +
                "⢏⣾⣿⣿⣿⣿⣿⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⣾⣿⣿⣿⣤⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣾⣷⣿⣿⣿⣿⣿⣿⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢱⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⡿⣽⣿⣿⣿⣿⣿⣿⣿⣱⡿⣼⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢹⣿⣿⣿⣿\n");
    }

    public static String input(String meg) {
        System.out.print(meg);
        return sc.next();
    }
}