package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans;

public class User {
    private int userId;
    private String password;
    private String username;




    public User(int  userId, String username, String password) {
        this.userId = userId;
        this.password = password;
        this.username = username;


    }

    public User() { }

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int user_id) {
        this.userId = user_id;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}
