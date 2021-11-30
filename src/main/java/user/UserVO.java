package user;

public class UserVO { // 우선 간단하게 id password만 담도록 했다.
    private String id;
    private String password;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;


    }
    public UserVO(String id, String password) {
        super();
        this.id = id;
        this.password = password;
    }



}
