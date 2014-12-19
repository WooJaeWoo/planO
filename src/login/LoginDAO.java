package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;


public class LoginDAO {
	public User loginDao(String loginId, String loginPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User returnUser = null;
		
		String address = "jdbc:mysql://192.168.56.102/planO";
		String id = "root";
		String pw = "abcd";
		String sql = "SELECT * FROM USER WHERE email=? AND password=?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				returnUser = new User(rs.getString("uId"), rs.getString("email"), 
						rs.getString("password"),rs.getString("name"), rs.getString("birth"));
	
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
				
		return returnUser;	
	}
}
