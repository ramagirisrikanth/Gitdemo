package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Baseclass {
	public WebDriver driver;
	public WebDriver inetialization() throws IOException {
		
		Properties prop=new Properties();
		//if you dont give correct file path  exception will be thrown 
		FileInputStream fis =new FileInputStream("E:\\mywork data\\NewBankingapplication\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
String browsername=prop.getProperty("Browser");
if(browsername.equals("chrome")){
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
driver=new ChromeDriver();
}
//here we need to use equals method instead of == for browserr name 
else if(browsername.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
driver=new FirefoxDriver();
	
}
else if(browsername.equals("IE")){
	System.setProperty("webdriver.IE.driver", "C:\\Program Files\\IEDriverServer.exe");
driver=new InternetExplorerDriver();
}
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

return driver;
 
	}

}
