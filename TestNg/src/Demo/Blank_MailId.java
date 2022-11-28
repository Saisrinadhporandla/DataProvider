package Demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Blank_MailId {
@Parameters({"URL"})
    @Test
	public void blankMail(String url) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		dr.get(url);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		//Thread.sleep(1000);
		//email field blank 
		dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("  ");
		//Thread.sleep(1000);
		dr.findElement(By.cssSelector("input#continue")).click();
		System.out.println(dr.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]")).getText());
		Assert.assertEquals(dr.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]")).getText(), "Enter your email or mobile phone number");
		dr.close();
	}
}
