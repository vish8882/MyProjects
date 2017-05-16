package databaseConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test {

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:sqlserver://localhost/AIRCRAFT/VISHSQLSERVER";
	   

	   //  Database credentials
	   static final String USER = "Aircraft\\Vish";
	   static final String PASS = "yaadni";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, first, last, age FROM Employees";
	      ResultSet rs = stmt.executeQuery(sql);
}
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   }
}
