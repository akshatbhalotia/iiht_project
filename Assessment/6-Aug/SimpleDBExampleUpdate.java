import java.sql.*;
import java.util.Scanner;
public class SimpleDBExampleUpdate {

	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB = "jdbc:mysql://localhost/abcd";
	   //127.0.0.1

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "pass@word1";
   
   public static void main(String[] args) {
	   Connection con=null;
		int a=0;
		String n=null;
		Scanner sc=new Scanner(System.in);
PreparedStatement stmt =null;
   try{
	   Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(DB,USER,PASS);
		System.out.println("UPdating records in DataBase.........");
		System.out.println("ENTer the id for which you want to change the name");
		a=sc.nextInt();
		System.out.println("ENter the NAMe to be updated");
		n=sc.next();
		
		
		
		String sql="update simple set name=? where id=?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1, n);
		stmt.setInt(2, a);
		stmt.executeUpdate();
		System.out.println("SUccess \n");
		stmt.close();
	      con.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }

}//end main
}

