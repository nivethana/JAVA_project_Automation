import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class OrangeAutomation {
	private static final Logger LOGGER=Logger.getLogger(OrangeAutomation.class);
	public SoftAssert softAssert;
		
	
	  WebDriver driver;
     String baseUrl="http://the-internet.herokuapp.com/login";
    String driverPath="executions//";
     
    
  @BeforeTest
  public void befoerTest() {
	  System.out.println("test is runnig.......");
  }
  @BeforeMethod
     public void initiateDriver() {
	  System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
	 	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseUrl);
	
	}
  
  @BeforeMethod
  public void beforeMethod() {
	  softAssert = new SoftAssert();
  }
  @Test
  public void loginTest() {
	  softAssert = new SoftAssert();
	  LOGGER.info("Login Test");
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
	  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("//*[@class=\"radius\"]")).click();
	  String secure=driver.findElement(By.id("flash")).getText();
	  softAssert.assertTrue(secure.contains("You logged into a secure area!"),"not equal");
	  softAssert.assertAll();
	  
  }
  @AfterMethod
  public void closeBrowser() {
	 // driver.close();
  }
   
    

}
