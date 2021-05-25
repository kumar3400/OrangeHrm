package HRM.Orange.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	
	
	public ReadConfig() {
	
		File src = new File("./ConfigurationFiles/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	 
	public String getApplicationURL()
	{
		String Conurl = pro.getProperty("BaseURL");
		return Conurl;
	}
	public String getCromePath()
	{
		String ConChromePath = pro.getProperty("chromepath");
		return ConChromePath;
	}
	public String getIEpath()
	{
		String ConIEpath = pro.getProperty("iepath");
		return ConIEpath;
	}
	
	public String getUsername() {
    	
    	String username =pro.getProperty("username");
    	
    	return username;
    }
    
    
    public String getPassword() {
    	
    	String password = pro.getProperty("password");
    	return password;
    }
	public String getBroswer() {
		
		String browserName = pro.getProperty("browser");
		return browserName;
	}
    
}
