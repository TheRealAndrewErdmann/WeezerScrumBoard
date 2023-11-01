import java.util.ArrayList;

public class Column {
    private String columnName;
    private ArrayList<Task> tasks;
    private ArrayList<String> status;

    public Column(String name, String status) {
        columnName = name;
        this.tasks = new ArrayList<Task>();
        this.status.add(status);
    }

    //adds a task to task list
    public boolean addTask(Task task) {
        if (tasks.add(task)) {
            return true;
        }
        else if (task == null) {
            return false;
        }
        else {
            return false;
        }
    }

    //removes a task from task list
    public boolean removeTask(Task task) {
        if (tasks.remove(task)) {
            return true;
        }
        else if (task == null) {
            return false;
        }
        else {
            return false;
        }
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