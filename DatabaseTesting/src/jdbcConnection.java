import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/demotest";
		String user = "root";
		String pw = "@Az1234567";		
		
		Connection con = DriverManager.getConnection(url, user, pw);
//		DriverManager.getConnection("jdbc:mysql://localhost:3306/demotest", "root", "@Az1234567");
		
		Statement s = con.createStatement();
		ResultSet res = s.executeQuery("SELECT * FROM employeeinfo;");
		while (res.next()) {
		System.out.print(res.getString("EmployeeID") + " "+res.getString("Name") + " ");
		System.out.println(res.getString("Location"));
		};
	} 

}
