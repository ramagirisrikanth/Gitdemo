package NewRanfordapplication;

import java.io.FileInputStream;
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
import Pageobjects.Ranforedhomepage;
import Resources.Baseclass;

public class Ranfordhomepage extends Baseclass {

	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFCell cell;

	@BeforeTest
	public void homepage() throws IOException {
		driver = inetialization();
		driver.get("http://srssprojects.in/cards.html");
		System.out.println(driver.getTitle());
		// we can get the other class method by inheritance and
		// also by creating the object for the required class as below
		// here we are passing the driver as argumet because this driver has life
		// so in ranfordlogin page there is no life for driver so we are passing this
		// driver as life to that driver as argument

		Ranfordloginpage login = new Ranfordloginpage(driver);
		login.homebutton().click();
		login.username().sendKeys("Admin");
		login.password().sendKeys("Admin");
		login.login().click();
		System.out.println(driver.getTitle());
	}

	@Test

	public void branchcreation() throws IOException {

		Ranforedhomepage home = new Ranforedhomepage(driver);
		home.branchcreation().click();
		home.newbranchbutton().click();
		String title = home.newbranchtext().getText();
		FileInputStream file = new FileInputStream("E:\\Testdata.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(1);
		if (title.equals("New Branch Entry")) {
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				cell = sheet.getRow(i).getCell(0);
				cell.setCellType(CellType.STRING);
				home.branchname().sendKeys(cell.getStringCellValue());

				cell = sheet.getRow(i).getCell(1);
				cell.setCellType(CellType.STRING);
				home.adress1().sendKeys(cell.getStringCellValue());

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				cell = sheet.getRow(i).getCell(2);
				cell.setCellType(CellType.STRING);
				home.adress2().sendKeys(cell.getStringCellValue());

				cell = sheet.getRow(i).getCell(3);
				cell.setCellType(CellType.STRING);
				home.adress3().sendKeys(cell.getStringCellValue());

				cell = sheet.getRow(i).getCell(4);
				cell.setCellType(CellType.STRING);
				home.area().sendKeys(cell.getStringCellValue());

				cell = sheet.getRow(i).getCell(5);
				cell.setCellType(CellType.STRING);

				home.zipcode().sendKeys(cell.getStringCellValue());

				// unsupportedoperationexception will be dislplayed for below lines
				cell = sheet.getRow(i).getCell(6);
				cell.setCellType(CellType.STRING);
				Select county = new Select(home.country());
				county.selectByVisibleText(cell.getStringCellValue());

				cell = sheet.getRow(i).getCell(7);
				cell.setCellType(CellType.STRING);
				Select state = new Select(home.state());
				state.selectByVisibleText(cell.getStringCellValue());

				cell = sheet.getRow(i).getCell(8);
				cell.setCellType(CellType.STRING);
				Select city = new Select(home.city());
				city.selectByVisibleText(cell.getStringCellValue());

				home.submit().click();
				

				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				home.newbranchbutton().click();

			} 
			
		
		}
		else 
		{
			System.out.println("Branch creation page is not correct");
		}
	}

}
