import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("serial")
public class AddAdmin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField UserField;
	private JTextField emailField;
	private JTextField cnpField;
	private JTextField salariuField;
	private JTextField contactField;
	FileWriter fw;
	
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	static String lineSeparator =System.getProperty("line.separator");
	private JTextField passwordField;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddAdmin(Angajat x) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 1 Latest_Icon (7).png"));
		lblNewLabel_1.setBounds(653, 11, 32, 43);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nume", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(600, 65, 137, 42);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		UserField = new JTextField();
		UserField.setBounds(6, 16, 125, 20);
		panel_6.add(UserField);
		UserField.setColumns(10);
		
		JButton btnAdd = new JButton("Adaugare");
		btnAdd.setBounds(623, 467, 101, 23);
		contentPane.add(btnAdd);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(600, 118, 137, 42);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(6, 16, 125, 20);
		panel_5.add(emailField);
		emailField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CNP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(600, 226, 137, 42);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		cnpField = new JTextField();
		cnpField.setBounds(6, 16, 125, 20);
		panel_3.add(cnpField);
		cnpField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Salariu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(600, 279, 137, 42);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		salariuField = new JTextField();
		salariuField.setBounds(6, 16, 125, 20);
		panel_2.add(salariuField);
		salariuField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(600, 332, 137, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		contactField = new JTextField();
		contactField.setBounds(6, 16, 125, 20);
		panel_1.add(contactField);
		contactField.setColumns(10);
		
		JButton btnBack = new JButton("Inapoi");
		btnBack.setBounds(42, 467, 101, 23);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Parola", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(600, 385, 137, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordField = new JTextField();
		passwordField.setBounds(6, 16, 125, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Post", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(600, 171, 137, 44);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JComboBox postBox = new JComboBox();
		postBox.setBounds(6, 16, 125, 22);
		panel_4.add(postBox);
		postBox.setModel(new DefaultComboBoxModel(new String[] {"angajat", "manager", "admin"}));
		postBox.setSelectedItem("manager");
		postBox.setEnabled(false);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1575376469213-employee-evaluation-form.jpg"));
		lblNewLabel_2.setBounds(-38, 0, 800, 542);
		contentPane.add(lblNewLabel_2);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae){
						Boolean ok=true;
						String user=UserField.getText();
						String email=emailField.getText();
						String regex = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
						Pattern pattern = Pattern.compile(regex);
				        Matcher matcher = pattern.matcher(email);
				        if (!matcher.matches()) {
				            System.out.println("Invalid email address");
				            ok=false;
				        }
						String post=postBox.getSelectedItem().toString();
						String cnp=cnpField.getText();
						int lenc=cnp.length();
						
						if (lenc != 13) {
		                    JOptionPane.showMessageDialog(btnAdd, "Enter a valid mobile number");
		                    ok=false;
		                }
						String salariu=salariuField.getText();
						String contact=contactField.getText();
						int len = contact.length();
						String password = passwordField.getText();
						String manager= cnp;
						int passc  = password.length();
						if (passc <= 8) {
		                    JOptionPane.showMessageDialog(btnAdd, "minimum 8 characters required for the password");
		                    ok=false;
		                }					
						String msg = "" + user;
						
						if (len != 10) {
		                    JOptionPane.showMessageDialog(btnAdd, "Enter a valid mobile number");
		                    ok=false;
		                }
						if(ok==true) {
							JOptionPane.showMessageDialog(null,"Succes");
							dispose();
							AddAdmin frame= new AddAdmin(x);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						try {
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
		                    String query = "INSERT INTO mgr_info values('" + cnp + "','" + user + "','" + email + "','" + post + "','" +
				                salariu + "','" + contact + "','" + password +"','" + manager +"')";
		                    Statement sta = connection.createStatement();
		                    int x = sta.executeUpdate(query);
		                    query = "INSERT INTO mgr_info values('" + cnp + "','" + user + "','" + email + "','" + post + "','" +
					                salariu + "','" + contact + "','" + password +"','" + manager +"')";
			                  sta = connection.createStatement();
			                  x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnAdd, "This id alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(btnAdd,
		                             msg+" 's account is sucessfully created");
		                    }
		                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
		            }
			}
		        });
						
	


	
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Meniu frame = new Meniu(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
				

			
	}

	@Override
	public void actionPerformed(ActionEvent ae){
		// TODO Auto-generated method stub	
	}
}
