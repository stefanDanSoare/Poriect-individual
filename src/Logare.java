import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Logare extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField UserField;
	private JTextField emailField;
	private JTextField postField;
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
	public Logare() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\LeftPanel.jpg"));
		lblNewLabel.setBounds(0, 0, 294, 367);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 1 Latest_Icon (7).png"));
		lblNewLabel_1.setBounds(392, 11, 32, 43);
		contentPane.add(lblNewLabel_1);
		
		UserField = new JTextField();
		UserField.setBounds(350, 78, 125, 20);
		contentPane.add(UserField);
		UserField.setColumns(10);
		
		JLabel lbUser = new JLabel("Nume angajat");
		lbUser.setLabelFor(UserField);
		lbUser.setBounds(350, 65, 101, 14);
		contentPane.add(lbUser);
		
		JButton btnAdd = new JButton("Adaugare");
		btnAdd.setBounds(362, 294, 101, 23);
		contentPane.add(btnAdd);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(350, 109, 125, 20);
		contentPane.add(emailField);
		
		postField = new JTextField();
		postField.setColumns(10);
		postField.setBounds(350, 140, 125, 20);
		contentPane.add(postField);
		
		cnpField = new JTextField();
		cnpField.setColumns(10);
		cnpField.setBounds(350, 171, 125, 20);
		contentPane.add(cnpField);
		
		salariuField = new JTextField();
		salariuField.setColumns(10);
		salariuField.setBounds(350, 202, 125, 20);
		contentPane.add(salariuField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(350, 233, 125, 20);
		contentPane.add(contactField);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setLabelFor(emailField);
		lbEmail.setBounds(350, 98, 101, 14);
		contentPane.add(lbEmail);
		
		JLabel lbPost = new JLabel("Post");
		lbPost.setLabelFor(postField);
		lbPost.setBounds(350, 128, 101, 14);
		contentPane.add(lbPost);
		
		JLabel lbCNP = new JLabel("CNP");
		lbCNP.setLabelFor(cnpField);
		lbCNP.setBounds(350, 157, 101, 14);
		contentPane.add(lbCNP);
		
		JLabel lbContactul = new JLabel("Contact");
		lbContactul.setLabelFor(contactField);
		lbContactul.setBounds(350, 219, 101, 14);
		contentPane.add(lbContactul);
		
		JLabel lbSalariu = new JLabel("Salariu");
		lbSalariu.setLabelFor(salariuField);
		lbSalariu.setBounds(350, 190, 101, 14);
		contentPane.add(lbSalariu);
		
		JButton btnBack = new JButton("Inapoi");
		btnBack.setBounds(362, 328, 101, 23);
		contentPane.add(btnBack);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(350, 263, 125, 20);
		contentPane.add(passwordField);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(350, 251, 101, 14);
		contentPane.add(lblParola);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae){
						String user=UserField.getText();
						String email=emailField.getText();
						String post=postField.getText();
						String cnp=cnpField.getText();
						int lenc=cnp.length();
						if (lenc != 13) {
		                    JOptionPane.showMessageDialog(btnAdd, "Enter a valid mobile number");
		                }
						String salariu=salariuField.getText();
						String contact=contactField.getText();
						int len = contact.length();
						String password = passwordField.getText();
						JOptionPane.showMessageDialog(null,"Succes");
						dispose();
						new Logare().setVisible(true);
						String msg = "" + user;
						msg += " \n";
						if (len != 10) {
		                    JOptionPane.showMessageDialog(btnAdd, "Enter a valid mobile number");
		                }
						try {
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");

		                    String query = "INSERT INTO ang_info values('" + user + "','" + email + "','" + post + "','" +
		                        cnp + "','" + salariu + "','" + contact + "','" + password +"')";

		                    Statement sta = connection.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnAdd, "This id alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(btnAdd,
		                            "Welcome, " + msg + "Your account is sucessfully created");
		                    }
		                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
		            }
		        });
						
	


		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Meniu frame = new Meniu();
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
