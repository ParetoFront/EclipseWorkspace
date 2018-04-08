package cn.chen.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchExecute {
	public static void main(String[] args) throws Exception {
		Connection con = JdbcUtils.getConnection();
		String sql="insert into stu_test values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		for(int i=0;i<1000;i++) {
			pstmt.setInt(1, i);
			pstmt.setString(2, "stu"+i);
			pstmt.addBatch();
		}
		pstmt.executeBatch();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}
}
