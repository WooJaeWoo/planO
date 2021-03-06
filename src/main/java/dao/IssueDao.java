package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Issue;

public class IssueDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Issue> issueList = new ArrayList<Issue>();
	int updatedRows = -1;
	
	String address = "jdbc:mysql://192.168.56.102/planO?useUnicode=true&characterEncoding=UTF-8";
	String id = "jojo";
	String pw = "abcd";
	
	public ArrayList<Issue> getIssue(int projectId) {
		String sql = "SELECT * FROM ISSUE WHERE pId = ?";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				issueList.add(new Issue(rs.getLong("iId") ,rs.getLong("pId"), rs.getInt("seq"), rs.getString("name"), rs.getString("descrpition"), rs.getTimestamp("startDate"), rs.getTimestamp("finishDate"), rs.getString("validate")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return issueList;
	}

}
