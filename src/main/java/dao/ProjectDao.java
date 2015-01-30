package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Project;



public class ProjectDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Project> projectList = new ArrayList<Project>();
	Project project = null;
	int updatedRows = -1;
	
	String address = "jdbc:mysql://192.168.56.102/planO?useUnicode=true&characterEncoding=UTF-8";
	String id = "jojo";
	String pw = "abcd";

	public Project getProjectInfo(int projectId) {
		String sql = "SELECT * FROM PROJECT p WHERE pId=?;";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				project = new Project(rs.getLong("pId") ,rs.getString("name"), rs.getString("descrpition"), rs.getTimestamp("startDate"), rs.getTimestamp("finishDate"), rs.getString("validate"));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		return project;
	}

	public ArrayList<Project> getProjectList(String userId) {
		String sql = "SELECT * FROM PROJECT p "
				+ "JOIN USER_PROJECT u "
				+ "ON p.pId=u.pId WHERE u.uId=?;";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				projectList.add(new Project(rs.getLong("pId") ,rs.getString("name"), rs.getString("descrpition"), rs.getTimestamp("startDate"), rs.getTimestamp("finishDate"), rs.getString("validate")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return projectList;
	}
}
