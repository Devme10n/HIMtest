package User;

import java.util.*;
public class UserDateSet {

    public static HashMap<String,UserVO> userList = new HashMap<>();
    //키 값은 id로 해 중복 체크도 가능케 했다.

    public static void userListSet() {
        userList.put("진영", new UserVO("1","1"));
        userList.put("수빈", new UserVO("2","2"));
        userList.put("승규", new UserVO("3","3"));
    }


}
