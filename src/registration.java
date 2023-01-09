import java.awt.EventQueue;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class registration extends Restaurantmanagementsystem{

	private JFrame frmCustomerRegistration;
	public JTextField textID;
	public JTextField textName;
	private JPasswordField passwordField;
	private ButtonGroup bg = new ButtonGroup();
	private String Gender;


	/**
	 * Launch the application.
	 */
	public static void reg() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frmCustomerRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerRegistration = new JFrame();
		frmCustomerRegistration.setTitle("Customer Registration");
		frmCustomerRegistration.setBounds(100, 100, 537, 592);
		frmCustomerRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerRegistration.getContentPane().setLayout(null);
		
		JLabel lblCustomerRegistration = new JLabel("Customer Registration");
		lblCustomerRegistration.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblCustomerRegistration.setBounds(62, 20, 387, 40);
		frmCustomerRegistration.getContentPane().add(lblCustomerRegistration);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textID.setColumns(10);
		textID.setBounds(87, 122, 275, 37);
		frmCustomerRegistration.getContentPane().add(textID);
		
		JLabel lblI = new JLabel("ID");
		lblI.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblI.setBounds(88, 76, 187, 47);
		frmCustomerRegistration.getContentPane().add(lblI);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textName.setColumns(10);
		textName.setBounds(88, 220, 275, 37);
		frmCustomerRegistration.getContentPane().add(textName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblName.setBounds(88, 169, 187, 47);
		frmCustomerRegistration.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(87, 267, 187, 47);
		frmCustomerRegistration.getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGender.setBounds(88, 365, 91, 47);
		frmCustomerRegistration.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender = "Male";
			}
		});
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnMale.setBounds(193, 368, 103, 40);
		frmCustomerRegistration.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender = "Female";
			}
		});
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnFemale.setBounds(298, 368, 103, 40);
		frmCustomerRegistration.getContentPane().add(rdbtnFemale);
		
		//make the Radio "Pizza Size" groups
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SaveToDatabase();
					//EmployeeLogin cm = new EmployeeLogin();
					Login.main(null);
					frmCustomerRegistration.setVisible(false);
				}catch(Exception E) {
					System.out.println("Error: " + E);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(78, 424, 171, 40);
		frmCustomerRegistration.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Already have \r\nan account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(298, 427, 198, 40);
		frmCustomerRegistration.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frmCustomerRegistration.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(382, 475, 103, 30);
		frmCustomerRegistration.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(87, 314, 275, 37);
		frmCustomerRegistration.getContentPane().add(passwordField);
	}
	private void SaveToDatabase()
	{
		Connection con = con();
		try {
			String query = "INSERT INTO customer VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, textID.getText());
			ps.setString(2, textName.getText());
			ps.setString(3, passwordField.getText().toString());
			ps.setString(4, Gender);
			
			ps.executeUpdate();			
			JOptionPane.showMessageDialog(null, "Registration Successfully!");
			
		}catch (Exception e) {
			System.out.println("Error" + e);
			JOptionPane.showMessageDialog(null, "Registration unsuccessfully! Maybe your 'ID' already taken,try another 'ID'.");
		}
	}
}
