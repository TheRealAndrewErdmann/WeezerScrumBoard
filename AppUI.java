import java.util.ArrayList;

public class AppUI {
    //private UserList userlist;
    //private ProjectList projectList;
    private PMSoftwareFacade PMSoftware;
    private Project temp;

    AppUI() {
        PMSoftware = new PMSoftwareFacade();
    }

    public void run() {
        PMSoftware.showAllProjects();
    }

    public void scenario() {

        System.out.println("Welcome to Code Mission Possible"); 
        System.out.println("-----------Logging in-----------");       
        System.out.println("Welcome Atticus Madden");

        System.out.println("Which project would you like to view?");
        PMSoftware.showAllProjects();
        System.out.println("----Viewing Electric Missiles----");
    }

    public static void main(String[] args) {
        AppUI app = new AppUI();
        app.scenario();
    }
}