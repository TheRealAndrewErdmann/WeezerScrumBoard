import java.util.ArrayList;

public class Column {
    private String columnName;
    private ArrayList<Task> tasks;
    private ArrayList<String> status;

    public Column(String name, String status) {
        columnName = name;
        this.status.add(status);
    }

    public boolean addTask(Task task) {
        return false;
    }

    public boolean removeTask(Task task) {
        return false;
    }
}