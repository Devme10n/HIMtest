package user;

import main.Main;

public class Login {



    public static void login() {

        int cnt = 0;

        System.out.println("========= check page ==========");
        while(true){

            String id= Main.input("ID? : ");
            String password =Main.input("PW? : ");
            if(!UserDateSet.userList.containsKey(id)) //널값 미 체크시 널 포인트 오류가 뜬다.
                System.out.println("not found");
            else {


                if(UserDateSet.userList.get(id).getPassword().equals(password)) {
                    System.out.println("success.");
                    break;
                }
                else {
                    System.out.println("false: plz retry");
                    cnt++;
                }
                if(cnt ==3) {//카운터 값을 줘 3번 실패시 회원가입 창으로 넘어가게 했다.
                    System.out.println("false: stop don't do that");
                    Register.register();
                }

            }
        }


    }


}