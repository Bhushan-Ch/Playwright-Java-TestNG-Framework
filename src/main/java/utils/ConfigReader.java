package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	
	static {
		try
		{
			prop= new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/config.properties");
			prop.load(fis);
			
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load properties");
		
		}
	}
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}
}
