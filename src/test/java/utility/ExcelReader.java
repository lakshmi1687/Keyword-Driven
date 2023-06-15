package utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.Base;

public class ExcelReader {
	public WebDriver driver;
	public Properties prop;
	
	public static Workbook book;
	public static Sheet sheet;
	
	public Base base;
	
	WebElement element;
	
	public final String SHEET_PATH = ".//testdata//TestData.xlsx";
	
	public void readExcel(String sheetName) {
		FileInputStream file = null;
		
		try {
			 file = new FileInputStream(SHEET_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		int k =0;
		
		for(int i =0; i<sheet.getLastRowNum();i++) {
			try {
			String locatorType=sheet.getRow(i+1).getCell(k+2).toString().trim(); // first row is having headers and first cell is having test steps
			String locatorValue=sheet.getRow(i+1).getCell(k+3).toString().trim();
			String action  = sheet.getRow(i+1).getCell(k+1).toString().trim(); 
			String value = sheet.getRow(i+1).getCell(k+4).toString().trim();
			
			switch (action) {
			case "open browser":
				base = new Base();
				prop = base.init_properties();
				  if(value == "NA" || value == "") {
				     driver = base.init_driver(prop.getProperty("browser"));
				   } else {
					driver = base.init_driver(value);
				}
				  driver.manage().window().maximize();
				  Thread.sleep(2000);
				break;
			case "Navigate to Url" :
				  driver.get(value);
				  Thread.sleep(2000);
				  break;
			case "quit" :
				Thread.sleep(2000);
				driver.close();
			
			}
			
				
			
			switch (locatorType) {
			case "name" :
				  element = driver.findElement(By.name(locatorValue));
				   if(action.equalsIgnoreCase("sendkeys")) {
					   element.sendKeys(value);
					   Thread.sleep(2000);
				   } else if(action.equalsIgnoreCase("click")) {
					   element.click();
					   Thread.sleep(2000);
				   }
				   
				   break;
			case "xpath" :
				  element = driver.findElement(By.xpath(locatorValue));
				   if(action.equalsIgnoreCase("click")) {
					   element.click();
					   Thread.sleep(2000);
				   } else if(action.equalsIgnoreCase("sendkeys")) {
					   element.sendKeys(value);
					   Thread.sleep(2000);
				   } else if (action.equalsIgnoreCase("getText")) {
					   String firstUser = element.getText();
					   System.out.println(firstUser);
				   }
				   
				   break;
			case "className" :
				  element = driver.findElement(By.className(locatorValue));
				   if(action.equalsIgnoreCase("click")) {
					   element.click();
					   Thread.sleep(2000);
				   } else if(action.equalsIgnoreCase("sendkeys")) {
					   element.sendKeys(value);
					   Thread.sleep(2000);
				   } else if (action.equalsIgnoreCase("getText")) {
					   element.getText();
				   }
				   
				   break;
			case "linkText" :
				  element = driver.findElement(By.linkText(locatorValue));
				   if(action.equalsIgnoreCase("click")) {
					   element.click();
					   Thread.sleep(2000);
				   } else if(action.equalsIgnoreCase("sendkeys")) {
					   element.sendKeys(value);
					   Thread.sleep(2000);
				   } else if (action.equalsIgnoreCase("getText")) {
					   element.getText();
				   }
				   
				   break;
			case "id" :
				  element = driver.findElement(By.id(locatorValue));
				   if(action.equalsIgnoreCase("click")) {
					   element.click();
					   Thread.sleep(2000);
				   } else if(action.equalsIgnoreCase("sendkeys")) {
					   element.sendKeys(value);
					   Thread.sleep(2000);
				   } else if (action.equalsIgnoreCase("getText")) {
					   element.getText();
				   }
				   
				   break;	 

			default:
				break;
			}
			
		}
		 catch(Exception e) {
			 e.printStackTrace();
		}
			
    }
}
}

