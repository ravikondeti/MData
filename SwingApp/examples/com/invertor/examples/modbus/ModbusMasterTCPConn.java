package com.invertor.examples.modbus;

import com.invertor.modbus.Modbus;
import com.invertor.modbus.ModbusMaster;
import com.invertor.modbus.ModbusMasterFactory;
import com.invertor.modbus.exception.ModbusIOException;
import com.invertor.modbus.exception.ModbusNumberException;
import com.invertor.modbus.exception.ModbusProtocolException;
import com.invertor.modbus.tcp.TcpParameters;
import com.mdata.swing.lib.log;
import com.mdata.swing.main.MainWindow;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ModbusMasterTCPConn {
	/*
	 * Tcp Connection 
	 */
	public ModbusMaster tcpConnect(TcpParameters tcpParameters) {
		ModbusMaster m = null;
		if (MainWindow.modbusMaster != null) {
			log.info("Modbus TCP connection initialization started with parameters : " +"Host :" +tcpParameters.getHost()
			+ " Port : " +tcpParameters.getPort());
			m = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
			log.info("");
			Modbus.setAutoIncrementTransactionId(true);
			try {
				m.connect();

			} catch (ModbusIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return m;
	}

	/*
	 * Modbus TCP disconnect
	 */
	public ModbusMaster tcpDisconnect(ModbusMaster modbusMaster){
		try {
			modbusMaster.disconnect();
		} catch (ModbusIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modbusMaster =null;
		
	}
	/*
	 * Getting Modbus TCP Paramerers
	 */
	public TcpParameters getTcpParameters(String ipAddress, String portNum){
		 TcpParameters tcpParameters = new TcpParameters();

         //tcp parameters have already set by default as in example
         if (ipAddress == null || ipAddress.isEmpty()){
         try {
			tcpParameters.setHost(InetAddress.getByName("localhost"));
			System.out.println("Host :" + InetAddress.getByName("localhost"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         }else {
         	try {
				tcpParameters.setHost(InetAddress.getByName(ipAddress));
				 System.out.println("New Host :" + InetAddress.getByName(ipAddress));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         	
         }
         tcpParameters.setKeepAlive(true);
         tcpParameters.setPort(Modbus.TCP_PORT);
         
		return tcpParameters;
		
	}
	public int[] readHoldingRegisters(ModbusMaster modbusMaster,int slaveId,int offset,int quantity){
		int[] registerValues = null;
		log.info(this.getClass() +"register values" +registerValues);
		try {
			registerValues =modbusMaster.readHoldingRegisters(slaveId, offset, quantity);
			log.info(this.getClass() +"register values" +registerValues);
			for (int value : registerValues) {
                System.out.println("Address: " + offset++ + ", Value: " + value);
			}
		} catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registerValues;
		
	}
    public void tcpConnection(String ipAddress, String portNum) {
        try {
            TcpParameters tcpParameters = new TcpParameters();

            //tcp parameters have already set by default as in example
            if (ipAddress == null){
            tcpParameters.setHost(InetAddress.getByName("localhost"));
            System.out.println("Host :" + InetAddress.getByName("localhost"));
            }else {
            	tcpParameters.setHost(InetAddress.getByName(ipAddress));
            	 System.out.println("New Host :" + InetAddress.getByName(ipAddress));
            }
            tcpParameters.setKeepAlive(true);
            tcpParameters.setPort(Modbus.TCP_PORT);

            //if you would like to set connection parameters separately,
            // you should use another method: createModbusMasterTCP(String host, int port, boolean keepAlive);
            ModbusMaster m = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
            Modbus.setAutoIncrementTransactionId(true);
            int slaveId = 1;
            int offset = 0;
            int quantity = 10;
            try {
                // at next string we receive ten registers from a slave with id of 1 at offset of 0.
                int[] registerValues = m.readHoldingRegisters(slaveId, offset, quantity);
                // let's print them all :)
                for (int value : registerValues) {
                    System.out.println("Address: " + offset++ + ", Value: " + value);
                }
            } catch (ModbusProtocolException e) {
                e.printStackTrace();
            } catch (ModbusNumberException e) {
                e.printStackTrace();
            } catch (ModbusIOException e) {
                e.printStackTrace();
            } finally {
                try {
                    m.disconnect();
                } catch (ModbusIOException e) {
                    e.printStackTrace();
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
