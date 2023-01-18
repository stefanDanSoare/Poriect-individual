import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Vizualizare extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vizualizare frame = new Vizualizare("angajati.txt");
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
	FileWriter fw;
	static String lineSeparator =System.getProperty("line.separator");
	private JTable tabel;
	public Vizualizare(Angajat x) {
		setTitle("Vizualizare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JButton btnBack = new JButton("Inapoi");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(652, 282, 134, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(89, 316, 605, 202);
		contentPane.add(scrollPane_1);
		
		tabel = new JTable();
		scrollPane_1.setViewportView(tabel);
		tabel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tabel.setBackground(Color.WHITE);
		tabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
			Statement st=con.createStatement();
			String query="";
			if(x.post.equals("admin")) {query="select*from mgr_info";}
			if(x.post.equals("manager")) {query="select*from ang_info where manager='"+x.CNP+"'";}
			if(x.post.equals("angajat")) {query="select*from ang_info where manager='"+x.manager+"'";}
			ResultSet rs=st.executeQuery(query);
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData(); 
			DefaultTableModel model= new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			     //all cells false
			       return false;
			    }
			};
			if(x.post.equals("admin")) {
				tabel.setModel(model); 
				int cols=rsmd.getColumnCount()-2;
				String[] colname=new String[cols];
				for(int i=0; i<cols; i++) 
					colname[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colname);
				String nume,email,post,id,salariu,contact,zile;
				while(rs.next()) {
					nume=rs.getString(1);
					email=rs.getString(2);
					post=rs.getString(3);
					id=rs.getString(4);
					salariu=rs.getString(5);
					contact=rs.getString(6);
					zile=Integer.toString(rs.getInt(7));
					
					String[] rand = {nume,email,post,id,salariu,contact, zile};
					model.addRow(rand);
				}
				}
			if(x.post.equals("manager")) {
			tabel.setModel(model); 
			int cols=rsmd.getColumnCount()-2;
			String[] colname=new String[cols];
			for(int i=0; i<cols; i++) 
				colname[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colname);
			String nume,email,post,id,salariu,contact,zile;
			while(rs.next()) {
				nume=rs.getString(1);
				email=rs.getString(2);
				post=rs.getString(3);
				id=rs.getString(4);
				salariu=rs.getString(5);
				contact=rs.getString(6);
				zile=Integer.toString(rs.getInt(7));
				String[] rand = {nume,email,post,id,salariu,contact, zile};
				model.addRow(rand);
			}
			}
			else if(x.post.equals("angajat")) {
				tabel.setModel(model); 
				int cols=3;
				String[] colname=new String[cols];
				colname[0]="nume";
				colname[1]="email";
				colname[2]="contact";
				model.setColumnIdentifiers(colname);
				String nume,email,contact;
				while(rs.next()) {
					nume=rs.getString(2);
					email=rs.getString(3);
					contact=rs.getString(6);
					String[] rand = {nume,email,contact};
					model.addRow(rand);
				}	
				
			}
			else {
				
			}
			st.close();
			con.close();
			}catch(ClassNotFoundException e1) {
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\Personeel-vinden-Verrekijker-1024x592.png"));
		lblNewLabel_1.setBounds(0, 0, 796, 529);
		contentPane.add(lblNewLabel_1);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Meniu frame = new Meniu(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
				if(x.post.equals("angajat")) {
					MeniuAngajat fram = new MeniuAngajat(x);
					fram.setResizable(false);
					fram.setLocationRelativeTo(null);
					fram.setVisible(true);
					dispose();
					}
			}
		});
	}
}
