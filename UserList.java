package WeezerScrumBoard;

import java.util.ArrayList;

public class UserList {
    private static UserList userList; 
    private ArrayList<User> users;

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

    public User getUser(String username){
        return null;
    }
}
