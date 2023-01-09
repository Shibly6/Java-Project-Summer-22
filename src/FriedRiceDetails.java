import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FriedRiceDetails extends CustomerDatabase{

	private JFrame frmFrideRiceDetails;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblFrideRiceDetails;

	/**
	 * Launch the application.
	 */
	public static void DetailsOfFriedRice() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriedRiceDetails window = new FriedRiceDetails();
					window.frmFrideRiceDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FriedRiceDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrideRiceDetails = new JFrame();
		frmFrideRiceDetails.setTitle("Fride Rice Details");
		frmFrideRiceDetails.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		frmFrideRiceDetails.setBounds(100, 100, 485, 580);
		frmFrideRiceDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrideRiceDetails.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 113, 408, 386);
		frmFrideRiceDetails.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("<<Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFrideRiceDetails.setVisible(false);
				CustomerDatabase.DatabaseOfCustomer();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(330, 59, 110, 39);
		frmFrideRiceDetails.getContentPane().add(btnNewButton);
		
		lblFrideRiceDetails = new JLabel("Fride Rice Details");
		lblFrideRiceDetails.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblFrideRiceDetails.setBounds(32, 59, 312, 40);
		frmFrideRiceDetails.getContentPane().add(lblFrideRiceDetails);
	}
	

	private void ShowData() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Customer Name");
		model.addColumn("Fride Rice");
		model.addColumn("Fride Rice Price");
		try {
			String query3 = "SELECT Name, FrideRice, FrideRicePrice FROM customerdb";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query3);
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Name"),
						rs.getString("FrideRice"),
						rs.getString("FrideRicePrice")
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
