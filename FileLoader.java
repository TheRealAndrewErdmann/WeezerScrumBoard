
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
                String firstName= (String)userJSON.get("firstName");
                String lastName = (String)userJSON.get("lastName");
                String userName = (String)userJSON.get("userName");
                String password = (String)userJSON.get("password");
                String email    = (String)userJSON.get("email");
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
    
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();
        ArrayList<Column> columns = new ArrayList<Column>();
        ArrayList<Comment> taskComments = new ArrayList<Comment>();
        ArrayList<Comment> taskReplies = new ArrayList<Comment>();
        ArrayList<Change> changes = new ArrayList<Change>();
        Map<Role, ArrayList<User>> participantsMap = new HashMap<Role, ArrayList<User>>();


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
                JSONArray columnsJSON = (JSONArray) projectJSON.get("columns");
                for (int k = 0; k < columns.size(); k++) {
                    //make json object for column
                    JSONObject columnJSON = (JSONObject)columnsJSON.get(i);
                    String columnName = (String)columnJSON.get("columnName");

                    //Read in the array of tasks in each column
                    ArrayList<Task> tasks = new ArrayList<Task>();
                    JSONArray tasksJSON = (JSONArray) projectJSON.get("task");
                    for (int l = 0; l < tasks.size(); l++) {
                        JSONObject taskJSON = (JSONObject)columnsJSON.get(i);
                        UUID idTask = UUID.fromString((String)taskJSON.get("id"));
                        String taskName = (String)columnJSON.get("taskName");
                        String taskDescription = (String)columnJSON.get("taskDescription");
                        Category category = (Category)columnJSON.get("category");
                        String priority = (String)columnJSON.get("priority");
                    
                        //Read in the array of comments and replies on each task
                        JSONArray commentsJSON = (JSONArray) projectJSON.get("comments");
                        for (int m = 0; m < tasks.size(); m++) {
                            JSONObject commentJSON = (JSONObject)commentsJSON.get(i);
                            User author = (User)commentJSON.get("author");
                            String comment = (String)commentJSON.get("comment");
                            String date = (String)commentJSON.get("date");
                            taskComments.add(new Comment(author, comment));

                            JSONArray repliesJSON = (JSONArray) projectJSON.get("replies");
                            for (int n = 0; n < tasks.size(); n++) {
                                JSONObject replyJSON = (JSONObject)repliesJSON.get(i);
                                User authorReply = (User)commentJSON.get("author");
                                String reply = (String)commentJSON.get("comment");
                                String dateReply = (String)commentJSON.get("date");
                                taskReplies.add(new Comment(authorReply, reply));
                            }

                            //read in the array of changes on each task
                            JSONArray changesJSON = (JSONArray) projectJSON.get("changes");
                            for (int o = 0; o < tasks.size(); o++) {
                                JSONObject changeJSON = (JSONObject)changesJSON.get(i);
                                String changeDescription = (String)changeJSON.get("changeDescription");
                                User changeAuthor = (User)changeJSON.get("changeAuthor");
                                changes.add(new Change(changeDescription, changeAuthor));
                            }
                            
                        }
                        tasks.add(new Task(taskName, taskDescription, category, priority));
                        // tasks.add(new Task("taskName", "taskDescription", "category", "priority"));

                    }

                    String status = (String)columnJSON.get("status");
                    columns.add(new Column(columnName, status));
                }

                //read in the array of comments and replies for projects
                JSONArray commentsJSON = (JSONArray) projectJSON.get("comments");
                ArrayList<Comment> comments = new ArrayList<Comment>();
                ArrayList<Comment> replies = new ArrayList<Comment>();
                        for (int m = 0; m < projectsJSON.size(); m++) {
                            JSONObject commentJSON = (JSONObject)commentsJSON.get(i);
                            User author = (User)commentJSON.get("author");
                            String comment = (String)commentJSON.get("comment");
                            String date = (String)commentJSON.get("date");
                            comments.add(new Comment(author, comment));

                            JSONArray repliesJSON = (JSONArray) projectJSON.get("replies");
                            for (int n = 0; n < projectJSON.size(); n++) {
                                JSONObject replyJSON = (JSONObject)repliesJSON.get(i);
                                User authorReply = (User)commentJSON.get("author");
                                String reply = (String)commentJSON.get("comment");
                                String dateReply = (String)commentJSON.get("date");
                                replies.add(new Comment(authorReply, reply));
                            }
                        }
                        projects.add(new Project(id, title, description, participantsMap, columns, comments));
            }
        }   
        
        
        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;
    }
    
}