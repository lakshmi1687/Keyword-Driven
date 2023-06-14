package tests;



import utility.ExcelReader;

public class LoginTest {
	
	public static ExcelReader excelreader;
	
	
	public static void main(String[] args) {
		excelreader = new ExcelReader();
		excelreader.readExcel("login");
		 
	}

}
