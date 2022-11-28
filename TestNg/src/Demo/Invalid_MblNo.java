package Demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Invalid_MblNo {
     @Test
	public void invalidMbl() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.amazon.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		//Invalid Mobile Number
		dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("87656888");
		dr.findElement(By.cssSelector("input#continue")).click();
		System.out.println(dr.findElement(By.xpath("//span[@class='a-list-item']")).getText());
		Assert.assertEquals(dr.findElement(By.xpath("//span[@class='a-list-item']")).getText(),"We cannot find an account with that mobile number");
		dr.close();
	}
}
