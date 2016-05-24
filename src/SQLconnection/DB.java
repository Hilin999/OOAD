package SQLconnection;
import java.sql.*;
public class DB {
	 public static void main(String[] args) throws Exception {
		    Class.forName("org.sqlite.JDBC");
		    Connection conn =
		      DriverManager.getConnection("jdbc:sqlite:test.db");
		    Statement stat = conn.createStatement();
		    stat.executeUpdate("drop table if exists guitars;");
		    stat.executeUpdate("create table guitars(serialNumber,price,builder,model,type,backWood,topWood);");
		    PreparedStatement prep = conn.prepareStatement(
		      "insert into guitars values (?,?,?,?,?,?,?);");

		    prep.setString(1, "001");
		    prep.setString(2, "2000");
		    prep.setString(3, "MakerA");
		    prep.setString(4, "FolkGuitar");
		    prep.setString(5, "6");
		    prep.setString(6, "back");
		    prep.setString(7, "top");
		    prep.addBatch();
		    
		    prep.setString(1, "002");
		    prep.setString(2, "2800");
		    prep.setString(3, "MakerB");
		    prep.setString(4, "FolkGuitar");
		    prep.setString(5, "6");
		    prep.setString(6, "back");
		    prep.setString(7, "top");
		    prep.addBatch();
		    
		    prep.setString(1, "003");
		    prep.setString(2, "2500");
		    prep.setString(3, "MakerA");
		    prep.setString(4, "Bass");
		    prep.setString(5, "8");
		    prep.setString(6, "back");
		    prep.setString(7, "top");
		    prep.addBatch();
		    
		    prep.setString(1, "004");
		    prep.setString(2, "3200");
		    prep.setString(3, "MakerA");
		    prep.setString(4, "Electronic");
		    prep.setString(5, "7");
		    prep.setString(6, "back");
		    prep.setString(7, "top");
		    prep.addBatch();
		    
		    prep.setString(1, "005");
		    prep.setString(2, "4500");
		    prep.setString(3, "MakerA");
		    prep.setString(4, "UKelele");
		    prep.setString(5, "8");
		    prep.setString(6, "back");
		    prep.setString(7, "top");
		    prep.addBatch();
		    
		    prep.setString(1, "006");
		    prep.setString(2, "8000");
		    prep.setString(3, "MakerB");
		    prep.setString(4, "UKelele");
		    prep.setString(5, "6");
		    prep.setString(6, "back");
		    prep.setString(7, "top");
		    prep.addBatch();
		    
		    
		    
		    conn.setAutoCommit(false);
		    prep.executeBatch();
		    conn.setAutoCommit(true);

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
