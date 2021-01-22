import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
				
	}
	
	public void takeScreenshot(String testMethodName) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //indicates a driver can take screenshot and store it in different ways
		try {
			//FileUtils.copyFile(src, new File("C:\\Users\\DELL\\CoreJavaWorkSpace\\SeleniumProject\\screenshot\\testFailed.jpg"));  static name
			FileUtils.copyFile(src, new File("C:\\Users\\DELL\\CoreJavaWorkSpace\\SeleniumProject\\screenshot\\"+"failed_screenshot_"+testMethodName+"_"+".jpg")); //dynamic name for .jpg file name
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
