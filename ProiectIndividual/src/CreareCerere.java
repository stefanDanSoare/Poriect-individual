
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CreareCerere extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CreareCerere(Angajat x) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Selectati data de incepere, apoi confirmati", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(-1, 334, 453, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser date_Start = new JDateChooser();
		date_Start.setBounds(6, 16, 249, 29);
		panel.add(date_Start);
		date_Start.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		date_Start.setToolTipText("Selectare data");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Selectati data de terminare, apoi confirmati", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 386, 452, 51);
		contentPane.add(panel_1);
		
		JDateChooser date_End = new JDateChooser();
		date_End.setToolTipText("Selectare data");
		date_End.setBounds(6, 16, 249, 29);
		panel_1.add(date_End);
		
		JButton btnView_1 = new JButton("Confirmatia data");
		btnView_1.setBounds(277, 16, 165, 29);
		panel_1.add(btnView_1);
		
		
		date_Start.setMinSelectableDate(new Date());
		
	
		JButton btnView = new JButton("Confirmatia data");
		btnView.setBounds(278, 17, 165, 28);
		panel.add(btnView);
		
		JButton btnSend = new JButton("Trimiteti cererea");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSend.setBounds(478, 386, 139, 40);
		contentPane.add(btnSend);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\rrr.jpg"));
		lblNewLabel.setBounds(0, 0, 688, 437);
		contentPane.add(lblNewLabel);
		
		btnView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				if(date_Start.getDateFormatString()!=null)
					{
					Date date=date_Start.getDate();
					date_End.setMinSelectableDate(date);
					Calendar cal= Calendar.getInstance();
					cal.setTime(date);
					int daysToAdd = x.zile;
				    cal.add(Calendar.DATE, daysToAdd);
				    Date newDate = cal.getTime();
				    date_End.setMaxSelectableDate(newDate);
				    date_Start.setEnabled(false);
					}
				
			}
		});
		btnView_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				long days = 0;
				if(date_End.getDateFormatString()!=null)
					{
					date_End.setEnabled(false);
					}
				System.out.println (days+ "used");
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent a) {
				long days = 0;
					long dateE=date_End.getDate().getTime();
					long dateS=date_Start.getDate().getTime();
					days=TimeUnit.DAYS.convert(dateE- dateS, TimeUnit.MILLISECONDS) ;
					days++;
					java.sql.Date start= new java.sql.Date(date_Start.getDate().getTime());
					java.sql.Date end= new java.sql.Date(date_End.getDate().getTime());
					try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "nabucodonosor2!");
	                    String query = "INSERT INTO concedii (cnp_angajat, data_start, data_end, aprobat, cnp_mgr)  values('" + x.CNP + "','" + start + "','" + end + "','" + "Neverificat" + "','" +
			                x.manager+"')";
	                    Statement sta = connection.createStatement();
	                    int aux = sta.executeUpdate(query);
	                    query="update ang_info set zile='"+(x.zile-days)+
								"' where cnp='"+x.CNP+"'";
	                    x.zile-=days;
	                    aux = sta.executeUpdate(query);
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				MeniuAngajat frame = new MeniuAngajat(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
	}
}
