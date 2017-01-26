package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteDML {
	ConnMySQL login = new ConnMySQL();
	public int insertData(String sql)throws Exception{
		Class.forName(login.driver);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			Statement stmt = conn.createStatement()){
				return stmt.executeUpdate(sql);
		}
	}
	public static void main(String[] args) throws Exception{
		ExecuteDML ed = new ExecuteDML();
		ed.login.initParam();
		int result = ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc)"
				+ "select s.student_name , t.teacher_name "
				+ "from student_table s , teacher_table t "
				+ "where s.java_teacher = t.teacher_id;");
			System.out.println("--�t�Τ��@��" + result + "���O�����v�T--");
	}
}