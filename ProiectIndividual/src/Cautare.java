import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Cautare extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField emailField;
	private JTextField cnpField;
	private JTextField salariuField;
	private JTextField contactField;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cautare frame = new Cautare();
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
	public Cautare(Angajat x) {
		setTitle("Cautare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 634);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nume", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 64, 200, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(6, 16, 184, 20);
		panel.add(userField);
		userField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(16, 117, 200, 42);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(6, 16, 184, 20);
		panel_4.add(emailField);
		emailField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CNP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(16, 11, 200, 42);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		cnpField = new JTextField();
		cnpField.setBounds(6, 16, 184, 20);
		panel_5.add(cnpField);
		cnpField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Salariu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(16, 225, 200, 42);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		salariuField = new JTextField();
		salariuField.setBounds(6, 16, 184, 20);
		panel_3.add(salariuField);
		salariuField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(16, 278, 200, 42);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		contactField = new JTextField();
		contactField.setBounds(6, 16, 184, 20);
		panel_2.add(contactField);
		contactField.setColumns(10);
		
		JButton btnInapoi = new JButton("Inapoi la meniu");
		btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInapoi.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 1 Latest_Icon (5).png"));
		btnInapoi.setBounds(16, 331, 200, 42);
		contentPane.add(btnInapoi);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Intructiuni", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(749, 11, 200, 309);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JTextPane txtpnPentruRealizareOricarei = new JTextPane();
		txtpnPentruRealizareOricarei.setBounds(6, 16, 190, 317);
		panel_6.add(txtpnPentruRealizareOricarei);
		txtpnPentruRealizareOricarei.setText("-Pentru realizare oricarei operatii din cele alaturate introduceti CNP-ul angajatului dorit apoi apasati butonul cautare.\r\n\r\n-Restul campurilor vor fi autocompletate cu datele acestuia.\r\n\r\n-Daca doriti sa stergeti un angajat, dupa autocompletare apasati butonul stergere.\r\n\r\n-Daca doriti sa actualizati un angajat, dupa autocompletare modificati datele dorite si apasati butonul actualizare.");
		
		JButton btnCautare = new JButton("Cautare angajati");
		btnCautare.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (1).png"));
		btnCautare.setBounds(0, 390, 343, 79);
		contentPane.add(btnCautare);
		if(x.post.equals("admin")) { btnCautare.setText("Vizualizare manageri");}
		
		JButton btnStergere = new JButton("Stergere angajat");
		btnStergere.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (3).png"));
		btnStergere.setBounds(616, 392, 343, 75);
		contentPane.add(btnStergere);
		if(x.post.equals("admin")) { btnStergere.setText("Stergere manager");}
		
		JButton btnActualizare = new JButton("Actualiare anangajat");
		btnActualizare.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (2).png"));
		btnActualizare.setBounds(0, 494, 343, 79);
		contentPane.add(btnActualizare);
		if(x.post.equals("admin")) { btnActualizare.setText("Actualiare manager");}
		
		JButton btnView = new JButton("Vizualizare angajati");
		btnView.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (4).png"));
		btnView.setBounds(616, 494, 343, 79);
		contentPane.add(btnView);
		if(x.post.equals("admin")) { btnView.setText("Vizualizare manageri");}
		
		JButton btnLogout = new JButton("Logout\r\n");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\log-out.png"));
		btnLogout.setBounds(749, 331, 200, 42);
		contentPane.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Post", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(16, 170, 200, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox<String> postBox = new JComboBox<>();
		postBox.setModel(new DefaultComboBoxModel<String>(new String[] {"angajat", "manager", "admin"}));
		postBox.setBounds(6, 16, 184, 22);
		panel_1.add(postBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\Employee-Incentive-Programs-The-Best-23-Ranked.jpg"));
		lblNewLabel.setBounds(0, -6, 959, 590);
		contentPane.add(lblNewLabel);
		btnView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Vizualizare frame = new Vizualizare(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnInapoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Meniu frame = new Meniu(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				String query="";
				if(x.post.equals("manager")) {
					query="select*from ang_info where cnp='"+cnpField.getText()+"' and manager='"+x.getCNP()+"'";
				}
				if(x.post.equals("admin")) {
					query="select*from mgr_info where cnp='"+cnpField.getText()+"'";
				}
				PreparedStatement rsmd=con.prepareStatement(query); 
				boolean ok=false;
				ResultSet rs=rsmd.executeQuery(query);
				if(rs.next());
				{
					emailField.setText(rs.getString("email"));
					postBox.setSelectedItem(rs.getString("post"));
					userField.setText(rs.getString("nume"));
					salariuField.setText(rs.getString("salariu"));
					contactField.setText(rs.getString("contact"));
					ok=true;
				}
				if(ok==false) JOptionPane.showMessageDialog(null, "Utilizatorul nu a fost gasit");
				rsmd.close();
				con.close();
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
				}
			}
		});
		
		btnActualizare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				String query="";
				if(x.post.equals("manager")) {
				query="update ang_info set cnp='"+cnpField.getText()+"',email='"+emailField.getText()+"', post='"+postBox.getSelectedItem()+
						"',nume='"+userField.getText()+"',salariu='"+salariuField.getText()+"',contact='"+contactField.getText()+
						"' where cnp='"+cnpField.getText()+"'";
				}
				if(x.post.equals("admin")) {
					query="update mgr_info set cnp='"+cnpField.getText()+"',email='"+emailField.getText()+"', post='"+postBox.getSelectedItem()+
							"',nume='"+userField.getText()+"',salariu='"+salariuField.getText()+"',contact='"+contactField.getText()+
							"' where cnp='"+cnpField.getText()+"'";
					}
					
				Statement rsmd=con.createStatement(); 
				rsmd.executeUpdate(query);
				rsmd.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Actualizare finalizata");
				dispose();
				new Cautare(x).setVisible(true);
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
				}
			}
		});
		
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				
				String query="";
				if(x.post.equals("manager")) {
				query="delete from ang_info where cnp='"+cnpField.getText()+"'";
				}
				if(x.post.equals("admin")) {
					query="delete from mgr_info where cnp='"+cnpField.getText()+"'";
					Statement rsmd=con.createStatement(); 
					rsmd.executeUpdate(query);
					query="delete from ang_info where manager='"+x.CNP+"'";
				}
				Statement rsmd=con.createStatement(); 
				rsmd.executeUpdate(query);
				rsmd.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Stergere finalizata");
				dispose();
				new Cautare(x).setVisible(true);
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
				}
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Login frame = new Login(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		
	}
}
