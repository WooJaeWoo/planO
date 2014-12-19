import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Issue;

public class IssueDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Issue> issueList = new ArrayList<Issue>();
	int updatedRows = -1;
	
	String address = "jdbc:mysql://192.168.56.102/planO?useUnicode=true&characterEncoding=UTF-8";
	String id = "jojo";
	String pw = "abcd";
	
	public ArrayList<Issue> getIssue(String projectId) {
		String sql = "SELECT * FROM ISSUE WHERE pId = ?"; // validate 0인 애들도 가져 오는지?	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				issueList.add(new Issue(rs.getString("iId") ,rs.getString("pId"), rs.getString("seq"), rs.getString("name"), rs.getString("descrpition"), rs.getString("startDate"), rs.getString("finishDate"), rs.getString("validate")));
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
