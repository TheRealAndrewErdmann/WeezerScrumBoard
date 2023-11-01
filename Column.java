import java.util.ArrayList;

public class Column {
    private String columnName;
    private Project project;
    private ArrayList<Task> tasks;
    private ArrayList<String> status;

    public Column(String name, String status) {
        columnName = name;
        this.tasks = new ArrayList<Task>();
        this.status = new ArrayList<String>();
        this.status.add(status);
    }

    //adds a task to task list
    public boolean addTask(Task task) {
        if(task == null)
            return false;
        return tasks.add(task);
    }

    //removes a task from task list
    public boolean removeTask(Task task) {
        if(task == null)
            return false;
        return tasks.remove(task);

    }

    public String getColumnName() {
        return columnName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<String> getStatus() {
        return status;
    }
}