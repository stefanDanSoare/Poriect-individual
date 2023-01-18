import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class MeniuAngajat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meniu frame = new Meniu(Angajat x);
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
	public MeniuAngajat(Angajat x) {
		setTitle("Meniu angajat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meniu Principal");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 1 Latest_Icon (5).png"));
		lblNewLabel.setBounds(354, 11, 107, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnView = new JButton("Vizualizare colegi");
		btnView.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (4).png"));
		btnView.setBounds(10, 55, 225, 79);
		contentPane.add(btnView);
		if(x.post.equals("admin")) { btnView.setText("Vizualizare manageri");}
		
		JButton btnCerere = new JButton("Cerere concediu");
		btnCerere.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (2).png"));
		btnCerere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerere.setBounds(558, 55, 225, 79);
		contentPane.add(btnCerere);
		if(x.post.equals("admin")) { btnCerere.setText("Modificare date manageri");}
		
		JButton btnCereri = new JButton("Vizualizare cereri");
		btnCereri.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (4).png"));
		btnCereri.setBounds(558, 133, 225, 79);
		contentPane.add(btnCereri);
		if(x.post.equals("admin")) { btnCereri.setText("Stergere manageri");}
		
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\add-user(1).png\""); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JButton btnLogout = new JButton("Logout\r\n");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(300, 435, 204, 42);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 ZE9tIwk8dZ1ENmxQ5zD11Q.png"));
		lblNewLabel_1.setBounds(0, -11, 915, 525);
		contentPane.add(lblNewLabel_1);
		
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
		
		btnCerere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				if(x.zile<=0) {JOptionPane.showMessageDialog(null, "Nu mai aveti zile libere");	}
				else{CreareCerere frame = new CreareCerere(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
				}
			}
		});
		
		btnCereri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				VizualizareCereri frame = new VizualizareCereri(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
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
