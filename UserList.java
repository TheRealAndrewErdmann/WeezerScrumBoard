package WeezerScrumBoard;

import java.util.ArrayList;

public class UserList {
    private static UserList userList; 
    private static ArrayList<User> users;

    private UserList(){
        this.userList = userList;
        this.users = users;
    }

<<<<<<< HEAD
    public UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
=======
    public static UserList getInstance(){
        return null;
>>>>>>> ba1ff75b4bf0c14b2b30df630f961ff23581b2c6
    }

    public User getUser(String username){
        return null;
    }
}
