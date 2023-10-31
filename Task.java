import java.util.ArrayList;
import java.util.UUID;

public class Task {
    private UUID id;
    private Project project;
    private String taskName;
    private String taskDescription;
    private Category category;
    private Priority priority;
    private String status;
    private ArrayList<Comment> comments;
    private ArrayList<Change> changes;

    public Task(Project project, String taskName, String taskDescription, Category category, Priority priority){
        this.project = project;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.category = category;
        this.priority = priority;
        comments = new ArrayList<Comment>();
        changes = new ArrayList<Change>();
    }
    
    public boolean changeStatus(String newStatus){
        if(status == null)
            return false;
        return project.changeTaskStatus(this, status, newStatus);
    }

    public boolean changeDescription(String description){
        if(description == null)
            return false;
        taskDescription = description;
        return true;
    }

    public boolean changePriority(Priority priority){
        if(priority == null)
            return false;
        this.priority = priority;
        return true;
    }

    public boolean addComment(Comment comment){
        if(comment == null)
            return false;
        return comments.add(comment);
    }

    public boolean setStatus(String status) {
        if(status == null)
            return false;
        this.status = status;
        return true;
    }
}
