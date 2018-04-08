package cn.chen.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils; 

public class BigData {
	
	public void saveToSql() throws Exception {
		Connection con=JdbcUtils.getConnection();
		String sql="insert into bigdata values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, "music1");
		//得到blob
		byte[] bys=IOUtils.toByteArray(new FileInputStream("E://DNA.mp3"));
		Blob blob=new SerialBlob(bys);
		pstmt.setBlob(3, blob);
		pstmt.executeUpdate();
	}
	public void readFromSql() throws Exception {
		Connection con=JdbcUtils.getConnection();
		String sql="select * from bigdata where filename=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "music1");
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			Blob blob=rs.getBlob("data");
			InputStream is=blob.getBinaryStream();
			OutputStream os=new FileOutputStream("D://a.mp3");
			IOUtils.copy(is, os);
		}
	}
	public static void main(String[] args) throws Exception {
		BigData bd=new BigData();
//		bd.saveToSql();
		bd.readFromSql();
	}
}
