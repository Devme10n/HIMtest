package user;

import main.Main;

public class Register {

    public static  void register() {

        System.out.println("========= sign page ==========");
        while(true) {
            String id = Main.input("ID : ");

            if(UserDateSet.userList.containsKey(id)) {// id를 해쉬 값으로 넣어 중복 체크를 할 수 있도록 했다.
                System.out.println("false: enter other id ");
            }
            else {
                String password = Main.input("PW : ");
                System.out.println("Success");
                UserDateSet.userList.put(id,new UserVO(id,password));
                break;
            }

        }

    }
}