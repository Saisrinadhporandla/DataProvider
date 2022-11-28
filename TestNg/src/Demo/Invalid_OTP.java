package Demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invalid_OTP {
    @Test
	public void OTP()throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.amazon.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		Thread.sleep(1000);
		// valid Mobile Number
		dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("9704219395");
		Thread.sleep(1000);
		dr.findElement(By.cssSelector("input#continue")).click();
		// log in using Valid OTP
		dr.findElement(By.xpath("//input[@id='continue']")).click();
		dr.findElement(By.id("cvf-input-code")).sendKeys("831884");
		dr.findElement(By.className("a-button-input")).click();
		dr.close();
	}
}