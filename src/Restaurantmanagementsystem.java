import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class Restaurantmanagementsystem {
	JFrame frame;
	
	double FriedRice;
	double getFriedRice;
	double Shawrma;
	double getShawrma;
	double Chicken;
	double getChicken;
	double getTotal;
	

	private JTextField txtFriedRice;
	private JTextField txtShawrma;
	private JTextField txtChicken;
	

	/**
	 * Launch the application.
	 */
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("restaurant.png"));
	private JTextField textCustomerName;
	
	public static void RMS() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurantmanagementsystem window = new Restaurantmanagementsystem();
					window.frame.setVisible(true);
					window.frame.setTitle("Restaurant Management System");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Restaurantmanagementsystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(logo.getImage());
		
		JLabel lblNewLabel = new JLabel("Restaurant Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setBounds(10, 47, 884, 73);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(41, 244, 126, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quntity");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1_1.setBounds(321, 244, 126, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1_2.setBounds(648, 235, 126, 37);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel btnFriedRice = new JLabel("Fried Rice");
		btnFriedRice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnFriedRice.setBounds(41, 301, 155, 47);
		frame.getContentPane().add(btnFriedRice);
		
		JLabel btnShawrma = new JLabel("Shawrma");
		btnShawrma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnShawrma.setBounds(41, 353, 155, 47);
		frame.getContentPane().add(btnShawrma);
		
		JLabel btnChicken = new JLabel("Chicken Fry");
		btnChicken.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnChicken.setBounds(41, 407, 155, 47);
		frame.getContentPane().add(btnChicken);
		
		txtFriedRice = new JTextField();
		txtFriedRice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtFriedRice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFriedRice.setBounds(321, 299, 155, 37);
		frame.getContentPane().add(txtFriedRice);
		txtFriedRice.setColumns(10);
		
		txtShawrma = new JTextField();
		txtShawrma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtShawrma.setColumns(10);
		txtShawrma.setBounds(321, 349, 155, 37);
		frame.getContentPane().add(txtShawrma);
		
		txtChicken = new JTextField();
		txtChicken.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtChicken.setColumns(10);
		txtChicken.setBounds(321, 403, 155, 37);
		frame.getContentPane().add(txtChicken);
		
		JLabel lblNewLabel_2_2 = new JLabel("120 BDT");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2.setBounds(648, 292, 127, 47);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("60 BDT");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2_1.setBounds(647, 344, 127, 47);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("80 BDT");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2_2.setBounds(648, 393, 127, 47);
		frame.getContentPane().add(lblNewLabel_2_2_2);

		
		JLabel lblNewLabel_1_2_1 = new JLabel("Total Item Price");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1_2_1.setBounds(898, 242, 261, 37);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel BDT1 = new JLabel("");
		BDT1.setBorder((Border) new LineBorder(new Color(0, 0, 0), 1));
		BDT1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		BDT1.setBounds(928, 302, 155, 37);
		frame.getContentPane().add(BDT1);
		
		JLabel BDT2 = new JLabel("");
		BDT2.setBorder((Border) new LineBorder(new Color(0, 0, 0), 1));
		BDT2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		BDT2.setBounds(928, 356, 155, 37);
		frame.getContentPane().add(BDT2);
		
		JLabel BDT3 = new JLabel("");
		BDT3.setBorder((Border) new LineBorder(new Color(0, 0, 0), 1));
		BDT3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		BDT3.setBounds(928, 403, 155, 37);
		frame.getContentPane().add(BDT3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Total Price");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1_2_1_1.setBounds(41, 593, 177, 37);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel BDT = new JLabel("");
		BDT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		BDT.setBorder((Border) new LineBorder(new Color(0, 0, 0), 1));
		BDT.setBounds(294, 593, 171, 37);
		frame.getContentPane().add(BDT);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				FriedRice = Double.parseDouble(txtFriedRice.getText());
				double pFriedRice = 120.00;
				getFriedRice=(FriedRice*pFriedRice);
				String TotalFriedRice= String.format("%.2f", getFriedRice);
				BDT1.setText(TotalFriedRice);
				double total=getFriedRice;
				String TotalBDT=String.format("%.2f", total);
				BDT.setText(TotalBDT);	


				Shawrma = Double.parseDouble(txtShawrma.getText());
				double pShawrma = 60.00;
				getShawrma=(Shawrma*pShawrma);
				String TotalShawrma= String.format("%.2f", getShawrma);
				BDT2.setText(TotalShawrma);
				total=total+getShawrma;
				TotalBDT=String.format("%.2f", total);
				BDT.setText(TotalBDT);	
				

				Chicken = Double.parseDouble(txtChicken.getText());
				double pChicken = 80.00;
				getChicken=(Chicken*pChicken);
				String TotalChicken= String.format("%.2f", getChicken);
				BDT3.setText(TotalChicken);				
				total=total+getChicken;			
				
				TotalBDT=String.format("%.2f", total);
				BDT.setText(TotalBDT);
				getTotal = getFriedRice + getChicken + getShawrma;
				//Calling SaveToDatabase method for saving the data
				SaveToDatabase();
				}
				catch(Exception E)
				{

					JOptionPane.showMessageDialog(null, "Only Integer numbers are accepted!");
				}

				
			}
			
		});
		
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(847, 481, 118, 37);
		frame.getContentPane().add(btnSubmit);
		
		

		
		JButton btnReset1 = new JButton("Reset");
		btnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFriedRice.setText(null);
				txtShawrma.setText(null);
				txtChicken.setText(null);
				BDT.setText(null);
				BDT1.setText(null);
				BDT2.setText(null);
				BDT3.setText(null);
			}
		});
		btnReset1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset1.setBounds(970, 481, 118, 37);
		frame.getContentPane().add(btnReset1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1276, 37);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtFriedRice.setText(null);
				txtShawrma.setText(null);
				txtChicken.setText(null);
				BDT.setText(null);
				BDT1.setText(null);
				BDT2.setText(null);
				BDT3.setText(null);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Refresh");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtFriedRice.setText(null);
				txtShawrma.setText(null);
				txtChicken.setText(null);
				BDT.setText(null);
				BDT1.setText(null);
				BDT2.setText(null);
				BDT3.setText(null);
				
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JLabel lblCostomarName = new JLabel("Customer Name");
		lblCostomarName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCostomarName.setBounds(41, 151, 189, 47);
		frame.getContentPane().add(lblCostomarName);
		
		textCustomerName = new JTextField();
		textCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textCustomerName.setColumns(10);
		textCustomerName.setBounds(266, 156, 275, 37);
		frame.getContentPane().add(textCustomerName);
		
		JButton btnOpenCustomerDatabase = new JButton("Open Customer Database");
		btnOpenCustomerDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CustomerDatabase.DatabaseOfCustomer();
				frame.setVisible(false);
			}
		});
		btnOpenCustomerDatabase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOpenCustomerDatabase.setBounds(758, 597, 325, 37);
		frame.getContentPane().add(btnOpenCustomerDatabase);
	}
	
	//this is the database connection method
	static Connection con()
	{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/restaurantmanagementsystem";
			Class.forName(driver);
			return DriverManager.getConnection(url, "root", "");
			
		} catch (Exception e)
		{
			System.out.println("Connection Failed!");

		}
		return null;
	}
	//This method saving the data to database
	private void SaveToDatabase()
	{
		String name = textCustomerName.getText();
		Connection con = con();
		try {
			String query = "INSERT INTO customerdb VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setDouble(2, FriedRice);
			ps.setDouble(3, getFriedRice);
			ps.setDouble(4, Shawrma);
			ps.setDouble(5, getShawrma);
			ps.setDouble(6, Chicken);
			ps.setDouble(7, getChicken);
			ps.setDouble(8, getTotal);
			ps.executeUpdate();			
			JOptionPane.showMessageDialog(null, "Saved to database!");
			
		}catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
}
