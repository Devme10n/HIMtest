package User;

import java.util.*;
public class UserDateSet {

    public static HashMap<String,UserVO> userList = new HashMap<>();
    //키 값은 id로 해 중복 체크도 가능케 했다.

    public static void userListSet() {
        userList.put("진영", new UserVO("진영","1234"));

    }


}
