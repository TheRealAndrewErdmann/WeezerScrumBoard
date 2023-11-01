import java.util.ArrayList;
public class PMSoftwareFacade {

    private User user;
    private UserList userList;
    private ProjectList projectList;
    private ArrayList<Project> proj;

    public PMSoftwareFacade() {
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();
        proj = projectList.getProjects();
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

    public void showAllProjects(){
        for (int i = 0; i < proj.size(); i++) {
            System.out.println(proj.get(i).getTitle());
        }
    }

    //works prints develop a chat bot like intended
    public static void main(String[] args) {
        PMSoftwareFacade test = new PMSoftwareFacade();
        test.showAllProjects();
    }

}