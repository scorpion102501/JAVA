package JDBC;

import java.io.FileInputStream;
import java.util.Properties;

public class ConnMySQL {
	public String driver,url,user,pass;
	public void initParam() throws Exception{
		Properties props =  new Properties();
		props.load(new FileInputStream("mysql.ini"));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
}
