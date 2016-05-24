package SQLconnection;
import java.sql.*;
public class Test {
  public static void main(String[] args) throws Exception {
    Class.forName("org.sqlite.JDBC");
    Connection conn =
      DriverManager.getConnection("jdbc:sqlite:guitars.db");
    Statement stat = conn.createStatement();
   
    ResultSet rs = stat.executeQuery("select * from guitars;");
    while (rs.next()) {
    	  System.out.println("serialNumber = " + rs.getString("serialNumber"));    
	      System.out.println("price = " + rs.getString("price"));
	      System.out.println("builder = " + rs.getString("builder"));
	      System.out.println("model = " + rs.getString("model"));
	      System.out.println("type = " + rs.getString("type"));
	      System.out.println("backWood = " + rs.getString("backWood"));
	      System.out.println("topWood = " + rs.getString("topWood"));
    }
    rs.close();
    conn.close();
  }
}
