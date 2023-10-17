
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileWriter{

    public void saveUsers(){
        UserList userList = UserList.getInstance();

    }

    public void saveProjects(){
        JSONObject userDetails = new JSONObject();
		userDetails.put(id, user.getId().toString());
		userDetails.put(username, user.getUserName());
		userDetails.put(firstname, user.getFirstName());
		userDetails.put(lastname, user.getLastName());
        userDetails.put(email, user.email);
		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
    }
}