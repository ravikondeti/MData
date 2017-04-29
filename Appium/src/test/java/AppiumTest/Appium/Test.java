package AppiumTest.Appium;

import java.io.File;

import javax.print.DocFlavor.URL;


public class Test {
	
	public static void main(String[] args){

		File fil = new File("log4j.xml");
		System.out.println(fil);
		System.out.println(fil.getAbsolutePath());
	}

}
