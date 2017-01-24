package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class ExecuteSQL {
	ConnMySQL login = new ConnMySQL();
	public void executeSql(String sql)throws Exception{
		Class.forName(login.driver);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			Statement stmt = conn.createStatement()){
				boolean hasResultSet = stmt.execute(sql);
				if(hasResultSet){
					try(ResultSet rs = stmt.getResultSet()){
						java.sql.ResultSetMetaData rsmd = rs.getMetaData();
						int columnCount = rsmd.getColumnCount();
						while(rs.next()){
							for(int i = 0; i<columnCount; i++){
								System.out.print(rs.getString(i+1)+"\t");
							}
						System.out.println();
						}
					}
				}else{
					System.out.println("影響的紀錄有"+stmt.getUpdateCount()+"條");
				}
		}
	}
	public static void main(String[] args) throws Exception{
		ExecuteSQL es = new ExecuteSQL();
		es.login.initParam();
		System.out.println("------執行刪除表的DDL語句-----");
		es.executeSql("drop table if exists my_test");
		System.out.println("------執行建表的DDL語句-----");
		es.executeSql("create table my_test"
			+ "(test_id int auto_increment primary key, "
			+ "test_name varchar(255))");
		System.out.println("------執行插入資料的DML語句-----");
		es.executeSql("insert into my_test(test_name) "
			+ "select student_name from student_table");
		System.out.println("------執行查詢資料的查詢語句-----");
		es.executeSql("select * from my_test");
		System.out.println("------結束-----");
	}
}
