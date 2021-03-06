package JDBC;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class ResultSetTest {
	ConnMySQL login = new ConnMySQL();
	public void query(String sql)throws Exception{
		Class.forName(login.driver);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			PreparedStatement pstmt = conn.prepareStatement(
					sql, java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
					java.sql.ResultSet.CONCUR_UPDATABLE);
			java.sql.ResultSet rs = pstmt.executeQuery()){
				rs.last();
				int rowCount = rs.getRow();
				for(int i=rowCount; i>0; i--){
					rs.absolute(i);
					System.out.println(rs.getString(1) + "\t"
							+ rs.getString(2) + "\t"
							+ rs.getString(3));
					rs.updateString(2, "�ǥͦW" + i);
					rs.updateRow();
				}
		}
	}
	public static void main(String[] args) throws Exception{
		ResultSetTest rt = new ResultSetTest();
		rt.login.initParam();
		rt.query("select * from student_table");
	}
}
