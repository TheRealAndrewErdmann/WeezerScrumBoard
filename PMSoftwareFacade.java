import java.util.ArrayList;
public class PMSoftwareFacade {

    private User user;
    private UserList userList;
    private ProjectList projectList;
    private Project project1;
    private Project project2;
    private Project project3;
    private Column column1;
    private ArrayList<Project> proj;

    public PMSoftwareFacade() {
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();
        //proj = projectList.getProjects();
        proj = new ArrayList<Project>();
        project1 = new Project("Electric Missles", "Make electric missles");
        project2 = new Project("Soap Free Washers", "Make washers soap free");
        project3 = new Project("Air Computers", "Make air computers");
        proj.add(project1);
        proj.add(project2);
        proj.add(project3);
    }

    public User login(String username, String password) {
        return null;
    }

    public User signup(String username, String password,String email, String phoneNumber) {
        return null;
    }

    public Project createProject(String title, String description) {

        return null;
    }

    public Project findProject(String projectName) {
        for (int i = 0; i < proj.size(); i++) {
            if (projectName == proj.get(i).getTitle()) {
                return projectList.getProject(projectName);
            }
        }
        return projectList.getProject(projectName);
    }

    public void showAllProjects(){
        for (int i = 0; i < proj.size(); i++) {
            System.out.println(proj.get(i).getTitle());
        }
    }

    public void showAllColumns(Project project) {
        ArrayList<Column> columns = project.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            System.out.println(columns.get(i).getColumnName());
        }
    }

}