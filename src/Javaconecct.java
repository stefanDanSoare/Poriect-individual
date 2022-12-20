import java.sql.*;
import javax.swing.*;
public class Javaconecct {
	
	public static void main(String[] args) {
		
		
		try {
			
			Class.forName("com.mysql.jbdc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
			Statement st= conn.createStatement();
			String query= "select *from ang_info";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
			}
			JOptionPane.showMessageDialog(null, "Connection Establised");
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
}

