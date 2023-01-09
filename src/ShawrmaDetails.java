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

public class ShawrmaDetails extends CustomerDatabase {

	private JFrame frmShawramaDetails;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void DetailsOfShawrma() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShawrmaDetails window = new ShawrmaDetails();
					window.frmShawramaDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShawrmaDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShawramaDetails = new JFrame();
		frmShawramaDetails.setTitle("Shawrama Details");
		frmShawramaDetails.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				ShowData();
			}
		});
		frmShawramaDetails.setBounds(100, 100, 485, 580);
		frmShawramaDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShawramaDetails.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 113, 408, 386);
		frmShawramaDetails.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblShawrmaDetails = new JLabel("Shawrma Details");
		lblShawrmaDetails.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblShawrmaDetails.setBounds(32, 59, 312, 40);
		frmShawramaDetails.getContentPane().add(lblShawrmaDetails);
		
		JButton btnNewButton = new JButton("<<Go Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmShawramaDetails.setVisible(false);
				CustomerDatabase.DatabaseOfCustomer();
			}
		});
		btnNewButton.setBounds(329, 59, 110, 40);
		frmShawramaDetails.getContentPane().add(btnNewButton);
	}
	private void ShowData() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Customer Name");
		model.addColumn("Shawrma");
		model.addColumn("Shawrma Price");
		try {
			String query2 = "SELECT Name, Shawrma, ShawrmaPrice FROM customerdb";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query2);
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Name"),
						rs.getString("Shawrma"),
						rs.getString("ShawrmaPrice")
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
