import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Meniu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meniu frame = new Meniu();
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
	public Meniu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meniu Principal");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 1 Latest_Icon (5).png"));
		lblNewLabel.setBounds(89, 11, 107, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Adaugare angajat");
		btnAdd.setBounds(75, 144, 150, 23);
		contentPane.add(btnAdd);
		
		JButton btnView = new JButton("Vizualizare angajati");
		btnView.setBounds(75, 222, 150, 23);
		contentPane.add(btnView);
		
		JButton btnCaut = new JButton("Cautare angajati");
		btnCaut.setBounds(75, 303, 150, 23);
		contentPane.add(btnCaut);
		
		JButton btnMod = new JButton("Modificare date angajat");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMod.setBounds(75, 384, 150, 23);
		contentPane.add(btnMod);
		
		JButton btnSterg = new JButton("Stergere angajat");
		btnSterg.setBounds(75, 465, 150, 23);
		contentPane.add(btnSterg);
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\add-user(1).png\""); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setLabelFor(btnView);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (4).png"));
		lblNewLabel_2.setBounds(0, 175, 70, 70);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setLabelFor(btnAdd);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project.png"));
		lblNewLabel_1.setBounds(0, 97, 70, 70);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setLabelFor(btnCaut);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (1).png"));
		lblNewLabel_3.setBounds(0, 256, 70, 70);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setLabelFor(btnMod);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (2).png"));
		lblNewLabel_4.setBounds(0, 337, 70, 70);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setLabelFor(btnSterg);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (3).png"));
		lblNewLabel_5.setBounds(0, 418, 70, 70);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\LeftPanel.jpg"));
		lblNewLabel_6.setBounds(235, 0, 372, 488);
		contentPane.add(lblNewLabel_6);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Logare frame = new Logare();
				frame.setResizable(false);
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Vizualizare frame = new Vizualizare();
				frame.setVisible(true);
				dispose();
			}
		});
		
				
		
	}

}
