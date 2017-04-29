package com.mdata.swing.main;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.MaskFormatter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.util.StringTokenizer;
import com.mdata.swing.lib.IpAddressText;
import com.mdata.swing.lib.SizedText;

import org.eclipse.swt.widgets.Button;

public class NewConnection extends Shell {
	private Text text;
	private Text ipAddressText;
	private Text portNumberText;
	private String ipAddress;
	private String portNumber;
	protected Shell newConnectionShell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public void newConnectionShellAction() {
		try {
			Display display = Display.getDefault();
			NewConnection shell = new NewConnection(display);
			Rectangle screenSize = display.getPrimaryMonitor().getBounds();
			shell.setLocation((screenSize.width - shell.getBounds().width) / 2, (screenSize.height - shell.getBounds().height) / 2);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 * @throws ParseException 
	 */
	public NewConnection(Display display) throws ParseException {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}
	

	/**
	 * Create contents of the shell.
	 * @throws ParseException 
	 */
	protected void createContents() throws ParseException {
		newConnectionShell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
		newConnectionShell.setText("SWT Application");
		newConnectionShell.setSize(650, 400);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(93, 69, 75, 15);
		lblNewLabel.setText("IP Address :");
		
		ipAddressText = new Text(this, SWT.BORDER);
		ipAddressText.setBounds(194, 66, 111, 21);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBounds(93, 108, 75, 15);
		lblNewLabel_1.setText("Port Number :");
		
		portNumberText = new Text(this, SWT.BORDER);
		portNumberText.setBounds(194, 105, 111, 21);
		
		Button btnConnect = new Button(this, SWT.NONE);
		btnConnect.setBounds(149, 186, 75, 25);
		btnConnect.setText("Connect");
		
		Button btnDisconnect = new Button(this, SWT.NONE);
		btnDisconnect.setBounds(257, 186, 75, 25);
		btnDisconnect.setText("Disconnect");
		
		MaskFormatter formatter = new MaskFormatter("###.###.###.###");
	      formatter.setPlaceholderCharacter('0');
	  
	      final JFormattedTextField formattedTf = new JFormattedTextField(formatter);
	      formattedTf.setInputVerifier(new IPTextFieldVerifier());
	  
	      final JTextField normalTf = new JTextField(25);
	      JButton button = new JButton("Get value");
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent ae) {
	            normalTf.setText(""+formattedTf.getValue());
	         }
	      });
	  
	      formattedTf.setPreferredSize(normalTf.getPreferredSize());
		
//		IpAddressText ipAddressText = new IpAddressText(this.getShell(), SWT.COLOR_BLUE);
//		ipAddressText.setIpAddress(portNumberText.getText());
		
		btnConnect.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				ipAddress =ipAddressText.getText();
				portNumber =portNumberText.getText();
				
				if(ipAddress == null ||ipAddress.isEmpty() ||portNumber==null ||portNumber.isEmpty()){
					String errorMsg=null;
					MessageBox messageBox= new MessageBox(newConnectionShell,SWT.OK |SWT.ICON_ERROR);
					messageBox.setText("Alert");
					if(ipAddress == null ||ipAddress.isEmpty()){
						errorMsg="Please enter IPAddress";
					}else if(portNumber==null ||portNumber.isEmpty()){
						errorMsg ="Please enter Port Number";
					}
					if(errorMsg!=null){
						messageBox.setMessage(errorMsg);
						messageBox.open();
					}
				}
				
			}
		});
		
		
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
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
