package NewRanfordapplication;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Resources.Baseclass;

	public class homepagelinks extends Baseclass {
	WebDriver driver;
	@Test
	public void homepagelinkss() throws IOException {
	driver=inetialization();
	driver.get("http://srssprojects.in/cards.html");
	List<WebElement>	links=driver.findElements(By.tagName("a"));
	for(int i=0;i<links.size();i++) {
		//System.out.println(links.get(i).getText());
		WebElement ele=links.get(i);
	String 	url=ele.getAttribute("href");
	verifylinkActive(url);
	
		
	}
}
	public void verifylinkActive(String linkurl) throws IOException {
		// TODO Auto-generated method stub
		try {
		URL url=new URL(linkurl);
		HttpURLConnection httpconnection=(HttpURLConnection)url.openConnection();
		httpconnection.setConnectTimeout(3000);
		httpconnection.connect();
		if(httpconnection.getResponseCode()==200)
		{
			System.out.println(linkurl+"-"+httpconnection.getResponseCode());
		}
		if(httpconnection.getResponseCode()==404) {
			System.out.println(linkurl+"-"+httpconnection.getResponseMessage());
		}
		if(httpconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(linkurl+"_"+httpconnection.getResponseCode()+"_"+HttpURLConnection.HTTP_NOT_FOUND);
		}
		}
		catch(Exception e) {
			
		}
	}
	
	


}
