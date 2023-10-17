import java.util.ArrayList;

public class Task {
    private UUID Id;
    private String taskName;
    private String taskDescription;
    private Category category;
    private Priority priority;
    private ArrayList<Comment> comments;
    private ArrayList<Change> changes;

    public Task Task(String taskName, String taskDescription, Category category, String priority){
        return Task(taskName, taskDescription, category, priority);
    }
    
    public boolean changeStatus(Status status){
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
