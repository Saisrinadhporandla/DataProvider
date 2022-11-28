package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Amazon_Login {
	

	@Test(dataProvider="getData")

		public void Valid(String scen,String user,String pswd) throws InterruptedException {
			// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisrinadh.porandla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.amazon.com/");
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			dr.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			dr.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(user);
			dr.findElement(By.cssSelector("input#continue")).click();
			dr.findElement(By.id("ap_password")).sendKeys(pswd);
			dr.findElement(By.id("signInSubmit")).click();
			if(scen.equalsIgnoreCase("blank_Pswd"))
			{
				WebElement ac=dr.findElement(By.xpath("//div[contains(text(),'Enter your password')]"));
				System.err.println(ac.getText());
				Assert.assertTrue(ac.isDisplayed(), "Test fail At blankPswd");
			}
			if(scen.equalsIgnoreCase("invalid_Pswd"))
			{
				Assert.assertEquals(dr.findElement(By.className("a-alert-heading")).getText(), "There was a problem");

				WebElement ac=dr.findElement(By.xpath("//span[@class='a-list-item']"));
				System.err.println(ac.getText());
				Assert.assertTrue(ac.isDisplayed(), "Test failed");
			}
			
            System.out.println("sai");
			dr.quit();
	}
		@DataProvider
		public Object[][] getData()
		{
			return new Object[][] {
				{"valid","porandlasaisrinadh@gmail.com","Srin@dh2448"},
				{"invalid_Pswd","porandlasaisrinadh@gmail.com","sdbkjdcf"},
				{"blank_Pswd","porandlasaisrinadh@gmail.com",""},
				};
				
			}
			
		}

