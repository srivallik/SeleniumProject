package testing;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandles {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.tutorialspoint.com/index.htm");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void methodForWindowHandles() {
	
	String parentHandle=driver.getWindowHandle();
	WebElement codingGroundLink=driver.findElement(By.xpath("//span[text()='Coding Ground ']"));
	codingGroundLink.click();
	Set<String> handles=driver.getWindowHandles();
	Iterator<String> i= handles.iterator();
	
	while(i.hasNext()) {
		String childWindow=i.next();
		driver.switchTo().window(childWindow);
	}
	WebElement libraryLink=driver.findElement(By.xpath("//span[text()=' Library ']"));
	libraryLink.click();
	Boolean status=driver.findElement(By.xpath("//p[text()='Tutorials Library, ']")).isDisplayed();
	System.out.println("Library page is dispalyed: "+status);
	List<WebElement> academicCourcesList=driver.findElements(By.xpath("//ul[@id='academic_tutorials']/li"));
	for(int j=0;j<academicCourcesList.size();j++) {
		System.out.println("Courses are : "+academicCourcesList.get(j).getText());
	}
	driver.switchTo().window(parentHandle);
	

}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
