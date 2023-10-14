package WeezerScrumBoard;
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

}
