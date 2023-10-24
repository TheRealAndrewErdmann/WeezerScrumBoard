
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class FileLoader extends FileConstants{   

    public static ArrayList<User> getUsers() {

        ArrayList<User> users =  new ArrayList<User>();

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
                String email = (String)userJSON.get("email");
                String phoneNum = (String)userJSON.get("phoneNum");

                users.add(new User(id, firstName, lastName, userName, password, email, phoneNum));

            }

            return users;
        }

        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;

    }

    //Still working on the getProjects method
    //Commented out to compile for testing getUsers method 
    /*
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();

        try {
			FileReader reader = new FileReader("user.json");
			JSONParser parser = new JSONParser();
			JSONArray projectsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < projectsJSON.size(); i++) {
                JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
                UUID id = UUID.fromString((String)projectJSON.get("id"));
                String title = (String)projectJSON.get("title");
                String description = (String)projectJSON.get("description");
                //Read in hashmap of participants here

                //Read in the array of columns
                JSONArray columns = (JSONArray) projectJSON.get("task");
                for (int j = 0; j < columns.size(); j++) {
                    String name = (String)projectJSON.get("columnName");


                    //Read in the array of tasks in each column
                    //for (int k = 0; k < )

                        //Read in the array of comments and replies on each task

                    //Read in the array of comments and replies on each project
                }
            }
        
        }   
        
        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;
    }
    */
    
}