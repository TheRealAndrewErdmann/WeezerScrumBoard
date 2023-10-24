
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileWriter {

    public void saveUsers(){
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

    }

    public void saveProjects(){
        JSONObject userDetails = new JSONObject();
		userDetails.put(id, user.getId().toString());
		userDetails.put(userName, user.getUserName());
		userDetails.put(firstName, user.getFirstName());
		userDetails.put(lastName, user.getLastName());
        userDetails.put(email, user.email);
		userDetails.put(phoneNum, user.getPhoneNumber());
    }
}