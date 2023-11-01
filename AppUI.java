import java.util.ArrayList;

public class AppUI {
    private UserList userlist;
    private ProjectList projectList;
    private PMSoftwareFacade app;

    AppUI() {
        app = new PMSoftwareFacade();
    }

    public void run() {
        app.showAllProjects();
    }

    public void scenario() {

        System.out.println("Welcome Atticus Madden");

        System.out.println("Which project would you like to view?");
        app.showAllProjects();
    }
}