package principal;
import recursion.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Principal {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		
		JButton btnGeneraElementos = new JButton("Genera Elementos");
		btnGeneraElementos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Object obj[][] = {
						{1, "Isidro", "Martínez", edadRamd()},
						{2, "Abelardo", "López", edadRamd()},
						{3, "Karen", "Quintero", edadRamd()},
						{4, "Jaime", "Rodriguez", edadRamd()},
						{5, "Roberto", "De la O", edadRamd()},
						{6, "Maria", "Antúnez", edadRamd()},
						{7, "Ana", "Ramírez", edadRamd()},
						{8, "Luz", "Vargas", edadRamd()},
						{9, "Diego", "Cervantes", edadRamd()},
						{10, "Laura", "Rios", edadRamd()},
						{11, "Leonardo", "Villa Nueva", edadRamd()},
						{12, "Omar", "Zaragoza", edadRamd()},
						{13, "Fernando", "Mendoza", edadRamd()},
						{14, "Diana", "Flores", edadRamd()},
						{15, "Luis", "Soler", edadRamd()}
					};
				for(int i=0;i<15;i++){
					((DefaultTableModel) table.getModel()).insertRow(i,obj[i]);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGeneraElementos)
					.addContainerGap(549, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGeneraElementos)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "NOMBRE", "APELLIDOS", "EDAD"
			}
		));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ordenamiento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmKicksort = new JMenuItem("KickSort");
		mntmKicksort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[][] obj = getTableData(table);
				int sizeArray=0;
				for(int i=0;i<obj.length;i++){
					if(obj[i][3]!=null){
						sizeArray++;
					}
				}
				int[] array = new int[sizeArray+1] ;
				Kicksort a = new Kicksort();
				
				for(int i=0;i<obj.length;i++){
					if(obj[i][3]!=null){
						if(obj[i][3] instanceof String){
							array[i] = Integer.parseInt((String) obj[i][3]);
						}else{
							array[i]=(Integer) obj[i][3];
						}
						System.out.println(array[i]);
					}
				}
				System.out.print("Los elementos en kicksort son: ");
				a.imprimeArreglo(a.quicksort(array));
				System.out.println();
				
				//JOptionPane.showMessageDialog(frame, this,"e", 0);
			}
		});
		mnNewMenu.add(mntmKicksort);
		
		JMenuItem mntmMergasort = new JMenuItem("MergeSort");
		mnNewMenu.add(mntmMergasort);
	}
	
	private int edadRamd(){
		int entero;
		entero = (int) Math.round(Math.random()*15);

		return entero;
	}
	public Object[][] getTableData (JTable table) {
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = dtm.getValueAt(i,j);
	    return tableData;
	}
}
