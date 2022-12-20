import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	public Login() {
		//intialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\LeftPanel.jpg"));
		lblNewLabel.setBounds(0, 0, 294, 365);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(384, 112, 159, 194);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(16, 37, 55, 14);
		panel.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(16, 50, 127, 20);
		panel.add(textUser);
		textUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(16, 96, 127, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Parola");
		lblNewLabel_2.setBounds(16, 81, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				Statement st=con.createStatement();
				String query="select*from ang_info";
				ResultSet rs=st.executeQuery(query);				
				String nume,parola;
				while(rs.next()) {
					nume=rs.getString(1);
					parola=rs.getString(7);
						
					if(nume.equals(textUser.getText()) &&parola.equals(passwordField.getText()) ) {	
						JOptionPane.showMessageDialog(null, "User si parola corecte");	
						Meniu m=new Meniu();	
						m.setVisible(true);
						st.close();
						con.close();
						dispose();
						break;
						
					}
					else if(parola==passwordField.getText() && nume!=textUser.getText())
						JOptionPane.showMessageDialog(null, "User gresit");	
					else if(parola!=passwordField.getText() && nume==textUser.getText())
						JOptionPane.showMessageDialog(null, "parola gresita");	
				}
				
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(26, 131, 102, 23);
		panel.add(btnLogin);
	}
}
