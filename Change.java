import java.util.Date;

public class Change {
    private String changeDescription;
    private User changeAuthor;  
    private Date changeDate;

 
    public Change(String description, User author) {
        this.changeDescription = description;
        this.changeAuthor = author;
        this.changeDate = new Date();  
    }


    public boolean changeDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.changeDescription = description;
            return true;
        }
        return false;
	
    }


    public boolean changePriority(Priority priority) {
        return false;
    }


    public boolean addComment(Comment comment) {
        return false;
    }

  
    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription;
    }

    public User getChangeAuthor() {
        return changeAuthor;
    }

    public void setChangeAuthor(User changeAuthor) {
        this.changeAuthor = changeAuthor;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
	
    @Override
public String toString() {
    return "Change{" + 
           "changeDescription='" + changeDescription + '\'' + 
           ", changeAuthor=" + changeAuthor + 
           ", changeDate=" + changeDate + 
           '}';
}
}
