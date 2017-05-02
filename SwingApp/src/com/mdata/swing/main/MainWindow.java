package com.mdata.swing.main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import java.text.ParseException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.invertor.examples.modbus.ModbusMasterTCPConn;
import com.invertor.modbus.ModbusMaster;
import com.mdata.swing.lib.IpaddressTest;
import com.mdata.swing.lib.log;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;



public class MainWindow{
	Display display;
	public static ModbusMaster modbusMaster;
	public static ModbusMasterTCPConn modbusMasterTCPConn;
	protected Shell shell;
	private Menu menu;
	private MenuItem mntmFile;
	private MenuItem mntmConnection;
	private MenuItem mntmNewConnection;
	private Menu menu_1;
	Button btnGetData;
//	ModbusMasterTCPConn modbusMasterTCPConn;
	int[] holdingRegisterValues=null;
	
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;
	private TableItem tableItem;
	public static String ipAddress;
	public static int modbusTCPConnectionTimeOut=1000;
	private Text connectionStatusText;
	private static boolean isConnStatusThreadStarted=true;
	public static Thread connStatusThread;

	public static boolean isConnStatusThreadStarted() {
		return isConnStatusThreadStarted;
	}

	public static void setConnStatusThreadStarted(boolean isConnStatusThreadStarted) {
		MainWindow.isConnStatusThreadStarted = isConnStatusThreadStarted;
	}
	
	public static IpaddressTest ipAddressTest = new IpaddressTest();
	public static TCPConnectionStatusChecker tCPConnectionStatusChecker;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {	
		
			try {
				log.info("testlog");
				
				MainWindow window = new MainWindow();
				window.open();

				log.info("current class:" +window.getClass());
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		prepareGUI();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

 
	/*
	 * This is preparing GUI
	 */
	public void prepareGUI(){
		shell = new Shell();
		shell.setMinimumSize(new Point(600, 400));
		//shell.setSize(450, 300);
		shell.setMaximized(true);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		mntmFile = new MenuItem(menu, SWT.NONE);
		mntmFile.setText("File");
		
		mntmConnection = new MenuItem(menu, SWT.CASCADE);
		mntmConnection.setText("Connection");
		
		menu_1 = new Menu(mntmConnection);
		mntmConnection.setMenu(menu_1);
		
		mntmNewConnection = new MenuItem(menu_1, SWT.CASCADE);
		mntmNewConnection.setText("New Connection");		
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(101, 24, 403, 222);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Column1");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Column2");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Column3");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Column4");
		
		tableItem = new TableItem(table, SWT.NONE);
		
		btnGetData = new Button(shell, SWT.NONE);
		btnGetData.setBounds(384, 278, 75, 25);
		formToolkit.adapt(btnGetData, true, true);
		btnGetData.setText("Get Data");
		
		connectionStatusText = new Text(shell, SWT.BORDER);
		connectionStatusText.setBounds(10, 10, 76, 21);
		formToolkit.adapt(connectionStatusText, true, true);
		
//		table_1 = formToolkit.createTable(shell, SWT.NONE);
//		table_1.setBounds(465, 142, 109, 111);
//		formToolkit.paintBordersFor(table_1);
//		table_1.setHeaderVisible(true);
//		table_1.setLinesVisible(true);

	}
	
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell.addShellListener(new ShellAdapter() {
			public void shellClosing(ShellEvent shellEvent){
				System.exit(0);
			}
		});
		
		
		

		
		btnGetData.addListener(SWT.Selection, new Listener() {
			 
			@Override
			public void handleEvent(Event e) {
				try{
				log.info("Modbus Master Object at getData :" +modbusMaster);
				int offset =0;
//				Object[] data1 ={};
				holdingRegisterValues =modbusMasterTCPConn.readHoldingRegisters(modbusMaster, 1, 0, 10);
				log.info("Holding Registers Length  :" +holdingRegisterValues.length);
				Object[] data1 =new Object[holdingRegisterValues.length];
				log.info("Holding register values:" +holdingRegisterValues);
				for (int value : holdingRegisterValues) {
					log.info("Table Count" +table.getItemCount());
					System.out.println("Address: " + offset + ", Value: " + value);
					tableItem.setText(offset, Integer.toString(value));
					
					//data1[offset]=data;
					offset++;
				}
			}catch(Exception ex){
				log.error(ex.getMessage());
			}
			}
		});
		
		//Added listener class to open new shell
		mntmNewConnection.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
					log.info("Modbus Master Object in MainWindow :" +modbusMaster);
					boolean status=ipAddressTest.ComConnectPanel();
					if(status=true){
						System.out.println("Connection Frame open successfully");
					}else{
						System.out.println("Connection Frame open failed");
					}
			}
		});
		


	}
}
