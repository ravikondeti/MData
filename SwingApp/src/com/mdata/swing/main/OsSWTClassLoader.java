package com.mdata.swing.main;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import com.mdata.swing.lib.log;

public class OsSWTClassLoader {

	public static String getArchFilename(String prefix) 
	{ 
		log.info("Arch File Name : " + prefix + "_" + getOSName() + "_" + getArchName() + ".jar");
	   return prefix + "_" + getOSName() + "_" + getArchName() + ".jar"; 
	   
	} 

	private static String getOSName() 
	{ 
	   String osNameProperty = System.getProperty("os.name"); 
	   log.info("OS Name :" +osNameProperty );
	   if (osNameProperty == null) 
	   { 
	       throw new RuntimeException("os.name property is not set"); 
	   } 
	   else 
	   { 
	       osNameProperty = osNameProperty.toLowerCase();
	       log.info("OS Name coverted to lower case :" +osNameProperty );
	   } 

	   if (osNameProperty.contains("win")) 
	   { 
	       return "win"; 
	   } 
	   else if (osNameProperty.contains("mac")) 
	   { 
	       return "osx"; 
	   } 
	   else if (osNameProperty.contains("linux") || osNameProperty.contains("nix")) 
	   { 
	       return "linux"; 
	   } 
	   else 
	   { 
	       throw new RuntimeException("Unknown OS name: " + osNameProperty); 
	   } 
	} 

	private static String getArchName() 
	{ 
	   String osArch = System.getProperty("os.arch"); 
	   log.info("Os version :" +osArch);

	   if (osArch != null && osArch.contains("64")) 
	   { 
	       return "64"; 
	   } 
	   else 
	   { 
	       return "32"; 
	   } 
	}
	
	public static void addJarToClasspath(File jarFile) 
	{ 
	   try 
	   { 
	       URL url = jarFile.toURI().toURL(); 
	       URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader(); 
	       Class<?> urlClass = URLClassLoader.class; 
	       Method method = urlClass.getDeclaredMethod("addURL", new Class<?>[] { URL.class }); 
	       method.setAccessible(true);         
	       method.invoke(urlClassLoader, new Object[] { url });             
	   } 
	   catch (Throwable t) 
	   { 
	       t.printStackTrace(); 
	   } 
	}
}
