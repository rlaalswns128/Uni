package forum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ForumDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ForumDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/RedDevils/?characterEncoding=UTF-8&serverTimezone=UT";
			String dbID = "root";
			String dbPassword = "rootpw";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int getNext() {
		String SQL = "SELECT forumID FROM Forum ORDER BY forumID DESC";
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			} return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int write(String forumTitle, String userEmail, String forumContent) {
		String SQL = "INSERT INTO Forum VALUE (?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext());
			pstmt.setString(2,  forumTitle);
			pstmt.setString(3,  userEmail);
			pstmt.setString(4,  getDate());
			pstmt.setString(5,  forumTitle);
			pstmt.setInt(6,  1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<Forum> getList(int pageNumber) {
		String SQL = "SELECT * FROM Forum WHERE forumID < ? AND forumAvailable = 1 ORDER BY forumID DESC LIMIT 10";
		ArrayList<Forum> list = new ArrayList<Forum>();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Forum forum = new Forum();
				forum.setForumID(rs.getInt(1));
				forum.setForumTitle(rs.getString(2));
				forum.setUserEmail(rs.getString(3));
				forum.setForumDate(rs.getString(4));
				forum.setForumContent(rs.getString(5));
				forum.setForumAvailable(rs.getString(6));
				list.add(forum);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM Forum WHERE forumID < ? AND forumAvailable = 1 ORDER BY forumID DESC LIMIT 10";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
