package WeezerScrumBoard;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
public class Column {
    private String columnName;
    private ArrayList<Task> tasks;
    private ArrayList<String> status;

    public Column(String name, Status status) {
        columnName = name;

    }

    public boolean addTask(Task task) {
        return false;
    }

    public boolean removeTask(Task task) {
        return false;
    }
}