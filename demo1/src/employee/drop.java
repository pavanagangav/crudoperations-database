package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class drop {
	
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "root";
	public static void main(String[] args) {
		
		try {
			Scanner sc =new Scanner(System.in);
			
			Class.forName(Driver);
			Connection conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter the data base name");
			String sql ="drop database " +sc.next();
			PreparedStatement pmst =conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0) {
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
