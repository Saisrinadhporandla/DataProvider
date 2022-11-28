package Demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Blank_Pswd {
	@Parameters({"URL"})
    @Test
	public void blankPswd() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.amazon.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		Thread.sleep(1000);
		//valid mail Id
		dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("porandlasaisrinadh@gmail.com");
		Thread.sleep(1000);
		dr.findElement(By.cssSelector("input#continue")).click();
		Thread.sleep(1000);
		//blank password
		dr.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("");
		dr.findElement(By.className("a-button-input")).click();
		//Thread.sleep(1000);
		dr.close();

	}
}
