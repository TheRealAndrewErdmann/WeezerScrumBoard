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
        PMSoftware.showAllColumns(PMSoftware.findProject("Electric Missiles"));
    }

    public void scenario() {

        System.out.println("Welcome to Code Mission Possible"); 
        System.out.println("-----------Logging in-----------");       
        System.out.println("Welcome Atticus Madden");

        System.out.println("Which project would you like to view?");
        PMSoftware.showAllProjects();
        Project found = PMSoftware.findProject("Develop a chat bot");

        if (found == null) {
            System.out.println("That us not an existing project");
        }

        System.out.println("----Viewing Electric Missiles----");
        PMSoftware.showAllColumns(found);
        
    }

    public static void main(String[] args) {
        AppUI app = new AppUI();
        app.scenario();
    }
}