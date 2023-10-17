
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileWriter{

    public void saveUsers(){
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

    }

    public void saveProjects(){

    }
}