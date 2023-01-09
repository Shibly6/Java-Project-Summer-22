import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CustomerDatabase extends Restaurantmanagementsystem{
	
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("restaurant.png"));


	private JFrame frmDatabaseOfCustomer;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void DatabaseOfCustomer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDatabase window = new CustomerDatabase();
					window.frmDatabaseOfCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerDatabase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabaseOfCustomer = new JFrame();
		frmDatabaseOfCustomer.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		frmDatabaseOfCustomer.setTitle("Database of Customer");
		frmDatabaseOfCustomer.setBounds(100, 100, 1280, 720);
		frmDatabaseOfCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatabaseOfCustomer.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 154, 940, 488);
		frmDatabaseOfCustomer.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Chicken Fry Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ChickenFryDetails.DetailsOfChickenFry();
				frmDatabaseOfCustomer.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1002, 359, 239, 33);
		frmDatabaseOfCustomer.getContentPane().add(btnNewButton);
		
		JLabel lblCustomerDatabase = new JLabel("Customer Database");
		lblCustomerDatabase.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblCustomerDatabase.setBounds(37, 39, 564, 73);
		frmDatabaseOfCustomer.getContentPane().add(lblCustomerDatabase);
		
		JButton btnFriedRiceDetails = new JButton("Fried Rice Details");
		btnFriedRiceDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FriedRiceDetails.DetailsOfFriedRice();
				frmDatabaseOfCustomer.setVisible(false);
			}
		});
		btnFriedRiceDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFriedRiceDetails.setBounds(1002, 244, 239, 33);
		frmDatabaseOfCustomer.getContentPane().add(btnFriedRiceDetails);
		
		JButton btnShawrmaDetails = new JButton("Shawrma Details");
		btnShawrmaDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShawrmaDetails.DetailsOfShawrma();
				frmDatabaseOfCustomer.setVisible(false);
			}
		});
		btnShawrmaDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShawrmaDetails.setBounds(1002, 300, 239, 33);
		frmDatabaseOfCustomer.getContentPane().add(btnShawrmaDetails);
		
		JButton btnClose = new JButton("<<Go Back");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDatabaseOfCustomer.setVisible(false);
				Restaurantmanagementsystem.RMS();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnClose.setBounds(1028, 499, 198, 95);
		frmDatabaseOfCustomer.getContentPane().add(btnClose);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1276, 37);
		frmDatabaseOfCustomer.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmDatabaseOfCustomer.setVisible(false);
				Restaurantmanagementsystem.RMS();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);
	}

	
	// this method for show data in the table. 
	
	private void ShowData() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Customer Name");
		model.addColumn("Fride Rice");
		model.addColumn("Fride Rice Price");
		model.addColumn("Shawrma");
		model.addColumn("Shawrma Price");
		model.addColumn("Chicken Fry");
		model.addColumn("Chicken Fry Price");
		model.addColumn("Total Price");
		try {
			String query2 = "SELECT * FROM customerdb";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query2);
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Name"),
						rs.getString("FrideRice"),
						rs.getString("FrideRicePrice"),
						rs.getString("Shawrma"),
						rs.getString("ShawrmaPrice"),
						rs.getString("ChickenFry"),
						rs.getString("ChickenFryPrice"),
						rs.getString("TotalPrice")
				});
			}
			
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(200);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(70);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
			table.getColumnModel().getColumn(5).setPreferredWidth(80);
			table.getColumnModel().getColumn(6).setPreferredWidth(130);
			table.getColumnModel().getColumn(7).setPreferredWidth(130);
		    
			//changeing the font size of column header
			JTableHeader tableHeader = table.getTableHeader(); 
			Font headerFont = new Font("Segoe UI", Font.BOLD, 13);
		    tableHeader.setFont(headerFont);

			
		} catch(Exception e) {
			System.out.println("Error: " +e);
		}
	}
}
