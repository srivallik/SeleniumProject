package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://demo.guru99.com/test/guru99home/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void TestFrames() {
		
	int size=driver.findElements(By.tagName("iframe")).size();
	System.out.println("Total no of frames are: "+size);
	
	driver.switchTo().frame("a077aa5e");
	Boolean statusOdAd=driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).isDisplayed();
	System.out.println("Advertisement is displayed: "+statusOdAd);
	
	driver.switchTo().defaultContent();
	WebElement frameId=driver.findElement(By.id("flow_close_btn_iframe"));
	driver.switchTo().frame(frameId);
	System.out.println("Moved into 2nd frame");
	
	
		
		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
}
