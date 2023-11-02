
import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNum;
    /**
     * Constructs a new User object with the specified user information without an id.
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param userName The username chosen by the user
     * @param password The password chosen by the user
     * @param email The email address provided by the user
     * @param phoneNum The phone number provided by the user
     * @author Shiv Patel
     */
    public User(String firstName, String lastName, String userName, String password,
                String email, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;

    }

    /**
     * Constructs a new User object with the specified user information with an id.
     * @param id The id of the user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param userName The username chosen by the user
     * @param password The password chosen by the user
     * @param email The email address provided by the user
     * @param phoneNum The phone number provided by the user
     */
    public User(UUID id, String firstName, String lastName, String userName, String password,
                String email, String phoneNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;

    }

    public UUID getID(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    /**
     * verifies that the password the user input is the same as their actual set password
     * @param Password password the user input to check with the password they set when signing up
     * @return true if the password parameter matches with the saved password
     */
    public boolean verifyLogin(String Password) {
        if (password == Password) {
            return true;
        }
        else {
            return false;
        }
    }

}