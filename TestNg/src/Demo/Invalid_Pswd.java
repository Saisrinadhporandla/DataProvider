package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Invalid_Pswd {
    @Test
	public void InvalidPswd() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.amazon.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		Thread.sleep(1000);
		//valid mail Id
		dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("porandlasaisrinadh@gmail.com");
		Thread.sleep(1000);
		dr.findElement(By.cssSelector("input#continue")).click();
		//invalid password
		dr.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("sai123");
		dr.findElement(By.className("a-button-input")).click();
		Thread.sleep(1000);
		System.out.println(dr.findElement(By.xpath("//span[@class='a-list-item']")).getText());
		Assert.assertEquals(dr.findElement(By.xpath("//span[@class='a-list-item']")).getText(), "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.");
		dr.close();
	}
}
