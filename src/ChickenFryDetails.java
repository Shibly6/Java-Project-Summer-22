import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChickenFryDetails extends CustomerDatabase {

	private JFrame frmDetailsOfChickenfry;
	private JTable table;
	private JLabel lblChickenFiryDetails;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void DetailsOfChickenFry() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChickenFryDetails window = new ChickenFryDetails();
					window.frmDetailsOfChickenfry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChickenFryDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDetailsOfChickenfry = new JFrame();
		frmDetailsOfChickenfry.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		frmDetailsOfChickenfry.setTitle("Details Of ChickenFry");
		frmDetailsOfChickenfry.setBounds(100, 100, 485, 580);
		frmDetailsOfChickenfry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetailsOfChickenfry.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 113, 408, 386);
		frmDetailsOfChickenfry.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblChickenFiryDetails = new JLabel("Chicken Firy Details");
		lblChickenFiryDetails.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblChickenFiryDetails.setBounds(32, 63, 312, 40);
		frmDetailsOfChickenfry.getContentPane().add(lblChickenFiryDetails);
		
		btnNewButton = new JButton("<<Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDetailsOfChickenfry.setVisible(false);
				CustomerDatabase.DatabaseOfCustomer();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(330, 63, 110, 40);
		frmDetailsOfChickenfry.getContentPane().add(btnNewButton);
	}
	
	private void ShowData() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Customer Name");
		model.addColumn("Chicken Fry");
		model.addColumn("Chicken Fry Price");
		try {
			String query2 = "SELECT Name, ChickenFry, ChickenFryPrice FROM customerdb";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query2);
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Name"),
						rs.getString("ChickenFry"),
						rs.getString("ChickenFryPrice")
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
		    
			//changeing the font size of column header
			JTableHeader tableHeader = table.getTableHeader(); 
			Font headerFont = new Font("Segoe UI", Font.BOLD, 13);
		    tableHeader.setFont(headerFont);

			
		} catch(Exception e) {
			System.out.println("Error: " +e);
		}
	}
}
