
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class FileLoader {   

    public ArrayList<User> getUsers(){

        ArrayList<User> user =  new ArrayList<User>();

        try {
			FileReader reader = new FileReader("user.json");
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get("id"));
                String firstName = (String)userJSON.get("firstName");
                String lastName = (String)userJSON.get("lastName");
                String userName = (String)userJSON.get("userName");
                String password = (String)userJSON.get("password");
                
            }

        return user;
        }

        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;

    }

    public ArrayList<Project> getProjects() {
        return new ArrayList<Project>();
    }
    
}