package tests;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class LoginTest {
	
	public ExcelReader excelreader;
	public WebDriver driver;
	public Logger logger;
	
	
	@Test
	public void loginTest() {
		logger =  LogManager.getLogger(this.getClass());
		excelreader = new ExcelReader();
		excelreader.readExcel("login");
		logger.info("-----Logged into orange hrm and searched the user-----");
		 
	}

}
