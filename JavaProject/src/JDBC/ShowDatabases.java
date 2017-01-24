package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import JDBC.ConnMySQL;

public class ShowDatabases {
	ConnMySQL login = new ConnMySQL();
	
	public void showDatabases()throws Exception{
		Class.forName(login.driver);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("show databases;")){
				while(rs.next()){
					System.out.println(rs.getString(1));
				}
		}
	}
	public static void main(String args[]) throws Exception{
		ShowDatabases ed = new ShowDatabases();
		ed.login.initParam();
		ed.showDatabases();
		System.out.println("-----�d�ߦ��\-----");
	}
}
