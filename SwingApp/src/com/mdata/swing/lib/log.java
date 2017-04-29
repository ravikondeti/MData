package com.mdata.swing.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

// TODO: Auto-generated Javadoc
/**
 * The Class log.
 *
 * @author Ravi kondeti
 */
public class log {
	
	
	
	/** The log. */
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	static {
		
		File file = new File("log4j.xml");		
		DOMConfigurator.configure(file.getAbsolutePath());
		BasicConfigurator.configure();
	}

	/**
	 * Start test case.
	 *
	 * @param testCaseName the test case name
	 */
	public static void startTestCase(String testCaseName) {
		log.info("************************************************************************************************");
		log.info("************************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$             START " +testCaseName + "          $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("************************************************************************************************");
		log.info("************************************************************************************************");

	}
	
	/**
	 * End test case.
	 *
	 * @param testCaseName the test case name
	 */
	public static void endTestCase(String testCaseName) {

		log.info("XXXXXXXXXXXXXXXXXXXXXXXXX   END  " +testCaseName + "          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		log.info("X");
		log.info("X");
		log.info("X");
		log.info("X");

	}
	
	/**
	 * Info.
	 *
	 * @param message the message
	 */
	public static void info(String message){
		log.info(message);
	}
	
	/**
	 * Warn.
	 *
	 * @param message the message
	 */
	public static void warn(String message){
		log.warn(message);
	}
	
	/**
	 * Error.
	 *
	 * @param message the message
	 */
	public static void error(String message){
		log.error(message);
	}
	
	/**
	 * Fatal.
	 *
	 * @param message the message
	 */
	public static void fatal(String message){
		log.fatal(message);
	}
	
	/**
	 * Debug.
	 *
	 * @param message the message
	 */
	public static void debug(String message){
		log.debug(message);
	}
	
	

}
