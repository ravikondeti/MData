package genericlib;

import java.io.File;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.testng.Assert;

import net.sourceforge.lept4j.Pix;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCR {
	
	
	/**
	 * Gets the text from image.
	 *
	 * @param filePath the file path
	 * @param tessDataPath the tess data path
	 * @return the text from image
	 */
	public static String getTextFromImage(String filePath, String tessDataPath) {
		String result ="";
		
        File imageFile = new File(filePath);
        log.info("Image Location :" +filePath);
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        // File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build bundles English data
        // instance.setDatapath(tessDataFolder.getParent());
        instance.setDatapath(tessDataPath);
        log.info("TessData Location :" +tessDataPath);
        try {
             result = instance.doOCR(imageFile);
            log.info("Image file Output : "+result);
        } catch (TesseractException e) {
            log.error(e.getMessage());
        }
        	return result;
		
       
    }   
	
	/**
	 * Gets the text from image.
	 *
	 * @param filePath the file path
	 * @param tessDataPath the tess data path
	 * @param textToGet the text to get from screen shot
	 * @return the text from image
	 */
	public static String getTextFromImage(String[] filePath, String tessDataPath, String textToGet) {
		String ocrResult = "";

		for (int i = 0; i <filePath.length; i++) {
			
			File imageFile = new File(filePath[i].toString());
			log.info("Image Location :" + imageFile);
			ITesseract instance = new Tesseract(); // JNA Interface Mapping
			// ITesseract instance = new Tesseract1(); // JNA Direct Mapping
			// File tessDataFolder = LoadLibs.extractTessResources("tessdata");
			// // Maven build bundles English data
			// instance.setDatapath(tessDataFolder.getParent());
			instance.setDatapath(tessDataPath);
			log.info("TessData Location :" + tessDataPath);
			try {
				ocrResult = instance.doOCR(imageFile);
				log.info("Image file Output : " + ocrResult);
			} catch (TesseractException e) {
				log.error(e.getMessage());
			}

			if (ocrResult.contains(textToGet)) {

				break;
			}
		}

		return ocrResult;

	}

}
