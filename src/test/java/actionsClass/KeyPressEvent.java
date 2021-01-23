package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressEvent {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		
		WebElement search=driver.findElement(By.xpath("//input[@id='target']"));
		
		Actions act= new Actions(driver);
		// Option 1
		search.sendKeys(Keys.SPACE);
		
		WebElement result=driver.findElement(By.id("result"));
		
		String txt=result.getText();
		System.out.println("text displayed is: "+txt);
		
		Thread.sleep(3000);
		
		search.sendKeys(Keys.ENTER);
		
		String txt1=result.getText();
		System.out.println("text displayed is: "+txt1);
		
		// Option 2
		
		act.sendKeys(Keys.SHIFT).build().perform();
		
		String txt2=result.getText();
		System.out.println("text displayed is: "+txt2);
		
		// Option 3
		
		
		
		driver.close();

	}

}
