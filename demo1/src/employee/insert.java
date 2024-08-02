package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert{
	
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
			String sql ="insert into "+sc.next()+"(id,name,email) values(?,?,?)";
			PreparedStatement pmst =conn.prepareStatement(sql);
			System.out.println("enter id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter name");
			pmst.setString(2, sc.next());
			System.out.println("enter email");
			pmst.setString(3, sc.next());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("success");
			}
			else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
