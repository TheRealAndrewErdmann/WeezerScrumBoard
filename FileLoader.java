
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class FileLoader extends FileConstants{  

    public static ArrayList<User> getUsers() {

        ArrayList<User> users =  new ArrayList<User>();

        try {
			FileReader reader = new FileReader("JSON/scenarioUsers.json");
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get("id"));
                String firstName = (String)userJSON.get("first-name");
                String lastName = (String)userJSON.get("last-name");
                String userName = (String)userJSON.get("user-name");
                String password = (String)userJSON.get("password");
                String email    = (String)userJSON.get("email");
                String phoneNum = (String)userJSON.get("phone-number");

                users.add(new User(id, firstName, lastName, userName, password, email, phoneNum));

            }

            return users;
        }

        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;

    }
    
    public static ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();
        ArrayList<Column> columns = new ArrayList<Column>();
        ArrayList<Comment> taskComments = new ArrayList<Comment>();
        ArrayList<Comment> taskReplies = new ArrayList<Comment>();
        ArrayList<Change> changes = new ArrayList<Change>();
        ArrayList<User> userlist = new ArrayList<User>();
        //ArrayList<String> userslist = new ArrayList<String>();
        Map<String, ArrayList<User>> participantsMap = new HashMap<String, ArrayList<User>>();


        try {
			FileReader reader = new FileReader("JSON/project.json");
			JSONParser parser = new JSONParser();
			JSONArray projectsJSON = (JSONArray)new JSONParser().parse(reader);


            for (int i = 0; i < projectsJSON.size(); i++) {
                JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
                UUID id = UUID.fromString((String)projectJSON.get("id"));
                String title = (String)projectJSON.get("title");
                String description = (String)projectJSON.get("description");

                //Read in hashmap of participants
                JSONArray participantsJSON = (JSONArray) projectJSON.get("participants");
                //JSONArray usersHashJson = (JSONArray) projectJSON.get("user");
                for (int j = 0; j < participantsJSON.size(); j++) {
                    JSONObject participantJSON = (JSONObject)participantsJSON.get(j);
                    //JSONObject userListJSON = (JSONObject)usersHashJson.get(i);
                    String role = (String)participantJSON.get("role");
                    //for (int x = 0; x < participantsJSON.size(); x++) {
                        //userslist.add((String) participantsJSON.get(x));
                    //}
                    //JSONArray users = (JSONArray)participantJSON.get("user");
                    //userslist.add(user);

                    //userlist.add(user);
                    //for (int o = 0; o < userlist.size(); o++) {
                    //    System.out.println(userlist.get(o).getFirstName());
                    //}
                    participantsMap.put(role, userlist);
                }

                //Read in the array of columns
                JSONArray columnsJSON = (JSONArray) projectJSON.get("columns");
                for (int k = 0; k < columnsJSON.size(); k++) {
                    JSONObject columnJSON = (JSONObject)columnsJSON.get(k);
                    String columnName = (String)columnJSON.get("columnName");

                    //Read in the array of tasks in each column
                    ArrayList<Task> tasks = new ArrayList<Task>();
                    JSONArray tasksJSON = (JSONArray) projectJSON.get("task");
                    for (int l = 0; l < tasks.size(); l++) {
                        JSONObject taskJSON = (JSONObject)tasksJSON.get(l);
                        UUID idTask = UUID.fromString((String)taskJSON.get("id"));
                        String taskName = (String)taskJSON.get("taskName");
                        String taskDescription = (String)taskJSON.get("taskDescription");
                        Category category = (Category)taskJSON.get("category");
                        String priority = (String)taskJSON.get("priority");
                    
                        //Read in the array of comments and replies on each task
                        //ArrayList<Comment> taskComments = new ArrayList<Comment>();
                        JSONArray taskCommentsJSON = (JSONArray) projectJSON.get("comments");
                        for (int m = 0; m < taskComments.size(); m++) {
                            JSONObject taskCommentJSON = (JSONObject)taskCommentsJSON.get(i);
                            String author = (String)taskCommentJSON.get("author");
                            String comment = (String)taskCommentJSON.get("comment");
                            String date = (String)taskCommentJSON.get("date");
                            taskComments.add(new Comment(author, comment));

                            JSONArray taskRepliesJSON = (JSONArray) projectJSON.get("replies");
                            for (int n = 0; n < tasks.size(); n++) {
                                JSONObject taskReplyJSON = (JSONObject)taskRepliesJSON.get(i);
                                String authorReply = (String)taskReplyJSON.get("author");
                                String reply = (String)taskReplyJSON.get("comment");
                                String dateReply = (String)taskReplyJSON.get("date");
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
                        tasks.add(new Task((Project)projectsJSON.get(i),taskName, taskDescription, category, priority));

                    }

                    String status = (String)columnJSON.get("status");
                    columns.add(new Column(columnName, status));
                }

                //read in the array of comments and replies for projects
                JSONArray commentsJSON = (JSONArray) projectJSON.get("comments");
                ArrayList<Comment> comments = new ArrayList<Comment>();
                ArrayList<Comment> replies = new ArrayList<Comment>();
                        for (int m = 0; m < projectsJSON.size(); m++) {
                            JSONObject commentJSON = (JSONObject)commentsJSON.get(m);
                            String author = (String)commentJSON.get("author");
                            String comment = (String)commentJSON.get("comment");
                            String date = (String)commentJSON.get("date");
                            comments.add(new Comment(author, comment));

                            JSONArray repliesJSON = (JSONArray) projectJSON.get("replies");
                            //checks if replies array list is empty
                            if (repliesJSON != null && !repliesJSON.isEmpty())
                            for (int n = 0; n < projectJSON.size(); n++) {
                                JSONObject replyJSON = (JSONObject)repliesJSON.get(i);
                                String authorReply = (String)commentJSON.get("author");
                                //UUID authorReply = UUID.fromString((String)commentJSON.get("author"));
                                String reply = (String)commentJSON.get("comment");
                                String dateReply = (String)commentJSON.get("date");
                                replies.add(new Comment(authorReply, reply));
                            }
                        }
                        projects.add(new Project(id, title, description, participantsMap, columns, comments));
            }
            return projects;
        }   
    
        
        catch (Exception e) {
		    e.printStackTrace();
        }

        return null;
    }
    
    //main method for testing (delete when done testing)
    public static void main(String[] args) {
        ArrayList<User> printUsers = getUsers();
        for (int i = 0; i < printUsers.size(); i++) {
            System.out.println(printUsers.get(i).getID());
            System.out.println(printUsers.get(i).getFirstName());
            System.out.println(printUsers.get(i).getLastName());
            System.out.println(printUsers.get(i).getUserName());
            System.out.println(printUsers.get(i).getPassword());
            System.out.println(printUsers.get(i).getEmail());
            System.out.println(printUsers.get(i).getPhoneNum());
            System.out.println();
        }
        
        // /* 
        ArrayList<Project> printProjects = new ArrayList<Project>();
        printProjects = getProjects();
        ArrayList<Comment> printComments;
        ArrayList<Column> printColumn;
        for (int i = 0; i < printProjects.size(); i++) {
            System.out.println(printProjects.get(i).getID());
            System.out.println(printProjects.get(i).getTitle());
            System.out.println(printProjects.get(i).getDescription());
            System.out.println(printProjects.get(i).getParticipants());
            System.out.println(printProjects.get(i).getColumns());

            printColumn = printProjects.get(i).getColumns();
            for (int k = 0; k < printColumn.size(); k++) {
                System.out.println(printColumn.get(k).getColumnName());
            }

            System.out.println(printProjects.get(i).getComments());
            printComments = printProjects.get(i).getComments();

            for (int j = 0; j < printComments.size(); j++) {
                System.out.println(printComments.get(j).getComment());
            }
            System.out.println();
        }
        // */

        //ArrayList<Task> printTasks =
        //for (int i = 0; i < columns.size(); i++){

        //}

        

    }
}