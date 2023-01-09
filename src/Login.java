import java.awt.EventQueue;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;

import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends Restaurantmanagementsystem {
	


	private JFrame frmLogin;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 478);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblEmployeeLogin = new JLabel("Login");
		lblEmployeeLogin.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblEmployeeLogin.setBounds(182, 20, 89, 40);
		frmLogin.getContentPane().add(lblEmployeeLogin);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 25));
		user.setColumns(10);
		user.setBounds(52, 147, 319, 37);
		frmLogin.getContentPane().add(user);
		
		JLabel lblEmployeeName = new JLabel("ID");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmployeeName.setBounds(67, 99, 187, 47);
		frmLogin.getContentPane().add(lblEmployeeName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(67, 205, 112, 47);
		frmLogin.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection conn = con();
					Statement stmt = conn.createStatement();
					String sql="SELECT * FROM customer WHERE customer_id='"+user.getText()+"' and Pass='"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);

					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Sucessfull!");
						RMS();
						frmLogin.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Unsucessfull!");
						frmLogin.setVisible(true);
					}
					
					
				}catch(Exception E){
					System.out.println("Error" +E);
				}
			
			}
		});
		
		int ID = Integer.parseInt(user.getText());
		
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(268, 320, 103, 37);
		frmLogin.getContentPane().add(btnLogin);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pass.setBounds(52, 252, 319, 37);
		frmLogin.getContentPane().add(pass);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registration.reg();
				frmLogin.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(20, 355, 171, 40);
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblDoNotHave = new JLabel("Do not have \r\nan account?");
		lblDoNotHave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDoNotHave.setBounds(10, 317, 198, 40);
		frmLogin.getContentPane().add(lblDoNotHave);
	}
}
