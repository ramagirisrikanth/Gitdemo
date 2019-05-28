package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Ranfordloginpage {

	public WebDriver driver;
	public Ranfordloginpage(WebDriver driver) {
		
		//here we are passing life to local driver using other driver
	 this.driver=driver;
		
	}
	

	By homebutton=By.xpath("//*[@id='Table_01']/tbody/tr/td[2]/a/img");
	By username=By.xpath("//*[@id='txtuId']");
	By password=By.xpath("//*[@id='txtPword']");
	//@FindBy(xpath="//*[@id='Table_01']/tbody/tr/td[2]/a/img")
	//WebElement button;
	
	By login=By.xpath("//*[@id='login']");
	
	public WebElement homebutton() {
	return driver.findElement(homebutton);
	}
//	public WebElement buttton() {
	//	return button;
	//}
	public WebElement username() {
	return driver.findElement(username);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement login() {
		return driver.findElement(login);
	}
	
}
