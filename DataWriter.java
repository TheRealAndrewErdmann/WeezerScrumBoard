
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends FileConstants{

    /**
     * This method adds users to the UserList array list.
     * @author Alex Dupree
     */
    public static void saveUsers(){
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(int i =0; i<users.size(); i++) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        //change "userTest.json" to "JSON/user.json" when done testing
        //also delete userTest.json when done testing
        try (FileWriter file = new FileWriter("userTest.json")) {

            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method puts the info from the JSON files into a JSONObject map using parallel information from the user class.
     * @param user the user
     * @return returns a JSON Object
     * @author Andrew Erdmann
     */
    public static JSONObject getUserJSON(User user) {
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
    
    /**
     * This method adds a project to the project list
     * @author Andrew Erdmann
     */
    public static void saveProjects(){
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjects();
        JSONArray jsonProjects = new JSONArray();

        for(int i =0; i<projects.size(); i++) {
            jsonProjects.add(getProjectJSON(projects.get(i)));
        }

        //change "projectTest.json" to "JSON/project.json" when done testing
        //also delete projectTest.json when done testing
        try (FileWriter file = new FileWriter("projectTest.json")) {
 
            file.write(jsonProjects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method gets information for the project
     * @param project information is retrieved using this
     * @return returns a JSONObject called projectInfo which holds all the information for the project
     */
    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectInfo = new JSONObject();
        projectInfo.put(ID, project.getID());
        projectInfo.put(TITLE, project.getTitle());
        projectInfo.put(DESCRIPTION, project.getDescription());
        projectInfo.put(PARTICIPANTS, project.getParticipants());
        projectInfo.put(COLUMNS, project.getColumns());
        projectInfo.put(COMMENTS, project.getComments());

        return projectInfo;
    }

    //main method for testing (delete when done testing)
    public static void main(String[] args) {
        saveUsers();
        //saveProjects();
    }

}