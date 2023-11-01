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
        if(task == null)
            return false;
        return tasks.add(task);
    }

    public boolean removeTask(Task task) {
        if(task == null)
            return false;
        return tasks.remove(task);

    }

    public String getColumnName() {
        return columnName;
    }
}