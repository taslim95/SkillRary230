package genericLibraries;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains all reusable methods to perform on properties file
 * @author Abhishek
 *
 */
public class PropertiesUtilities 
{
	private Properties property;
	
	/**
	 * this method is used to  initialized properties file
	 * @param filepath
	 */
	
	public void propertiesInit(String filepath)
	{
		FileInputStream fis =null;
		try {
			fis =new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		property =new Properties();
		
		try {
			property.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * this method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
	
	public String readData(String key)
	{
		return property.getProperty(key);
	}
	
	/**
	 * this method is used to write and save data to properties file
	 * @param key
	 * @param value
	 * @param filepath
	 */
	
	public void writeToProperties(String key, String value, String filepath)
	{
		property.put(key, value);
		
		FileOutputStream fos =null;
		
		try {
			fos =new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			property.store(fos, "updated");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
