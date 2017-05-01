package com.mdata.swing.main;

import java.net.Socket;

import com.invertor.examples.modbus.ModbusMasterTCPConn;
import com.mdata.swing.lib.log;

public class TCPConnectionStatusChecker extends Thread {
	ModbusMasterTCPConn modbusMasterTCPConn;
	public boolean connectedStatus;
	public boolean bindingStatus;
	public boolean closedStatus;
	private volatile boolean running = true;
	
	public TCPConnectionStatusChecker(ModbusMasterTCPConn modbusMasterTCPConn){
		this.modbusMasterTCPConn =modbusMasterTCPConn;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		
		while(running){
			connectedStatus =modbusMasterTCPConn.socket.isConnected();
			bindingStatus=modbusMasterTCPConn.socket.isBound();
			closedStatus =modbusMasterTCPConn.socket.isClosed();
			log.info("Connected Status :" +connectedStatus +
					"  Binding Status :" +bindingStatus +"  Closed Status :"+closedStatus);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				running=false;
			}
			
		}
	}
	

}
