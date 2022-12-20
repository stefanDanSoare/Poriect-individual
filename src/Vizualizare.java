import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
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
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	public Vizualizare() {
		setTitle("Vizualizare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCautare = new JButton("Cautare angajat");
		btnCautare.setForeground(new Color(0, 0, 0));
		btnCautare.setBackground(Color.LIGHT_GRAY);
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCautare.setBounds(440, 271, 134, 23);
		contentPane.add(btnCautare);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\eye.png"));
		lblNewLabel.setBounds(496, 352, 24, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\11 (3).png"));
		lblNewLabel_1.setBounds(-50, 0, 637, 243);
		contentPane.add(lblNewLabel_1);
		
		
			
		JButton btnBack = new JButton("Inapoi");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(440, 495, 134, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(10, 241, 417, 277);
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
		
		JButton btnVizualizareAngajati = new JButton("Vizualizare angajati");
		btnVizualizareAngajati.setBackground(Color.LIGHT_GRAY);
		btnVizualizareAngajati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
				Statement st=con.createStatement();
				String query="select*from ang_info";
				ResultSet rs=st.executeQuery(query);
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData(); 
				DefaultTableModel model=(DefaultTableModel) tabel.getModel(); 
				
				int cols=rsmd.getColumnCount();
				String[] colname=new String[cols];
				for(int i=0; i<cols; i++) 
					colname[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colname);
				String nume,email,post,id,salariu,contact,parola;
				while(rs.next()) {
					nume=rs.getString(1);
					email=rs.getString(2);
					post=rs.getString(3);
					id=rs.getString(4);
					salariu=rs.getString(5);
					contact=rs.getString(6);
					parola=rs.getString(7);
					String[] rand = {nume,email,post,id,salariu,contact,parola};
					model.addRow(rand);
				}
				st.close();
				con.close();
				}catch(ClassNotFoundException e1) {
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnVizualizareAngajati.setEnabled(false);
			}
		});
		btnVizualizareAngajati.setBounds(440, 237, 134, 23);
		contentPane.add(btnVizualizareAngajati);
		
		btnCautare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Cautare frame = new Cautare();
				frame.setVisible(true);
				dispose();
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
}
