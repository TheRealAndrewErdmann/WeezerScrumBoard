import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class DataWriterTest {
    DataWriter dataWriter = new DataWriter();
    private UUID id1 = UUID.randomUUID();
	User James = new User(id1, "James", "Rogers", "Jrogers",
					"EK8g69Dk$G3", "jrogers@gmail.com", "803-730-4872");
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

    private ProjectList projectList = ProjectList.getInstance();
    private ArrayList<Project> projects = projectList.getProjects();
    Project proj = new Project("Title", "description");
    
    @BeforeEach
    public void setUp() {
        users.clear();
        users.add(James);

        try (FileWriter file = new FileWriter("JSON/userTest.json")) {

            file.write("");
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }

        projects.clear();
        projects.add(proj);
        
    }

    @Test
    public void testSaveUsers() {
        DataWriter.saveUsers();
        ArrayList<User> loaded = FileLoader.getUsers();
        assertEquals(James, loaded.get(0));
    }

    @Test
    public void testSaveProjects() {
        DataWriter.saveProjects();
        ArrayList<Project> loaded = FileLoader.getProjects();
        assertEquals(proj,loaded.get(0));
    }
}
