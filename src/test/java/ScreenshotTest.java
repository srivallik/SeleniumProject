import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenshotTest extends BaseClass{

	@BeforeMethod
	public void setUp() {
		
		initialization();

	}

	@AfterMethod
	public void tearDown() {
         driver.quit();
	}

	@Test
	public void Login() {
		
		Assert.assertEquals(false, true);

	}
	
	@Test
	public void Search() {
		
		Assert.assertEquals(false, true);

	}
	
	@Test
	public void Gmail() {
		
		Assert.assertEquals(false, true);

	}
}
