package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browserName) {
		System.setProperty("WebDriver.chrome.driver", "/D:/drivers/chromedriver");
		driver = new ChromeDriver();	
		return driver;
		
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream file  = new FileInputStream(".//src//test//resources//object.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop;
	}

}
