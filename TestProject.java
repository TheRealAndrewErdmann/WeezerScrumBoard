import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class TestProject {
private Project project;
/**
* Initializes a project
*/
public void initializeProject(){
project = new Project(UUID.randomUUID(), "Testing project", "Descrription for the testing of the project class");
}
/**
* This makes sure that a participant is successfully added with a
* specifies role.
*/
public void testAddParticipant(){
User user = new User("Null", "null", "null" , "null" , "null" , "null");
String role = "Null";
boolean added = project.addParticipant(user, role);
assertTrue(added);
assertEquals(1, project.getParticipants().get(role).size());
assertTrue(project.getParticipants().get(role).contains(user));
}
/**
* Creates a new user and defines its roll which for testing is set
* to null and then it adds the user to the project with the specified
* role and checks if the particpant was removed successfully.
*/
public void testRemoveParticipant(){
User user = new User ("Null", "null", "null" , "null" , "null" , "null");
String role = "null";
project.addParticipant(user, role);
assertTrue(project.removeParticipant(user, role));
assertTrue(project.getParticipants().get(role).isEmpty());
}
/**
* Setting up the users and roles, it adds the user with the old role
* first and then verifies the role and the removal of the role and then
* finally verifies the new user with the new role.
*/
public void testChangeRole(){
User user = new User("Null", "null", "null" , "null" , "null" , "null");
String oldRole = "Null";
String newRole = "New Null";
project.addParticipant(user, oldRole);
assertTrue(project.changeRole(user, oldRole, newRole));
assertFalse(project.getParticipants().containsKey(oldRole));
assertTrue(project.getParticipants().containsKey(newRole));
assertTrue(project.getParticipants().get(newRole).contains(user));
}
/**
* This verifies that the task is successfully addedd to the specified
* column with the true status.
*/
public void testAddTask(){
Column column = new Column("To Do", "To Do");
project.addColumn(column);
Task task = new Task ("Task 1");
String status = "To do";
assertTrue(project.addTask(task, status));
assertEquals(1, column.getTasks().size());
assertEquals(status, task.getStatus());
}
/**
* This makes sure that a comment is successfully added to the project's
* comment list.
*/
public void testAddComment(){
Comment comment = new Comment("This is a test comment" , "Null");
assertTrue(project.addComment(comment));
assertEquals(1, project.getComments().size());
}
/**
* This makes sure that a column is added to the projects columns list.
*/
public void testAddColumn(){
Column column = new Column ("Null");
assertTrue(project.addColumn(column));
assertEquals(1, project.getColumns().size());
}
}
