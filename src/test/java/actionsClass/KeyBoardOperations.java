package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyBoardOperations {

WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		
	}
	
	@Test
	public void KeyBoardOperations() {
		
		WebElement userName=driver.findElement(By.id("email"));
		Actions builder=new Actions(driver);
		Action seriesOfActions=builder.moveToElement(userName)
				               .click()
				               .keyDown(userName,Keys.SHIFT)
				               .sendKeys(userName,"hello")
				               .keyUp(userName, Keys.SHIFT)
				               .doubleClick(userName)
				               .contextClick()
				               .build();
		
		seriesOfActions.perform();		
		
	}
	
	
	  @AfterMethod public void tearDown() { 
		  driver.close(); 
			  }
	 
	
}
