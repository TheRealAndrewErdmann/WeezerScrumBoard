import java.util.ArrayList;
public class PMSoftware {

    private User user;
    private UserList userList;
    private ProjectList projectList;
    private Project project1;
    private Project project2;
    private Project project3;
    private ArrayList<Project> projects;

    public PMSoftware() {
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();
        
        projects = new ArrayList<Project>();
        project1 = new Project("Electric Missles", "Make electric missles");
        project2 = new Project("Soap Free Washers", "Make washers soap free");
        project3 = new Project("Air Computers", "Make air computers");
        projects.add(project1);

        Column column1 = new Column("To Do", "Incomplete");
        Column column2 = new Column("Doing", "Incomplete");
        Column column3 = new Column("Complete", "Complete");

        Task cylinder = new Task(project1, "Curve the metal to make a cylindrical shape",
                                 "description", Category.Feature, "High");
        
        Comment cylindrical = new Comment("Jeff Goldblum", "Not cyclindrical enough");
        Comment question = new Comment("Atticus Finch", "What's a cylinder?");

        project1.addTask(cylinder, "Incomplete");
        project1.addColumn(column1);
        project1.addColumn(column2);
        project1.addColumn(column3);
        cylinder.addComment(cylindrical);
        cylinder.addComment(question);

        projects.add(project2);
        projects.add(project3);
        
    }

    public User login(String username, String password) {
        return new User("Atticus", "Madden", "Amadden", "password",
                    "amadden@gmail.com", "803-730-4872");
    }

    public User signup(String username, String password,String email, String phoneNumber) {
        return null;
    }

    public Project createProject(String title, String description) {
        return null;
    }

    public Project findProject(String projectName) {
        for (int i = 0; i < projects.size(); i++) {
                return projects.get(i);
        }
        return null;
    }

    public void showAllProjects(){
        for (int i = 0; i < projects.size(); i++) {
            System.out.println(projects.get(i).getTitle());
        }
    }

}