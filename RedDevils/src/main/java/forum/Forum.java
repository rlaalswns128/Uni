package forum;

public class Forum {
	private int ForumID;
	private String ForumTitle;
	private String UserEmail;
	private String ForumDate;
	private String ForumContent;
	private String ForumAvailable;
	
	public int getForumID() {
		return ForumID;
	}
	public void setForumID(int forumID) {
		ForumID = forumID;
	}
	public String getForumTitle() {
		return ForumTitle;
	}
	public void setForumTitle(String forumTitle) {
		ForumTitle = forumTitle;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getForumDate() {
		return ForumDate;
	}
	public void setForumDate(String forumDate) {
		ForumDate = forumDate;
	}
	public String getForumContent() {
		return ForumContent;
	}
	public void setForumContent(String forumContent) {
		ForumContent = forumContent;
	}
	public String getForumAvailable() {
		return ForumAvailable;
	}
	public void setForumAvailable(String forumAvailable) {
		ForumAvailable = forumAvailable;
	}
}
