package User;

import Main.Main;

public class Register {

    public static void register() {

        System.out.println("========= 회원 가입 ==========");
        while(true) {
            String id = Main.input("ID를 입력하세요 : ");

            if(UserDateSet.userList.containsKey(id)) {// id를 해쉬 값으로 넣어 중복 체크를 할 수 있도록 했다.
                System.out.println("이미 존재하는 계정입니다.");
            }
            else {
                String password = Main.input("PW를 입력하세요 : ");
                System.out.println("회원가입을 축하합니다.");
                UserDateSet.userList.put(id,new UserVO(id,password));
                break;
            }

        }

    }
}