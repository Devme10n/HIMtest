package main;

import java.util.*;

import goodsDb.Db;
import goodsDb.DbAdd;
import util.UserInput;
import goodsDb.*;
import user.Login;
import user.Register;
import user.UserDateSet;
import user.test2;

import com.google.gson.Gson;
import org.json.simple.JSONObject;



public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Calendar date1 = Calendar.getInstance();

        String s1 = "2016";
        int i1 = Integer.parseInt(s1);
        date1.set(i1, 7, 15);
        System.out.println(date1);



        Gson gson = new Gson();

        String asdf = input( "name에 넣을 값은? :");

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


        UserDateSet.userListSet();
        System.out.println("====님 회원임?====");
        String n = input( "member is 1 or not 2");

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