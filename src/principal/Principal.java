package principal;
import recursion.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;


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
				//DefaultTableModel temp = (DefaultTableModel) table.getModel();
				Object obj[][] = {
						{"1", "Isidro", "Martínez", edadRamd()},
						{"2", "Abelardo", "López", edadRamd()},
						{"3", "Karen", "Quintero", edadRamd()},
						{"4", "Jaime", "Rodriguez", edadRamd()},
						{"5", "Roberto", "De la O", edadRamd()},
						{"6", "Maria", "Antúnez", edadRamd()},
						{"7", "Ana", "Ramírez", edadRamd()},
						{"8", "Luz", "Vargas", edadRamd()},
						{"9", "Diego", "Cervantes", edadRamd()},
						{"10", "Laura", "Rios", edadRamd()},
						{"11", "Leonardo", "Villa Nueva", edadRamd()},
						{"12", "Omar", "Zaragoza", edadRamd()},
						{"13", "Fernando", "Mendoza", edadRamd()},
						{"14", "Diana", "Flores", edadRamd()},
						{"15", "Luis", "Soler", edadRamd()}
					};
				for(int i=0;i<15;i++){
					for(int n=0;n<4;n++){
						((DefaultTableModel) table.getModel()).setValueAt(obj[i][n], i,n);
					}
				}
			}
		});
		
		JButton btnGeneraHash = new JButton("Genera Hash");
		btnGeneraHash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[][] obj = getTableData(table);
				int hashCode;
				int rows = getCountValidateRows();
				for(int i=0;i<rows;i++){
					hashCode = obj[i][0].hashCode();
					while(isRepeat(hashCode,i,obj)){
						hashCode = generateNewHashValue(hashCode);
					}
					table.setValueAt(hashCode+"", i, 0);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGeneraElementos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGeneraHash)
					.addContainerGap(405, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGeneraElementos)
						.addComponent(btnGeneraHash))
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
						//System.out.println(array[i]);
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
		mntmMergasort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] obj = getTableData(table);
				int sizeArray=0;
				for(int i=0;i<obj.length;i++){
					if(obj[i][3]!=null){
						sizeArray++;
					}
				}
				int[] array = new int[sizeArray+1] ;
				MergeSort a = new MergeSort();
				
				for(int i=0;i<obj.length;i++){
					if(obj[i][3]!=null){
						if(obj[i][3] instanceof String){
							array[i] = Integer.parseInt((String) obj[i][3]);
						}else{
							array[i]=(Integer) obj[i][3];
						}
						//System.out.println(array[i]);
					}
				}
				array = a.OrdenaMerge(array);
				System.out.print("Los elementos en Mergesort son: ");	
				a.imprimeArreglo(array);
				System.out.println();
			}
		});
		mnNewMenu.add(mntmMergasort);
		
		JMenu mnListas = new JMenu("ListasEnlazadas");
		menuBar.add(mnListas);
		
		JMenuItem mntmInsertarAlInicio = new JMenuItem("Insertar al inicio");
		mntmInsertarAlInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] array = getInputArray();
				((DefaultTableModel) table.getModel()).insertRow(0,array);
			}
		});
		mnListas.add(mntmInsertarAlInicio);
		
		JMenuItem mntmInsertarAlFinal = new JMenuItem("Insertar al final");
		mntmInsertarAlFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] array = getInputArray();
				int sizeRow =  getCountValidateRows();
				((DefaultTableModel) table.getModel()).insertRow(sizeRow-1,array);
			}
		});
		mnListas.add(mntmInsertarAlFinal);
		
		JMenuItem mntmInsertarPosicin = new JMenuItem("Insertar posici\u00F3n");
		mntmInsertarPosicin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] array = getInputArray();
				String cadena = JOptionPane.showInputDialog("Posicion a Agregar: ");
				int posicion = Integer.parseInt(cadena);
				((DefaultTableModel) table.getModel()).insertRow(posicion-1,array);
			}
		});
		mnListas.add(mntmInsertarPosicin);
		
		JMenuItem mntmEliminarInicio = new JMenuItem("Eliminar inicio");
		mntmEliminarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).removeRow(0);
			}
		});
		mnListas.add(mntmEliminarInicio);
		
		JMenuItem mntmEliminarFinal = new JMenuItem("Eliminar final");
		mntmEliminarFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int sizeRow =  table.getRowHeight();
				int num = getCountValidateRows();
				System.out.println(num);
				((DefaultTableModel) table.getModel()).removeRow(num-1);
			}
		});
		mnListas.add(mntmEliminarFinal);
		
		JMenuItem mntmEliminarPosicin = new JMenuItem("Eliminar posici\u00F3n");
		mntmEliminarPosicin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = JOptionPane.showInputDialog("Posicion a eliminar: ");
				int posicion = Integer.parseInt(cadena);
				((DefaultTableModel) table.getModel()).removeRow(posicion-1);
			}
		});
		mnListas.add(mntmEliminarPosicin);
		
		JMenu mnHash = new JMenu("Hash");
		menuBar.add(mnHash);
		
		JMenuItem mntmInsertar = new JMenuItem("Insertar");
		mntmInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rows = getCountValidateRows();
				
				String[] array = getInputArray();
				
				int hashValue = Integer.parseInt(array[0]);
				while(isRepeat(hashValue,rows)){
					hashValue = generateNewHashValue(hashValue);
				}
				array[0] = hashValue+"";
				((DefaultTableModel) table.getModel()).insertRow(rows,array);
			}
		});
		mnHash.add(mntmInsertar);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = JOptionPane.showInputDialog("Posicion a buscar: ");
				int posicion = Integer.parseInt(cadena);
				/////////////////////////////////////////7-
				if(isRepeat(posicion,getCountValidateRows())){
					ListSelectionModel selectionModel = table.getSelectionModel();
					selectionModel.setSelectionInterval(posicion-1,posicion-1);
				}else{
					//JOptionPane.showConfirmDialog(null,"No se encontró",JOptionPane.OK_CANCEL_OPTION);
					JOptionPane.showMessageDialog(null, "No se encontró");
				}
			}
		});
		mnHash.add(mntmBuscar);
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
	
	public String [] getInputArray(){
		String [] array ={"","","",""};
		JTextField id = new JTextField();  
		JTextField nombre = new JTextField();  
		JTextField apellido = new JTextField();  
		JTextField edad = new JTextField();   
		Object[] message = {  
		    "ID:", id,  
		    "Nombre:", nombre,  
		    "Apellido:", apellido,  
		    "Edad:", edad, 
		};  
		int option = JOptionPane.showConfirmDialog(null, message, "Llena el formulario", JOptionPane.OK_CANCEL_OPTION);
		if(option == JOptionPane.OK_OPTION){
			array[0]=id.getText();
			array[1]=nombre.getText();
			array[2]=apellido.getText();
			array[3]=edad.getText();
		}
		return array;
	}
	
	public int getCountValidateRows(){
		int count=0;
		Object[][] obj = getTableData(table);
		for(int i=0;i<obj.length;i++){
			if(obj[i][3]!=null & obj[i][0]!=null){
				count++;
			}
		}
		return count;
	}
	
	private int generateNewHashValue(int hashCode) {
		// TODO Auto-generated method stub
		String s = hashCode+"";
		return (s.hashCode());
	}

	private boolean isRepeat(int hashCode, int posicion, Object[][] obj) {
		for(int i=posicion-1;-1<i;i--){
			if(hashCode == obj[i][0].hashCode()){
				return true;
			}
		}
		return false;
	}
	
	private boolean isRepeat(int hashCode, int posicion) {
		Object[][] obj = getTableData(table);
		for(int i=posicion-1;-1<i;i--){
			if(hashCode == Integer.parseInt((String) obj[i][0])){
				return true;
			}
		}
		return false;
	}
	
	public int generateDoubleHash(int n){
		n = (n+"").hashCode();
		return n;
	}
}
