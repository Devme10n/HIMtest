package user;

import java.util.*;
public class UserDateSet {

    public static HashMap<String,UserVO> userList = new HashMap<>();
    //키 값은 id로 해 중복 체크도 가능케 했다.

    public static void userListSet() {

        userList.put("1", new UserVO("1","1"));
        userList.put("2", new UserVO("2","2"));
        userList.put("3", new UserVO("3","3"));

    }


}
