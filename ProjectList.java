
import java.util.ArrayList;

public class ProjectList {

    private static ProjectList projectList;
    private ArrayList<Project> projects;
    
    private ProjectList(){
        
    }

    public ProjectList getInstance(){
        return null;
    }

    public Project getProject(String title){
        return new Project("", "");
    }
}

