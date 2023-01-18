import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Meniu extends JFrame {

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
	public Meniu(Angajat x) {
		setTitle("Meniu ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVizualizareCereri = new JButton("Vizualizare cereri");
		btnVizualizareCereri.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (4).png"));
		btnVizualizareCereri.setBounds(555, 215, 225, 79);
		contentPane.add(btnVizualizareCereri);
		if(x.post.equals("admin")) {btnVizualizareCereri.setVisible(false);}
		
		JButton btnLogout = new JButton("Logout\r\n");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(278, 446, 204, 42);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Meniu Principal");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 1 Latest_Icon (5).png"));
		lblNewLabel.setBounds(327, 11, 107, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Adaugare angajat");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project.png"));
		btnAdd.setSelectedIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project.png"));
		btnAdd.setBounds(10, 61, 225, 79);
		contentPane.add(btnAdd);
		if(x.post.equals("admin")) { btnAdd.setText("Adaugare manageri");}
		JButton btnView = new JButton("Vizualizare angajati");
		btnView.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (4).png"));
		btnView.setBounds(10, 140, 225, 79);
		contentPane.add(btnView);
		if(x.post.equals("admin")) { btnView.setText("Vizualizare manageri");}
		
		JButton btnCaut = new JButton("Cautare angajati");
		btnCaut.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (1).png"));
		btnCaut.setBounds(10, 215, 225, 85);
		contentPane.add(btnCaut);
		if(x.post.equals("admin")) { btnCaut.setText("Cautare manageri");}
		
		JButton btnMod = new JButton("Modificare date angajat");
		btnMod.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (2).png"));
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMod.setBounds(555, 61, 225, 79);
		contentPane.add(btnMod);
		if(x.post.equals("admin")) { btnMod.setText("Modificare date manageri");}
		
		JButton btnSterg = new JButton("Stergere angajat");
		btnSterg.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\My project (3).png"));
		btnSterg.setBounds(555, 140, 225, 79);
		contentPane.add(btnSterg);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\1 ZE9tIwk8dZ1ENmxQ5zD11Q.png"));
		lblNewLabel_1.setBounds(0, 2, 800, 517);
		contentPane.add(lblNewLabel_1);
		if(x.post.equals("admin")) { btnSterg.setText("Stergere manageri");}
		
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\stefa\\OneDrive\\Desktop\\icons\\add-user(1).png\""); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				if( x.post.equals("manager")) {
				AddManager frame = new AddManager(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
				}
				else {AddAdmin frame = new AddAdmin(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
				}
			}
		});
		
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
		
		btnCaut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Cautare frame = new Cautare(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Cautare frame = new Cautare(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnSterg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				Cautare frame = new Cautare(x);
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
		btnVizualizareCereri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				VerificareCereri frame = new VerificareCereri(x);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
	}
}
