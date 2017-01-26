package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class PreparedStamentTest {
	ConnMySQL login = new ConnMySQL();
	public void insertUseStatement()throws Exception{
		long start = System.currentTimeMillis();
		Class.forName(login.driver);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			Statement stmt = conn.createStatement()){
				for(int i=0; i<100; i++){
					stmt.executeUpdate("insert into student_table values("
							+ " null ,'�m�W" + i + "' , 1)");
				}
				System.out.println("�ϥ�Statement�O��:"+
						(System.currentTimeMillis()-start));
		}
	}
	public void insertUsePrepare()throws Exception{
		long start = System.currentTimeMillis();
		try(Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			java.sql.PreparedStatement pstmt = conn.prepareStatement(
					"insert into student_table value(null,?,1)")){
			for(int i=0; i<100; i++){
				pstmt.setString(1, "�m�W"+1);
				pstmt.executeUpdate();
			}
			System.out.println("�ϥ�Preparement�O��:"+
					(System.currentTimeMillis() - start));
		}
	}
	public static void main(String[] args) throws Exception{
		PreparedStamentTest pt = new PreparedStamentTest();
		pt.login.initParam();
		pt.insertUseStatement();
		pt.insertUsePrepare();
	}
}