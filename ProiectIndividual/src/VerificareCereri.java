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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VerificareCereri extends JFrame {

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
	public VerificareCereri(Angajat x) {
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
		
		JButton btnRespingere = new JButton("Respingere cerere");
		btnRespingere.setBackground(new Color(220, 20, 60));
		btnRespingere.setBounds(490, 282, 143, 23);
		contentPane.add(btnRespingere);
		
		JButton btnAprobare = new JButton("Aprobare cerere");
		btnAprobare.setBackground(new Color(0, 255, 127));
		btnAprobare.setBounds(643, 282, 143, 23);
		contentPane.add(btnAprobare);
		btnBack.setBounds(10, 282, 134, 23);
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
			String query="select*from concedii where cnp_mgr='"+x.CNP+"'  and aprobat='Neverificat'";
			ResultSet rs=st.executeQuery(query);
			@SuppressWarnings("unused")
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData(); 
			DefaultTableModel model= new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
			     //all cells false
			       return false;
			    }
			};
				tabel.setModel(model); 
				int cols=4;
				String[] colname=new String[cols];
				colname[0]="id";
				colname[1]="Data inceperii";
				colname[2]="Data finalizarii";
				colname[3]="Aprobat";
				model.setColumnIdentifiers(colname);
				String nume,email,contact,aprobat;
				while(rs.next()) {
					nume=rs.getString(1);
					email=rs.getString(3);
					contact=rs.getString(4);
					aprobat=rs.getString(5);
					String[] rand = {nume,email,contact,aprobat};
					model.addRow(rand);
					
				
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
			}
			});
		
		
		btnAprobare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				int column = 0;
				int row = tabel.getSelectedRow();
				String value = tabel.getModel().getValueAt(row, column).toString();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
					Statement st=con.createStatement();
					String query="update concedii set aprobat='Aprobat' where id='"+value+"'";
					Statement rsmd=con.createStatement(); 
					rsmd.executeUpdate(query);
					tabel.getModel().setValueAt("Aprobat", row, 3);	
					st.close();
					con.close();
					}catch(ClassNotFoundException e1) {
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		btnRespingere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				int column = 0;
				int row = tabel.getSelectedRow();
				String value = tabel.getModel().getValueAt(row, column).toString();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
					Statement st=con.createStatement();
					String query="update concedii set aprobat='Respins' where id='"+value+"'";
					Statement rsmd=con.createStatement(); 
					rsmd.executeUpdate(query);
					tabel.getModel().setValueAt("Respins", row, 3);	
					query="select data_start, data_end, cnp_angajat from concedii where id='"+value+"'";
					PreparedStatement prs=con.prepareStatement(query); 
					ResultSet rs= prs.executeQuery(query);
					if(rs.next());
					{
						java.sql.Date start= rs.getDate("data_start");
						java.sql.Date end= rs.getDate("data_end");
						String cnp=rs.getString("cnp_angajat");
						long dateS=start.getTime();
						long dateE=end.getTime();
						long days=TimeUnit.DAYS.convert(dateE- dateS, TimeUnit.MILLISECONDS) ;
						days++;
						query="update ang_info set zile=zile+"+days+" where CNP='"+ cnp+"'";
						rsmd=con.createStatement(); 
						rsmd.executeUpdate(query);
						rsmd.close();
					}
					st.close();
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
