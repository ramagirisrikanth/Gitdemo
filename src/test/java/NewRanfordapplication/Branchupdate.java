package NewRanfordapplication;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pageobjects.Ranfordloginpage;
import Pageobjects.Ranforedhomepage;
import Resources.Baseclass;

public class Branchupdate extends Baseclass{
	WebDriver driver;
	@Test
public void branchupdate() throws IOException, InterruptedException {
	driver=inetialization();
	driver.get("http://srssprojects.in/cards.html");
	//login into the app
	Ranfordloginpage login=new Ranfordloginpage(driver);
	login.homebutton().click();
	login.username().sendKeys("Admin");
	login.password().sendKeys("Admin");
	login.login().click();
	System.out.println(driver.getTitle());
	
	
	Ranforedhomepage home = new Ranforedhomepage(driver);
	home.branchcreation().click();
List<WebElement> rows =driver.findElements(By.xpath("//*[@id='DG_bankdetails']/tbody/tr"));
System.out.println("The row size of table is :"+rows.size());
List<WebElement> columns=driver.findElements(By.xpath("//*[@id='DG_bankdetails']/tbody/tr[1]/td"));
System.out.println("The column size of table is :"+columns.size());
////*[@id="DG_bankdetails"]/tbody/tr[4]/td[1]



	//*[@id="DG_bankdetails"]/tbody/tr[7]/td/a[7]
	String beforexpath="//*[@id=\"DG_bankdetails\"]/tbody/tr[7]/td/a[";
	String afterxpath="]";
	for(int i=2;i<10;i++) {
		driver.findElement(By.xpath(beforexpath+i+afterxpath)).click();
		Thread.sleep(2000);
		
		String Before_xpath = "//*[@id='DG_bankdetails']/tbody/tr[";
		String After_xpath="]/td[1]";
		for(int row=2;row<=6;row++)
		{
		String branchid=driver.findElement(By.xpath(Before_xpath+row+After_xpath)).getText();
		System.out.println(branchid);
		if(branchid.contains("204")) {
			driver.findElement(By.xpath("//*[@id='DG_bankdetails']/tbody/tr["+row+"]/td[7]/a/img")).click();
			break;
		}
	
	}
}
	Ranforedhomepage branchupdate=new Ranforedhomepage(driver);
	branchupdate.adress2().sendKeys("srikanth143333");
	branchupdate.update().click();
	
}
}
	
