package Demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Valid_Credentials {
    @Test
	public void Valid() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.amazon.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		//WebDriverWait obj=new WebDriverWait(dr,Duration.ofSeconds(2000));
		//Thread.sleep(1000);
		//valid Mobile Number
		
		//obj.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
		dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("9704219395");
		dr.findElement(By.cssSelector("input#continue")).click();
		// Valid Password
		dr.findElement(By.id("ap_password")).sendKeys("Srin@dh2448");
		dr.findElement(By.id("signInSubmit")).click();
		dr.close();
	}

}
