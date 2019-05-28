package NewRanfordapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngparameterTest {
	@Parameters({"url","username","password"})
	@Test
	public void ymail(String url,String username,String password ){
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='signin']")).click();
		driver.findElement(By.xpath("//*[@id=login-passwd]")).sendKeys(password);
	}

}
