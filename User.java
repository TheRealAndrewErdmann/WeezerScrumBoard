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

<<<<<<< HEAD
    public UUID getid(){
        return id;
    }

    public String getfirstName(){
        return firstName;
    }

    public String getlastName(){
        return lastName;
    }

    public String getuserName(){
        return userName;
    }

    public String getpassword(){
        return password;
    }

    public String getemail(){
        return email;
    }

    public String getphoneNum(){
        return phoneNum;
    }

    public boolean verifyLogin(String Password){
        return false;
=======
    public boolean verifyLogin(String Password) {
        if (password == Password) {
            return true;
        }
        else {
            return false;
        }
>>>>>>> ba1ff75b4bf0c14b2b30df630f961ff23581b2c6
    }

    public UUID getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }


    

}