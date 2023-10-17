import java.util.ArrayList;

public class Comment {
    private User author;
    private String comment;
    private Date datePosted;
    private ArrayList<Comment> replies;

    public boolean Comment (User user, String comment){
        return true;
    }
    public boolean updateComment(String commnent){
        return true;
    }
    public boolean replyToComment (Comment reply){
        return true;
    }
    
}
