package cn.chen.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class demo2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydatabase_1?usePrepStmts=true&cachePrepStmt=true",
				"root", "cky1994918");
		String sql="select * from stu where num=? and name=?";
		PreparedStatement pstmt=(PreparedStatement) con.clientPrepareStatement(sql);
		pstmt.setInt(1, 0003);
		pstmt.setString(2, "wangwu");
		
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		System.out.println(rs.getString(2));
	}
}
