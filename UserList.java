package WeezerScrumBoard;

import java.util.ArrayList;

public class UserList {
    private static UserList userList; 
    private static ArrayList<User> users;

    private UserList(){
        this.userList = userList;
        this.users = users;
    }

    public UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public static UserList getInstance(){
        return null;
    }

    public User getUser(String username){
        return null;
    }
}
