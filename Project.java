
import java.util.Map;
import java.util.ArrayList;
import java.util.UUID;

public class Project {

    private UUID id;
    private String title;
    private String description;
    private Map<Role,User> participants;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    
    public Project(String title, String description){

    }

    public Project(UUID id, String title, String description) {

    }

    public boolean addParticipant(User user) {
        return true;
    }

    public boolean removeParticipant(User user) {
        return true;
    }

    public boolean changeRole(User user, Role newRole) {
        return true;
    }

    public boolean addTask(Task task, String status) {

        return true;
    }

    public boolean changeTaskStatus(Task task, String status) {
        return true;
    }

    public boolean addComment(Comment comment) {
        return true;
    }

    //getters for DataWriter
    public UUID getID(){
        return id;
    }

    public String title(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public Map<Role, User> getParticipants(){
        return participants;
    }

    public ArrayList<Column> getColumns(){
        return columns;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }
}
