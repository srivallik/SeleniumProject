package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOperations {
	
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void MouseOperations() throws InterruptedException {
		
		WebElement live=driver.findElement(By.xpath("//div[@class='product-cards-wrapper--click']/a[@href='/live']"));
		Actions act=new Actions(driver);
		// act.moveToElement(live).click();
		
		act.moveToElement(live).build().perform();  // mouse hover
		 
		Thread.sleep(3000);
		
		WebElement appAutomate=driver.findElement(By.xpath("//div[@class='product-cards-wrapper--click']/a[@href='/app-automate']"));
		
        act.moveToElement(appAutomate).build().perform();
        
        Thread.sleep(1000);
        
        WebElement freeTrial=driver.findElement(By.id("free-trial-link-anchor"));
        
        act.doubleClick(freeTrial).perform();  // double click
        
        WebElement freeAccountTitle=driver.findElement(By.xpath("//h1[normalize-space(text())='Create a FREE Account']"));
        
        String text=freeAccountTitle.getText();
        
        System.out.println("text is: "+text);
        
        Assert.assertEquals(text, "Create a FREE Account");
		
	}

	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
