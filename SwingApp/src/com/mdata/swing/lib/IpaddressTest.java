package com.mdata.swing.lib;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.text.MaskFormatter;

import org.eclipse.jface.dialogs.PopupDialog;

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

import javax.swing.JLabel;
import java.awt.Dimension;

public class IpaddressTest extends JFrame {

	private JPanel contentPane;
	//private String ipAddress;
	private JTextField portNumberText;
	//ModbusMaster modbusMaster;	
//	ModbusMasterTCPConn modbusMasterTCPConn;
	TcpParameters tcpParameters;
	boolean frameStatus= false;

//	public String getIpAddress() {
//		return ipAddress;
//	}
	

	/**
	 * Launch the application.
	 */
	public boolean ComConnectPanel() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IpaddressTest frame = new IpaddressTest();
					frame.setVisible(true);
					frameStatus=frame.isVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frameStatus;
	}

	/**  
	 * Create the frame.
	 * @throws ParseException 
	 */
	public IpaddressTest() throws ParseException {
		setBounds(300, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		MaskFormatter formatter = new MaskFormatter("###.###.###.###");
	      formatter.setPlaceholderCharacter('0');
	  
	      final JFormattedTextField ipAddressText = new JFormattedTextField(formatter);
	      ipAddressText.setFocusLostBehavior(JFormattedTextField.PERSIST);
	      ipAddressText.setBounds(98, 11, 110, 20);
	      ipAddressText.setInputVerifier(new IPTextFieldVerifier());
	      ipAddressText.setText(MainWindow.ipAddress);
	      
	      final JTextField normalTf = new JTextField(25);
	      normalTf.setBounds(107, 183, 206, 20);
	      JButton button = new JButton("Get value");
	      button.setBounds(323, 182, 79, 23);
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent ae) {
	        	 MainWindow.modbusMasterTCPConn.readHoldingRegisters(MainWindow.modbusMaster, 1, 0, 10);	

	         }
	      });
	      contentPane.setLayout(null);
	      contentPane.setLayout(null);
	      
	      JLabel lblIpAddress = new JLabel("IP Address :  ");
	      lblIpAddress.setBounds(10, 14, 65, 14);
	      contentPane.add(lblIpAddress);
	      getContentPane().add(ipAddressText);
	      getContentPane().add(button);
	      getContentPane().add(normalTf);
	  
	      ipAddressText.setPreferredSize(new Dimension(150, 20));
	      
	      JButton btnConnect = new JButton("Connect");
	      btnConnect.setBounds(98, 73, 110, 23);
	      contentPane.add(btnConnect);
	      
	      portNumberText = new JTextField();
	      portNumberText.setBounds(98, 42, 110, 20);
	      contentPane.add(portNumberText);
	      portNumberText.setColumns(10);
	      
	      JLabel lblPortNumber = new JLabel("Port Number :");
	      lblPortNumber.setBounds(10, 45, 78, 14);
	      contentPane.add(lblPortNumber);
	      
	      JButton btnDisconnect = new JButton("Disconnect");
	      btnDisconnect.setBounds(98, 107, 110, 23);
	      contentPane.add(btnDisconnect);
	      
	      btnConnect.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent ae) {
		        	 MainWindow.ipAddress =(ipAddressText.getText().toString());
		        	 System.out.println("Connecting to :" +MainWindow.ipAddress);
		        	 log.info("Modbus Master Object in IpAddressTest :" +MainWindow.modbusMaster);
		        	 MainWindow.modbusMasterTCPConn =new ModbusMasterTCPConn();
		        	 tcpParameters= MainWindow.modbusMasterTCPConn.getTcpParameters(MainWindow.ipAddress, portNumberText.getText());
		        	 MainWindow.modbusMaster=MainWindow.modbusMasterTCPConn.tcpConnect(tcpParameters);
		        	 log.info("Modbus Master Object in IpAddressTest :" +MainWindow.modbusMaster);
		        	 System.out.println("Connected to :" +MainWindow.ipAddress);
		         }
		      });
	      
	      btnDisconnect.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent ae) {
		        	 MainWindow.modbusMaster =MainWindow.modbusMasterTCPConn.tcpDisconnect(MainWindow.modbusMaster);
		        	 System.out.println("DisConnected From :" +MainWindow.ipAddress);
		        	
		         }
		      });
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
