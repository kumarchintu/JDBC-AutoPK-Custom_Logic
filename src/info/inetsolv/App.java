package info.inetsolv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		PreparedStatement ps = connection.prepareStatement("insert into emp_table values((SELECT NVL(MAX(eno+1),1) AS ENO FROM EMP_TABLE),?,?)");
		ps.setString(1, "Abhi");
		ps.setDouble(2, 55000d);
		int records = ps.executeUpdate();
		System.out.println("Records inserted: "+records);
		connection.close();
	}		  
}