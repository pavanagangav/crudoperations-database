package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyemail{
	
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";
	
    public static void main(String[] args) {
		
		try {
			Scanner sc =new Scanner(System.in);
			System.out.println("enter the database name");
			 String url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			Connection conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter the table name");
			String sql ="select * from "+sc.next() +" where email =?";
			PreparedStatement pmst =conn.prepareStatement(sql);
			System.out.println("enter email");
			pmst.setString(1, sc.next());
			ResultSet rs= pmst.executeQuery();
			while(rs.next()) {
				System.out.println("**********");
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("id : " + rs.getString("name"));
				System.out.println("id : " + rs.getString("email"));
				System.out.println("**********");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
