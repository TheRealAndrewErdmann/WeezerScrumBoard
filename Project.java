
import java.util.Map;
import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

public class Project {

    private UUID id;
    private String title;
    private String description;
    private Map<Role,ArrayList<User>> participants;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    
    public Project(String title, String description){
        this.title = title;
        this.description = description;
        this.participants = new HashMap<Role, ArrayList<User>>();
        this.columns = new ArrayList<Column>();
        this.comments = new ArrayList<Comment>();
    }

    public Project(UUID id, String title, String description) {
        this(title, description);
        this.id = id;
    }

    public Project(UUID id, String title, String description, Map<Role,ArrayList<User>> participants, ArrayList<Column> columns, ArrayList<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.participants = participants;
        this.columns = columns;
        this.comments = comments;
    }

    public boolean addParticipant(User user, Role role) {
        if(user == null || role == null)
            return false;
        return participants.get(role).add(user);
    }

    public boolean removeParticipant(User user, Role role) {
        if(user == null || role == null)
            return false;
        return participants.get(role).remove(user);
    }

    public boolean changeRole(User user, Role curRole, Role newRole) {
        if(user == null || curRole == null || newRole == null)
            return false;
        if(participants.get(curRole).remove(user) == false)
            return false;
        return participants.get(newRole).add(user);
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

    public UUID getID() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Map<Role, ArrayList<User>> getParticipants() {
        return participants;
    }
    public ArrayList<Column> getColumns() {
        return columns;
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }

}
