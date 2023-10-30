
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Comment {
    private User author;
    private UUID author2;
    private String comment;
    private Date datePosted;
    private ArrayList<Comment> replies;

    public Comment (User user, String comment) {
        author = user;
        this.comment = comment;
    }

    public boolean updateComment(String comment) {
        this.comment = comment;
        if (this.comment == comment) {
            return true;
        }
        else {
            return false;
        }

    }
    public boolean replyToComment (Comment reply) {
        if (replies.add(reply)) {
            return true;
        }
        else if (reply == null) {
            return false;
        }
        else {
            return false;
        }
    }
    
}
