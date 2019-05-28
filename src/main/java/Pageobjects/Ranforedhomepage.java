package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ranforedhomepage {

	public WebDriver driver;
	public Ranforedhomepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	//home button
	@FindBy(xpath="//table[@id='Table_02']//tbody//tr//td[1]//a//img[@height='25']")
	 WebElement homehomebutton;
	//branches button
	@FindBy(xpath="//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
	WebElement branches;
	//new branches
	@FindBy(xpath="//*[@id='BtnNewBR']")
	WebElement newbranches;
	//branch page text
	@FindBy(xpath="//*[@id='Labmain']")
	WebElement newbranchtext;
	
	@FindBy(xpath="//input[@id='txtbName']")
	WebElement branchname;
	
	@FindBy(xpath="//input[@id='txtAdd1']")
	WebElement adress1;
	
	@FindBy(xpath="//input[@id='Txtadd2']")
	WebElement adress2;
	@FindBy(id="txtadd3")
	WebElement adress3;
	@FindBy(id="txtArea")
	WebElement area;
	@FindBy(id="txtZip")
	WebElement zipcode;
	@FindBy(xpath="//select[@id='lst_counrtyU']")
	WebElement country;
	@FindBy(xpath="//select[@id='lst_stateI']")
	WebElement state;
	@FindBy(xpath="//select[@id='lst_cityI']")
	WebElement city;
	@FindBy(id="btn_insert")
	WebElement submit;
	@FindBy(xpath="//*[@id='DG_bankdetails']/tbody/tr[2]/td[7]/a/img")
	WebElement editbranch;
	@FindBy(id="btnupdate")
	WebElement update;
	public WebElement editbranch() {
		return editbranch;
	}
	public WebElement hmehomebutton() {
		return homehomebutton;
	}
	public WebElement branchcreation() {
		return branches;
	}
	public WebElement newbranchbutton() {
		return newbranches;
	}
	public WebElement newbranchtext() {
		return newbranchtext;
	}
	public WebElement branchname() {
		return branchname;
	}
	public WebElement adress1(){
		return adress1;
	}
	public WebElement adress2() {
		return adress2;
	}
	public WebElement adress3() {
		return adress3;
	}
	public WebElement  area() {
		return  area;
	}
	public WebElement zipcode() {
		return zipcode;
	}
	public WebElement country() {
		return country;
	}
	public WebElement state() {
		return state;
	}
	public WebElement city() {
		return city;
	}
	public WebElement submit() {
		return submit;
	}
	public WebElement update() {
		return update;
	}
}
