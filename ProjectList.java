
import java.util.ArrayList;

public class ProjectList {

    private static ProjectList projectList;
    private static ArrayList<Project> projects;
    
    private ProjectList(){
        
    }

    public static ProjectList getInstance(){
        return null;
    }

    public Project getProject(String title){
        return new Project("", "");
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
}

