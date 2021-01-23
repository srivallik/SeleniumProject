package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriverNew.exe");
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		
		Actions act =new Actions(driver);
		WebElement source=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement target=driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		//  method 1
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		
		WebElement source1=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement target1=driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		// method 2
		act.dragAndDrop(source1, target1).build().perform();;
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		

	}

}
