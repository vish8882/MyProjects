package databaseConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {
	static final String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String jdbc_url="jdbc:sqlserver://localhost:1433;databaseName=Employee;integratedSecurity=true;";
	static final String username="";
	static final String password="";
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			int id=0;
			String firstName=null;
			String lastname=null;
			String city=null;
			//Registring driver
			Class.forName(JDBC_DRIVER);
			
			//getting connection
			conn=DriverManager.getConnection(jdbc_url,username,password);
			try{
				
			}finally{
				
			}
			//create a query
			String query="Select * from employee";
			stmt=conn.prepareStatement(query);
		
			
			
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				id=res.getInt("id");
				firstName=res.getString("first_name");
				lastname=res.getString("last_name");
			}
			System.out.println(id+" "+firstName+" "+lastname+" "+city);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
}
