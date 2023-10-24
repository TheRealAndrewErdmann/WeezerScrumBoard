
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

    //main method 
    //Still working on the getProjects method
    //Commented out to compile for testing getUsers method 
    
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();

        try {
			FileReader reader = new FileReader("project.json");
			JSONParser parser = new JSONParser();
			JSONArray projectsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < projectsJSON.size(); i++) {
                JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
                UUID id = UUID.fromString((String)projectJSON.get("id"));
                String title = (String)projectJSON.get("title");
                String description = (String)projectJSON.get("description");

                //Read in hashmap of participants
                JSONArray participants = (JSONArray) projectJSON.get("participants");
                for (int j = 0; j < participants.size(); j++) {
                    JSONObject participantJSON = (JSONObject)participants.get(i);
                    String role = (String)projectJSON.get("role");
                    UUID user = UUID.fromString((String)projectJSON.get("user"));
                }

                //Read in the array of columns
                JSONArray columns = (JSONArray) projectJSON.get("columns");
                for (int k = 0; k < columns.size(); k++) {
                    //make json object for column
                    JSONObject columnJSON = (JSONObject)columns.get(i);
                    String name = (String)columnJSON.get("columnName");

                    //Read in the array of tasks in each column
                    JSONArray tasks = (JSONArray) projectJSON.get("task");
                    for (int l = 0; l < tasks.size(); l++) {
                        JSONObject taskJSON = (JSONObject)columns.get(i);
                        UUID idTask = UUID.fromString((String)taskJSON.get("id"));
                        String taskName = (String)columnJSON.get("taskName");
                        String taskDescription = (String)columnJSON.get("taskDescription");
                        String category = (String)columnJSON.get("category");
                        String priority = (String)columnJSON.get("priority");
                    
                        //Read in the array of comments and replies on each task
                        JSONArray comments = (JSONArray) projectJSON.get("comments");
                        for (int m = 0; m < tasks.size(); m++) {
                            JSONObject commentJSON = (JSONObject)comments.get(i);
                            UUID author = UUID.fromString((String)commentJSON.get("author"));
                            String comment = (String)commentJSON.get("comment");
                            String date = (String)commentJSON.get("date");

                            JSONArray replies = (JSONArray) projectJSON.get("replies");
                            for (int n = 0; n < tasks.size(); n++) {
                                JSONObject replyJSON = (JSONObject)replies.get(i);
                                UUID authorReply = UUID.fromString((String)commentJSON.get("author"));
                                String reply = (String)commentJSON.get("comment");
                                String dateReply = (String)commentJSON.get("date");
                            }
                        }
                    }
                    
                    //read in the array of changes on each task
                    JSONArray changes = (JSONArray) projectJSON.get("changes");
                    for (int o = 0; o < tasks.size(); o++) {
                        JSONObject changeJSON = (JSONObject)changes.get(i);
                        String changeDescription = (String)changeJSON.get("changeDescription");
                        String changeAuthor = (String)changeJSON.get("changeAuthor");
                        String changeDate = (String)changeJSON.get("changeDate");
                    }
                    String status = (String)columnJSON.get("status");
                }

                //read in the array of comments and replies for projects
                JSONArray comments = (JSONArray) projectJSON.get("comments");
                        for (int m = 0; m < projectsJSON.size(); m++) {
                            JSONObject commentJSON = (JSONObject)comments.get(i);
                            UUID author = UUID.fromString((String)commentJSON.get("author"));
                            String comment = (String)commentJSON.get("comment");
                            String date = (String)commentJSON.get("date");

                            JSONArray replies = (JSONArray) projectJSON.get("replies");
                            for (int n = 0; n < projectJSON.size(); n++) {
                                JSONObject replyJSON = (JSONObject)replies.get(i);
                                UUID authorReply = UUID.fromString((String)commentJSON.get("author"));
                                String reply = (String)commentJSON.get("comment");
                                String dateReply = (String)commentJSON.get("date");
                            }
                        }

                projects.add(new Project(id, title, description, participants, columns, comments));
            }
        
        }   
        
        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;
    }
    
}