package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ranfordrolespage {

WebDriver driver;
public Ranfordrolespage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
WebElement rolesbutton;

@FindBy(id="btnRoles")
WebElement newrolesbutton ;

//@FindBy(xpath="//td//span[contains(text(),'New Role Insertion')]")
//WebElement rolespagetext;

@FindBy(id="txtRname")
WebElement rolesname;

@FindBy(id="txtRDesc")
WebElement roledesc;

@FindBy(id="lstRtypeN")
WebElement roletype;

@FindBy(id="btninsert")
WebElement submit;
public WebElement submit() {
	return submit;
}
public WebElement rolesbutton() {
	return rolesbutton;
}
public WebElement newrolesbutton() {
	return newrolesbutton;
}

public WebElement rolesname() {
	return rolesname;
}
public WebElement roledesc() {
	return roledesc;
}
public WebElement roletype() {
	return roletype;
}
}

