package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	
		
		Actions act=new Actions(driver);
		/*
		 * WebElement fleet=driver.findElement(By.linkText("Fleet"));
		 * act.moveToElement(fleet).build().perform(); fleet.click();
		 * 
		 * driver.navigate().back();
		 */
		
		WebElement departure=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']"));
		//act.moveToElement(departure).build().perform();
		Thread.sleep(3000);
		Select sel=new Select(departure); 
		sel.selectByIndex(2);
		 
		
		

	}

}
