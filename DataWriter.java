
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends FileConstants{

    public void saveUsers(){
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(int i =0; i<users.size(); i++) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        try (FileWriter file = new FileWriter("user.json")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public JSONObject getUserJSON(User user) {
		JSONObject userInfo = new JSONObject();
        userInfo.put(ID, user.getID());
		userInfo.put(FIRST_NAME, user.getFirstName());
		userInfo.put(LAST_NAME, user.getLastName());
		userInfo.put(USER_NAME, user.getUserName());
        userInfo.put(PASSWORD, user.getPassword());
        userInfo.put(EMAIL, user.getEmail());
        userInfo.put(PHONE_NUMBER, user.getPhoneNum());
        
        return userInfo;
	}

    public void saveProjects(){

    }
}