package WeezerScrumBoard;

import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNum;

    public User(String firstName, String lastName, String userName, String password,
                String email, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;

    }

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
    
}