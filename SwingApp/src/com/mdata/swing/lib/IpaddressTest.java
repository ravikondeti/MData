package com.mdata.swing.lib;

import java.awt.Checkbox;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.ibm.icu.util.StringTokenizer;
import com.invertor.examples.modbus.ModbusMasterTCPConn;
import com.invertor.modbus.ModbusMaster;
import com.invertor.modbus.data.comm.ModbusCommEvent;
import com.invertor.modbus.data.comm.ModbusCommEventReceive;
import com.invertor.modbus.exception.ModbusIOException;
import com.invertor.modbus.exception.ModbusNumberException;
import com.invertor.modbus.exception.ModbusProtocolException;
import com.invertor.modbus.tcp.TcpParameters;
import com.mdata.swing.main.MainWindow;
import com.mdata.swing.main.TCPConnectionStatusChecker;

import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JCheckBox;

public class IpaddressTest extends JFrame {

	private JPanel contentPane;
	//private String ipAddress;
	private JTextField portNumberText;
	//ModbusMaster modbusMaster;	
//	ModbusMasterTCPConn modbusMasterTCPConn;
	TcpParameters tcpParameters;
	boolean frameStatus= false;
	Socket socket =new Socket();
	
//	TCPConnectionStatusChecker tCPConnectionStatusChecker;
//	public String getIpAddress() {
//		return ipAddress;
//	}
	

	/**
	 * Launch the application.
	 */
	public boolean ComConnectPanel() {
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IpaddressTest frame = new IpaddressTest();
//					frame.setVisible(true);
//					frameStatus=frame.isVisible();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		MainWindow.ipAddressTest.setVisible(true);
		frameStatus=MainWindow.ipAddressTest.isVisible();
		return frameStatus;
	}

	/**  
	 * Create the frame.
	 * @throws ParseException 
	 */
	public IpaddressTest() {
		setTitle("TCP Connection");
		setBounds(300, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###.###");
			formatter.setPlaceholderCharacter('0');
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  
	      final JFormattedTextField ipAddressText = new JFormattedTextField(formatter);
	      ipAddressText.setFocusLostBehavior(JFormattedTextField.PERSIST);
	      ipAddressText.setBounds(177, 49, 110, 20);
	      ipAddressText.setInputVerifier(new IPTextFieldVerifier());
	      ipAddressText.setText(MainWindow.ipAddress);
	      
	      JButton button = new JButton("Get value");
	      button.setBounds(331, 228, 79, 23);
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent ae) {
	        	 MainWindow.modbusMasterTCPConn.readHoldingRegisters(MainWindow.modbusMaster, 1, 0, 10);	

	         }
	      });
	      contentPane.setLayout(null);
	      contentPane.setLayout(null);
	      
	      JLabel lblIpAddress = new JLabel("IP Address :  ");
	      lblIpAddress.setBounds(89, 52, 65, 14);
	      contentPane.add(lblIpAddress);
	      getContentPane().add(ipAddressText);
	      getContentPane().add(button);
	  
	      ipAddressText.setPreferredSize(new Dimension(150, 20));
	      
	      JButton btnConnect = new JButton("Connect");
	      btnConnect.setBounds(89, 191, 110, 23);
	      contentPane.add(btnConnect);
	      
	      
	      portNumberText = new JTextField();
	      portNumberText.setBounds(177, 80, 110, 20);
	      contentPane.add(portNumberText);
	      portNumberText.setColumns(10);
	      
	      JLabel lblPortNumber = new JLabel("Port Number :");
	      lblPortNumber.setBounds(89, 83, 78, 14);
	      contentPane.add(lblPortNumber);
	      
	      JButton btnDisconnect = new JButton("Disconnect");
	      btnDisconnect.setBounds(225, 191, 110, 23);
	      contentPane.add(btnDisconnect);

	      
//	      JLabel lblTimeOut = new JLabel("Time Out :");
//	      lblTimeOut.setBounds(89, 114, 78, 14);
//	      contentPane.add(lblTimeOut);
	      
//    JFormattedTextField numberformattedTextField = new JFormattedTextField();
//	      numberformattedTextField.setBounds(177, 142, 110, 20);
//	      contentPane.add(numberformattedTextField);
//	      
//	      numberformattedTextField.setValue(MainWindow.modbusTCPConnectionTimeOut);
//	      PlainDocument doc = (PlainDocument) numberformattedTextField.getDocument();
//	      doc.setDocumentFilter(new MyIntFilter());

//	      JLabel lblMs = new JLabel("ms");
//	      lblMs.setBounds(1189, 114, 46, 14);
//	      contentPane.add(lblMs);

		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (MainWindow.isConnStatusThreadStarted()) {
					log.info(" Connection status thread started : "+MainWindow.isConnStatusThreadStarted());
				MainWindow.ipAddress = (ipAddressText.getText().toString());
				log.info("Modbus Master Connecting to : " + MainWindow.ipAddress);
				log.info("Modbus Master Object in IpAddressTest :" + MainWindow.modbusMaster);
				MainWindow.modbusMasterTCPConn = new ModbusMasterTCPConn();
				tcpParameters = MainWindow.modbusMasterTCPConn.getTcpParameters(MainWindow.ipAddress,
						portNumberText.getText());
				log.info("TCP paramerers passed to TCP connection : " + MainWindow.ipAddress + " , "
						+ portNumberText.getText());
				MainWindow.modbusMaster = MainWindow.modbusMasterTCPConn.tcpConnect(tcpParameters);
				log.info("Modbus Master Object in IpAddressTest :" + MainWindow.modbusMaster);

					
//					tCPConnectionStatusChecker = new TCPConnectionStatusChecker(MainWindow.modbusMasterTCPConn);
					MainWindow.tCPConnectionStatusChecker = new TCPConnectionStatusChecker(MainWindow.modbusMasterTCPConn);
					log.info("MOdbus TCP connection status checker object created : " + MainWindow.tCPConnectionStatusChecker);
					MainWindow.tCPConnectionStatusChecker.setRunning(true);
					log.info("connStatusThread termination status must be TRUE : " + MainWindow.tCPConnectionStatusChecker.isRunning());
					MainWindow.connStatusThread = MainWindow.tCPConnectionStatusChecker;
					
					if (!MainWindow.connStatusThread.isAlive()) {
						log.info("connStatusThread is in Alive :" + MainWindow.connStatusThread.isAlive());

						MainWindow.connStatusThread.setName("connStatusThread");
						log.info("Modbus Master connection status checker thread name set to : "
								+ MainWindow.connStatusThread.getName() + " And Thread ID is: " + MainWindow.connStatusThread.getId());
						MainWindow.connStatusThread.start();
						log.info("connStatusThread termination status must be TRUE : " + MainWindow.tCPConnectionStatusChecker.isRunning());
						log.info(MainWindow.connStatusThread.getName() + " is successfully started. And thread status is : "
								+ MainWindow.connStatusThread.getState());
						MainWindow.setConnStatusThreadStarted(false);
					}
				}
			}
		});
	      
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!MainWindow.isConnStatusThreadStarted()) {
				MainWindow.modbusMaster = MainWindow.modbusMasterTCPConn.tcpDisconnect(MainWindow.modbusMaster);
				log.info("Modbus Master DisConnected From : " + MainWindow.ipAddress);
				
				if (MainWindow.connStatusThread != null) {
					MainWindow.tCPConnectionStatusChecker.setRunning(false);
					log.info("Setting value FALSE to connStatusThread to terminate : " + MainWindow.tCPConnectionStatusChecker.isRunning());
					try {
						MainWindow.connStatusThread.join();
						log.info("connStatusThread is waiting to Die.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						log.error(e.getMessage());
					}
					log.info(MainWindow.connStatusThread.getName() + " is successfully sopped. And thread status is : " +MainWindow.connStatusThread.getState());
					MainWindow.setConnStatusThreadStarted(true);
//					connectBtnStaus=!MainWindow.modbusMasterTCPConn.socket.isConnected();
				}
			}
			}
		});
	}
	
	class MyIntFilter extends DocumentFilter {
		   @Override
		   public void insertString(FilterBypass fb, int offset, String string,
		         AttributeSet attr) throws BadLocationException {

		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.insert(offset, string);

		      if (test(sb.toString())) {
		         super.insertString(fb, offset, string, attr);
		      } else {
		         // warn the user and don't allow the insert
		      }
		   }

		   private boolean test(String text) {
		      try {
		         Integer.parseInt(text);
		         return true;
		      } catch (NumberFormatException e) {
		         return false;
		      }
		   }

		   @Override
		   public void replace(FilterBypass fb, int offset, int length, String text,
		         AttributeSet attrs) throws BadLocationException {

		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.replace(offset, offset + length, text);

		      if (test(sb.toString())) {
		         super.replace(fb, offset, length, text, attrs);
		      } else {
		         // warn the user and don't allow the insert
		      }

		   }

		   @Override
		   public void remove(FilterBypass fb, int offset, int length)
		         throws BadLocationException {
		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.delete(offset, offset + length);

//		      if (test(sb.toString())) {
//		         super.remove(fb, offset, length);
//		      } else {
//		         // warn the user and don't allow the insert
//		      }
		      if(sb.toString().length() == 0) {
		    	  super.replace(fb, offset, length, "", null);
		    	  } else {
		    	  if (test(sb.toString())) {
		    	  super.remove(fb, offset, length); 
		    	  } else { 
		    	  // warn the user and don't allow the insert }
		    	  }

		   }
		}
	}
	
	 class IPTextFieldVerifier extends InputVerifier {
		   public boolean verify(JComponent input) {
		      if (input instanceof JFormattedTextField) {
		         JFormattedTextField ftf = (JFormattedTextField)input;
		         AbstractFormatter formatter = ftf.getFormatter();
		         if (formatter != null) {
		            String text = ftf.getText();
		            StringTokenizer st = new StringTokenizer(text, ".");
		            while (st.hasMoreTokens()) {
		               int value = Integer.parseInt((String) st.nextToken());
		               if (value < 0 || value > 255) {
		                  // to prevent recursive calling of the
		                  // InputVerifier, set it to null and
		                  // restore it after the JOptionPane has
		                  // been clicked.
		                  input.setInputVerifier(null);
		                  JOptionPane.showMessageDialog(new Frame(), "Malformed IP Address!", "Error",
		                                                JOptionPane.ERROR_MESSAGE);
		                  input.setInputVerifier(this); 
		                  return false;
		               }
		            }
		            return true;
		         }
		      }
		      return true;
		   }

	}
}
