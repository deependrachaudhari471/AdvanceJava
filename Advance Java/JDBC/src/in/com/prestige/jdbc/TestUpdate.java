package in.com.prestige.jdbc;
import java.sql.*;

public class TestUpdate {
	   public static String db_url = "jdbc:mysql://localhost:3306/test";
	   public static String username = "root";
	   public static String password = "root";
	   
	   public static void main(String[] args){
		   Connection conn = null;
		   Statement st = null;
		   ResultSet rs = null;
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection(db_url,username,password);
			   st = conn.createStatement();
			   
			   String sql = "update employee set empname = 'Sahilesh Ravi' , address = 'ujjain' where empid = 107 ";
			   int i = st.executeUpdate(sql);
			   
			   if(i >= 1){
				   System.out.println("Record Updated");
			   }else{
				   System.out.println("Record  Not Updated");
			   }
		   }catch(Exception e){
			   System.out.println(e);
		   }finally{
			   try{
				   if(conn!= null){
					   conn.close();
				   }
				   if(st!= null){
					   st.close();
				   }
			   }catch(Exception e){
				   System.out.println(e);
			   }
		   }
	   }
}
