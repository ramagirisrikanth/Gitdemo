package NewRanfordapplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.Ranfordloginpage;
import Pageobjects.Ranfordrolespage;
import Resources.Baseclass;

public class Rolescreation extends Baseclass {
	
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFCell cell;
	@BeforeTest
	public void rolescreation() throws IOException, InterruptedException {
		driver = inetialization();
		driver.get("http://srssprojects.in/cards.html");
		System.out.println(driver.getTitle());

		Ranfordloginpage login = new Ranfordloginpage(driver);
		login.homebutton().click();
		login.username().sendKeys("Admin");
		login.password().sendKeys("Admin");
		login.login().click();

		
		
		
	}
		
		@Test
         public void getdata() throws IOException
		{
			Ranfordrolespage roles = new Ranfordrolespage(driver);
			roles.rolesbutton().click();
			roles.newrolesbutton().click();
			//System.out.println(roles.rolestextpage().getText());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	FileInputStream fis = new FileInputStream("E:\\Testdata.xlsx");
		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			roles.rolesname().sendKeys(cell.getStringCellValue());
			System.out.println(cell.getStringCellValue());
			// for roles description data
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(CellType.STRING);
			roles.roledesc().sendKeys(cell.getStringCellValue());
			System.out.println(cell.getStringCellValue());
			Select roletype = new Select(roles.roletype());
			roletype.selectByVisibleText("E");
			roles.submit().click();
			System.out.println(driver.switchTo().alert().getText());
			
			driver.switchTo().alert().accept();	
			//write the data in this excell
			FileOutputStream fileout=new FileOutputStream("E:\\Testdata.xlsx");
			//create a string 
			String messge="this role created sucessfully";
			sheet.getRow(i).createCell(3).setCellValue(messge);
			FileOutputStream fileoutput=new FileOutputStream("E:\\Testdata.xlsx");
			
		}
		}
		}
