
import java.util.ArrayList;

public class UserList {
    private static UserList userList = null;
    private ArrayList<User> users;

    private UserList(){
        users = FileLoader.getUsers();
    }

    public static UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public User getUser(String username){
        for(User user : users){
            if(user.getUserName().equals(username))
                return user;
        }
        return null;
    }


}
