//package WeezerScrumBoard;

import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNum;

    //Constructor for creating a new user for the app on signup
    public User(String firstName, String lastName, String userName, String password,
                String email, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.id = UUID.randomUUID();

    }

    //Constructor for getting a user from a json file
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

    public boolean verifyLogin(String Password) {
        return false;
    }
    
    //getters and setters 
    public String getfirstName(){
        return firstName;
    }

    
}