package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KBOperations {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		
		WebElement search=driver.findElement(By.name("q"));
		Actions act=new Actions(driver);
		act.keyDown(search, Keys.ALT)
		   .sendKeys("Actions class")
		   .keyUp(search, Keys.SHIFT)
		   .keyDown(search, Keys.CONTROL)
		   .sendKeys("a")
		   .keyDown(search, Keys.CONTROL)
		   .sendKeys("x")
		   .build()
		   .perform();
		
		
		driver.close();

	}

}
