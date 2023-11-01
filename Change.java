
public class Change {
    private String changeDescription;
    private User changeAuthor;  

 
    public Change(String description, User author) {
        this.changeDescription = description;
        this.changeAuthor = author; 
    }

    public String getChangeDescrption() {
        return changeDescription;
    }

    public String getChangeAuthor() {
        return changeAuthor.getFirstName()+" "+changeAuthor.getLastName();
    }
	

}
