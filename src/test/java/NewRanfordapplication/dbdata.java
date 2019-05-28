package NewRanfordapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dbdata {
	@Test
	public void databasetest() throws SQLException
	{
		String host="localhost";
	Connection	con=DriverManager.getConnection("jdbc:mysql//"+ host +":"+ 3306 +"/testing", "root","root");
	java.sql.Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select * from ranfordlogin");
	while(rs.next()) {
	System.out.println(rs.getString("username"));
	System.out.println(rs.getString("password"));
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://srssprojects.in/cards.html");
		driver.findElement(By.xpath("//*[@id='txtuId']")).sendKeys(rs.getString("username"));
		driver.findElement(By.xpath("txtPword")).sendKeys(rs.getString("password"));
		driver.findElement(By.xpath("login")).click();
	}
}}
