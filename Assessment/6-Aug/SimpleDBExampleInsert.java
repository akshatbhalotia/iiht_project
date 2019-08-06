import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SimpleDBExampleInsert
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB = "jdbc:mysql://localhost/abcd";
	static final String USER ="root";
	static final String PASS = "pass@word1";
	
	public static void main(String[] args)
	{
		Connection con=null;
		int a=0;
		String n=null;
		
		Scanner sc=new Scanner(System.in);
 PreparedStatement stmt =null;
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DB,USER,PASS);
			System.out.println("Inserting records in DataBase.........");
			System.out.println("ENTer the id");
			a=sc.nextInt();
			System.out.println("ENter the NAMe");
			n=sc.next();
			
			
			
			String sql="insert into simple values(?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, a);
			stmt.setString(2, n);
			stmt.executeUpdate();
			System.out.println("SUccess \n");
			stmt.close();
		      con.close();
		}
		catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		
	}
	
}
