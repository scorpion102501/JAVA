package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementTest {
	ConnMySQL login = new ConnMySQL();
	public void callProcedure()throws Exception{
		Class.forName(login.driver);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			java.sql.CallableStatement cstmt = conn.prepareCall(
							"{call and_pro(?,?,?)}")){
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			//���UcallableStatement���ĤT�ӰѼƬOint����
			cstmt.registerOutParameter(3, Types.INTEGER);
			//������U�L�{
			cstmt.execute();
			//����ÿ�X�x�s�L�{�ǥX�Ѽƪ���
			System.out.println("����L�{���G�O:" + cstmt.getInt(3));
		}
	}
	public static void main(String[] args) throws Exception{
		CallableStatementTest ct = new CallableStatementTest();
		ct.login.initParam();
		ct.callProcedure();
	}
}