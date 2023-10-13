
public class Change {
	private String changeDescription;
	private User author;
	private Date changeDate;

	public Change(String changeDescription, User author) {
		this.changeDescription = changeDescription;
		this.author = author;
		this.changeDate = new Date(); // Setting to current date and time
	}

	// Getter & Setter
	public String getChangeDescription() {
		return changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	public User getAuthor() {
		return author;
	}

}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public void addComment(Comment comment) {

	}

	@Override
	public String toString() {
		return "Change{" + "changeDescription='" + changeDescription + '\'' + ", author=" + author + ", changeDate="
				+ changeDate + '}';
	}
}
