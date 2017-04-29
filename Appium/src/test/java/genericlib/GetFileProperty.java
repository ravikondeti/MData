package genericlib;

public class GetFileProperty {
	static String filePropertyPath = "FileLocationProperties/FileLocation.properties";

	public static String enButtonPropertyPath = Lib.getProperty(filePropertyPath,
			"enButtonPropertyPath");
	public static String homePagePropertyPath = Lib.getProperty(filePropertyPath,
			"homePagePropertyPath");
	public static String endActivityPropertyPath = Lib
			.getProperty(filePropertyPath, "endActivityPropertyPath");
	public static String tessDataPath = Lib.getProperty(filePropertyPath,
			"tessDataPath");
	public static String screenShotPath = Lib.getProperty(filePropertyPath,
			"screenShotPath");
	public static String registrationPagePropFilePath = Lib.getProperty(filePropertyPath, "registrationPagePropFilePath");
	public static String selectProgLanguage = Lib.getProperty(filePropertyPath, "selectProgLanguage");
	
	public static String verifyRegisterUserDeatils = Lib.getProperty(filePropertyPath, "verifyRegisterUserDeatils");
	public static String appcrashproperties=Lib.getProperty(filePropertyPath, "appcrashproperties");
	public static String lastGesture =Lib.getProperty(filePropertyPath, "lastGesture");

}
