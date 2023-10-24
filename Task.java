import java.util.ArrayList;
import java.util.UUID;

public class Task {
    private UUID id;
    private String taskName;
    private String taskDescription;
    private Category category;
    private Priority priority;
    private ArrayList<Comment> comments;
    private ArrayList<Change> changes;

    public Task task(String taskName, String taskDescription, Category category, String priority){
        return task(taskName, taskDescription, category, priority);
    }
    
    public boolean changeStatus(String status){
        return true;
    }

    public boolean changeDescription(String description){
        return true;
    }

    public boolean changePriority(Priority priority){
        return true;
    }

    public boolean addComment(Comment comment){
        return true;
    }
}
