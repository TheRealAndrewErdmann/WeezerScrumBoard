import java.util.ArrayList;

import javax.xml.catalog.CatalogFeatures.Feature;

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
        Project found = PMSoftware.findProject("Electric Missiles");

        if (found == null) {
            System.out.println("That is not an existing project");
        }

        System.out.println("----Viewing Electric Missiles----");
        PMSoftware.showAllColumns(found);
        Column abandoned = new Column("Abandoned", "Incomplete");
        found.addColumn(abandoned);
        Task initialize = new Task(found, "Initialize super algorithm to detonate at warp speed", 
                                    "description", Category.Feature, "Medium");
        Task burger = new Task(found, "Make impossible burger possible", "description", 
                                Category.Feature, "Low");    
        found.addTask(initialize, "Incomplete");
        Comment avoid = new Comment("Atticus Madden", "Avoid civllians Jeff!");
        initialize.addComment(avoid);
        Comment reply = new Comment("Atticus Madden", "How about you do it jeff.");
        PMSoftware.findProject("Electrical Missiles").changeTaskStatus(initialize, "To Do", "Doing");
        System.out.println()
    }

    public static void main(String[] args) {
        AppUI app = new AppUI();
        app.scenario();
    }
}