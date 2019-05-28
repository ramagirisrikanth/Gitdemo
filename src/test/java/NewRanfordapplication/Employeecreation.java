package NewRanfordapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Ranfordloginpage;
import Resources.Baseclass;
import Resources.Xls_Reader;
import Resources.dataproviderutility;

public class Employeecreation extends Baseclass {
	@BeforeTest
	public void empcreation() throws IOException, InterruptedException {
		driver = inetialization();
		driver.get("http://srssprojects.in/cards.html");
		System.out.println(driver.getTitle());

		Ranfordloginpage login = new Ranfordloginpage(driver);
		login.homebutton().click();
		login.username().sendKeys("Admin");
		login.password().sendKeys("Admin");
		login.login().click();

	}

//	@Test
	//public void employeecreation() {
		//Xls_Reader reader = new Xls_Reader("E:\\Testdata.xlsx");
		//code for creating the sheet
	//reader.addColumn("Employeedetails", "Result");
	/*if(!reader.isSheetExist("mysheeet")){
		reader.addSheet("mysheet");
		
	}*/
	//code for getting the columnnumbers
	//int colcount=reader.getColumnCount("Employeedetails");
	//System.out.println(colcount);
	
		/*
		 * String Branchname = reader.getCellData("Employeedetails", "EmployeeName", 2);
		 * System.out.println(Branchname);
		 * 
		 * String loginpassword = reader.getCellData("Employeedetails", "Loginpa ssword",
		 * 2); System.out.println(loginpassword); String role=
		 * reader.getCellData("Employeedetails", "Role", 2); System.out.println(role);
		 * String branch=reader.getCellData("Employeedetails", "Branch", 2);
		 * 
		 * 
		 * driver.findElement(By.xpath(
		 * "//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		 * driver.findElement(By.xpath("//*[@id='BtnNew']")).click();
		 * driver.findElement(By.xpath("//*[@id='txtUname']")).sendKeys(Branchname);
		 * driver.findElement(By.xpath("//*[@id='txtLpwd']")).sendKeys(loginpassword);
		 * Select roles=new
		 * Select(driver.findElement(By.xpath("//*[@id='lst_Roles']")));
		 * roles.selectByVisibleText(role); Select bra=new
		 * Select(driver.findElement(By.xpath("//*[@id='lst_Branch']")));
		 * bra.selectByVisibleText(branch);
		 * //driver.findElement(By.xpath("//*[@id=lst_Branch]"));
		 * driver.findElement(By.xpath("//*[@id='Table2']/tbody/tr/td[1]")).click();
		 * System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().accept();
		 */
		/*int rowcount = reader.getRowCount("Employeedetails");
		System.out.println(rowcount);
		driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		driver.findElement(By.xpath("//*[@id='BtnNew']")).click();
		for (int row = 2; row <= rowcount; row++) {

			String empname = reader.getCellData("Employeedetails", "EmployeeName", row);
			String brnch = reader.getCellData("Employeedetails", "Loginpassword", row);
			String roless = reader.getCellData("Employeedetails", "Role", row);
			String branches = reader.getCellData("Employeedetails", "Branch", row);
			
		
			
			driver.findElement(By.xpath("//*[@id='txtUname']")).sendKeys(empname);
			driver.findElement(By.xpath("//*[@id='txtLpwd']")).sendKeys(brnch);
			Select rolesa = new Select(driver.findElement(By.xpath("//*[@id='lst_Roles']")));
			rolesa.selectByVisibleText(roless);
			Select braa = new Select(driver.findElement(By.xpath("//*[@id='lst_Branch']")));
			braa.selectByVisibleText(branches);
			driver.findElement(By.xpath("//*[@id='Table2']/tbody/tr/td[1]")).click();
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			reader.setCellData("Employeedetails", "Result", row, "passed");
			driver.findElement(By.xpath("//*[@id='BtnNew']")).click();*/
//}

	@Test(dataProvider="getdata")
	public void excelldata(String employeename,String loginpassword,String role,String branches) {
		driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		driver.findElement(By.xpath("//*[@id='BtnNew']")).click();

		driver.findElement(By.xpath("//*[@id='txtUname']")).sendKeys(employeename);
		driver.findElement(By.xpath("//*[@id='txtLpwd']")).sendKeys(loginpassword);
		Select rolesa = new Select(driver.findElement(By.xpath("//*[@id='lst_Roles']")));
		rolesa.selectByVisibleText(role);
		Select braa = new Select(driver.findElement(By.xpath("//*[@id='lst_Branch']")));
		braa.selectByVisibleText(branches);
		driver.findElement(By.xpath("//*[@id='Table2']/tbody/tr/td[1]")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='BtnNew']")).click();
	}
@DataProvider
//below class is calling the utility functions and getting the data from the excell
public Iterator<Object[]> getdata() {
	ArrayList<Object[]> data1=dataproviderutility.getdatafromexcell();
			return data1.iterator();
	 
		

}
}  
