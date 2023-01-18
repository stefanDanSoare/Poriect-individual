import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Login(Angajat x) {
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
		panel.setBounds(384, 75, 159, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 34, 139, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(6, 16, 127, 20);
		panel_2.add(textUser);
		textUser.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Parola", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 80, 139, 42);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(6, 16, 127, 20);
		panel_1.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Post", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 125, 139, 44);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox postBox = new JComboBox();
		postBox.setModel(new DefaultComboBoxModel(new String[] {"angajat", "manager", "admin"}));
		postBox.setBounds(6, 16, 127, 22);
		panel_3.add(postBox);
		
		JButton btnLogin = new JButton("login");
		
		
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				Statement st=con.createStatement();
				String query="";
				String post=(String) postBox.getSelectedItem();	
				if(post.equals("admin")) {
					query="select*from admin_info";
				
				}
				else if(post.equals("angajat")) {
					query="select*from ang_info";
				}
				else if(post.equals("manager")) {
					query="select*from mgr_info";
				}
				ResultSet rs=st.executeQuery(query);				
				String nume,parola;
				boolean ok=false;
				while(rs.next()) {
					nume=rs.getString("nume");
					parola=rs.getString("parola");
						
					if(nume.equals(textUser.getText()) &&parola.equals(passwordField.getText()) ) {	
						x.nume=rs.getString("nume");
						x.CNP=rs.getString("CNP");
						x.contact=rs.getString("contact");
						x.email=rs.getString("email");
						x.manager=rs.getString("manager");
						x.post=rs.getString("post");
						x.salariu=rs.getString("salariu");
						x.parola=rs.getString("parola");
						x.zile=rs.getInt("zile");
						JOptionPane.showMessageDialog(null, "User si parola corecte");	
						if(post.equals("admin")) {
							Meniu m=new Meniu(x);
							m.setLocationRelativeTo(null);
							m.setVisible(true);
							st.close();
							con.close();
							dispose();
							ok=true;
							break;
						}
						else if(post.equals("manager")) {
							Meniu m=new Meniu(x);
							m.setLocationRelativeTo(null);
							m.setVisible(true);
							st.close();
							con.close();
							dispose();
							ok=true;
							break;
							}
						else if(post.equals("angajat")) {
							MeniuAngajat m=new MeniuAngajat(x);
							m.setLocationRelativeTo(null);
							m.setVisible(true);
							st.close();
							con.close();
							dispose();
							ok=true;
							break;
							}
					}		
				}
				if(ok==false) {
					JOptionPane.showMessageDialog(null, "User sau parola gresite");	
					passwordField.setText("");
				}
					
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(27, 189, 102, 23);
		panel.add(btnLogin);
		
		
		
		
	}
}
