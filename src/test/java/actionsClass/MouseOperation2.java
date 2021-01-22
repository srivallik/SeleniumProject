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

public class MouseOperation2 {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		
	}
	
	@Test
	public void MouseOperation2() throws InterruptedException {
		
		Actions act=new Actions(driver);
		WebElement selDropDown=driver.findElement(By.xpath("//a[normalize-space(text())='Selenium' and @class='dropdown-toggle']"));
		act.moveToElement(selDropDown).build().perform();
		selDropDown.click();
		
		WebElement accessLink=driver.findElement(By.xpath("//a[normalize-space(text())='Accessing Link']"));
		act.moveToElement(accessLink).build().perform();
		accessLink.click();
		
		driver.navigate().back();
		
		
		WebElement seoEle=driver.findElement(By.xpath("//a[normalize-space(text())='SEO']"));
		
		act.moveToElement(seoEle).build().perform();
		act.moveToElement(seoEle).click();
		
		Thread.sleep(1000);
		
		WebElement page3=driver.findElement(By.xpath("//a[normalize-space(text())='Page-3']"));
		act.moveToElement(page3).build().perform();
		page3.click();
		
		Thread.sleep(1000);
		
		WebElement textInPage3=driver.findElement(By.xpath("//center[text()='THIS IS A DEMO PAGE FOR TESTING']"));
		
		String txt=textInPage3.getText();
		
		System.out.println("text is : "+txt);
		
		Assert.assertEquals(txt, "THIS IS A DEMO PAGE FOR TESTING");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
