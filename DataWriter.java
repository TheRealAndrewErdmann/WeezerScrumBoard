
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
        userInfo.put(ID, user.getid());
		userInfo.put(FIRST_NAME, user.getfirstName());
		userInfo.put(LAST_NAME, user.getlastName());
		userInfo.put(USER_NAME, user.getuserName());
        userInfo.put(PASSWORD, user.getpassword());
        userInfo.put(EMAIL, user.getemail());
        userInfo.put(PHONE_NUMBER, user.getphoneNum());
        
        return userInfo;
	}

    public void saveProjects(){
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjects();
        JSONArray jsonProjects = new JSONArray();

        for(int i =0; i<projects.size(); i++) {
            jsonProjects.add(getProjectJSON(projects.get(i)));
        }

        try (FileWriter file = new FileWriter("project.json")) {
 
            file.write(jsonProjects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getProjectJSON(Project project) {
        JSONObject projectInfo = new JSONObject();
        projectInfo.put(ID, project.getID());
        projectInfo.put(TITLE, project.getTitle());
        projectInfo.put(DESCRIPTION, project.getDescription());
        projectInfo.put(PARTICIPANTS, project.getParticipants());
        projectInfo.put(COLUMNS, project.getColumns());
        projectInfo.put(COMMENTS, project.getComments());

        return projectInfo;
    }

}