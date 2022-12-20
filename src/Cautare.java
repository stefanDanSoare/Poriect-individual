import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
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
import javax.swing.SwingConstants;

public class Cautare extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField emailField;
	private JTextField postField;
	private JTextField cnpField;
	private JTextField salariuField;
	private JTextField contactField;
	private JTextField parolaField;

	/**
	 * Launch the application.
	 */
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
	public Cautare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(96, 69, 129, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(96, 100, 129, 20);
		contentPane.add(emailField);
		
		postField = new JTextField();
		postField.setColumns(10);
		postField.setBounds(96, 131, 129, 20);
		contentPane.add(postField);
		
		cnpField = new JTextField();
		cnpField.setColumns(10);
		cnpField.setBounds(96, 162, 129, 20);
		contentPane.add(cnpField);
		
		salariuField = new JTextField();
		salariuField.setColumns(10);
		salariuField.setBounds(96, 193, 129, 20);
		contentPane.add(salariuField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(96, 224, 129, 20);
		contentPane.add(contactField);
		
		parolaField = new JTextField();
		parolaField.setColumns(10);
		parolaField.setBounds(96, 255, 129, 20);
		contentPane.add(parolaField);
		
		JLabel lblNewLabel = new JLabel("Nume");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 72, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 103, 76, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPost.setBounds(10, 134, 76, 14);
		contentPane.add(lblPost);
		
		JLabel lblCNP = new JLabel("CNP");
		lblCNP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNP.setBounds(10, 165, 76, 14);
		contentPane.add(lblCNP);
		
		JLabel lblSalariu = new JLabel("Salariu");
		lblSalariu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalariu.setBounds(10, 196, 76, 14);
		contentPane.add(lblSalariu);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContact.setBounds(10, 227, 76, 14);
		contentPane.add(lblContact);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParola.setBounds(10, 258, 76, 14);
		contentPane.add(lblParola);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.setBounds(255, 68, 89, 23);
		contentPane.add(btnCautare);
		
		JButton btnStergere = new JButton("Stergere");
		btnStergere.setBounds(255, 113, 89, 23);
		contentPane.add(btnStergere);
		
		JButton btnActualizare = new JButton("Actualizare");
		btnActualizare.setBounds(255, 210, 89, 23);
		contentPane.add(btnActualizare);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBounds(255, 254, 89, 23);
		contentPane.add(btnInapoi);
		
		JTextArea txtrAfisareaTuturorInformatiilor = new JTextArea();
		txtrAfisareaTuturorInformatiilor.setBackground(new Color(192, 192, 192));
		txtrAfisareaTuturorInformatiilor.setFont(new Font("Vivaldi", Font.BOLD, 25));
		txtrAfisareaTuturorInformatiilor.setText("Afisarea tuturor informatiilor");
		txtrAfisareaTuturorInformatiilor.setBounds(10, 11, 333, 47);
		contentPane.add(txtrAfisareaTuturorInformatiilor);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (1).png"));
		lblNewLabel_1.setBounds(421, 125, 76, 108);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Introduceti numele");
		lblNewLabel_2.setBounds(347, 72, 113, 14);
		contentPane.add(lblNewLabel_2);
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				String query="select*from ang_info where cnp=";
				String cnp1 = cnpField.getText();
				query+=cnp1;
				PreparedStatement rsmd=con.prepareStatement(query); 
				
				ResultSet rs=rsmd.executeQuery(query);
				if(rs.next());
				{
					emailField.setText(rs.getString(2));
					postField.setText(rs.getString(3));
					userField.setText(rs.getString(1));
					salariuField.setText(rs.getString(5));
					contactField.setText(rs.getString(6));
					parolaField.setText(rs.getString(7));
				}
								
				String nume,email,post,id,salariu,contact,parola;
				System.out.println(rs.getString(ABORT));
				/*if(userField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(userField.getText().equals(rs.getString(1))) {
						emailField.setText(rs.getString(2));
						postField.setText(rs.getString(3));
						cnpField.setText(rs.getString(4));
						salariuField.setText(rs.getString(5));
						contactField.setText(rs.getString(6));
						parolaField.setText(rs.getString(7));
						}
					}
				}
				if(emailField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(emailField.getText().equals(rs.getString(2))) {
						userField.setText(rs.getString(1));
						postField.setText(rs.getString(3));
						cnpField.setText(rs.getString(4));
						salariuField.setText(rs.getString(5));
						contactField.setText(rs.getString(6));
						parolaField.setText(rs.getString(7));
						}
					}
				}
				if(postField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(postField.getText().equals(rs.getString(3))) {
						userField.setText(rs.getString(1));
						emailField.setText(rs.getString(2));
						cnpField.setText(rs.getString(4));
						salariuField.setText(rs.getString(5));
						contactField.setText(rs.getString(6));
						parolaField.setText(rs.getString(7));
						}
					}
				}
				if(cnpField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(cnpField.getText().equals(rs.getString(4))) {
						userField.setText(rs.getString(1));
						postField.setText(rs.getString(3));
						emailField.setText(rs.getString(2));
						salariuField.setText(rs.getString(5));
						contactField.setText(rs.getString(6));
						parolaField.setText(rs.getString(7));
						}
					}
				}
				if(salariuField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(salariuField.getText().equals(rs.getString(5))) {
						userField.setText(rs.getString(1));
						postField.setText(rs.getString(3));
						cnpField.setText(rs.getString(4));
						emailField.setText(rs.getString(2));
						contactField.setText(rs.getString(6));
						parolaField.setText(rs.getString(7));
						}
					}
				}
				if(contactField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(contactField.getText().equals(rs.getString(6))) {
						userField.setText(rs.getString(1));
						postField.setText(rs.getString(3));
						cnpField.setText(rs.getString(4));
						salariuField.setText(rs.getString(5));
						emailField.setText(rs.getString(2));
						parolaField.setText(rs.getString(7));
						}
					}
				}
				if(parolaField.getText()!=null)
				{
					while(rs.next()) {	
						
						if(parolaField.getText().equals(rs.getString(7))) {
						userField.setText(rs.getString(1));
						postField.setText(rs.getString(3));
						cnpField.setText(rs.getString(4));
						salariuField.setText(rs.getString(5));
						contactField.setText(rs.getString(6));
						emailField.setText(rs.getString(2));
						}
					}
				}*/
				rsmd.close();
				con.close();
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
