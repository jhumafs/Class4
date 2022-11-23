package webELement;



import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementDesign {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver_105.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public void loginTest() {
		WebElement USERNAME = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON = driver.findElement(By.xpath("//button[text()='Sign in']"));
		
		
		USERNAME.sendKeys("demo@techfios.com");
		PASSWORD.sendKeys("abc123");
		SIGNIN_BUTTON.click();
		
//		By UNAME_LOCATOR = By.xpath("//input[@id='username']");
//		By PASSWORD_LOCATOR = By.xpath("//input[@id='password']");
//		driver.findElement(UNAME_LOCATOR).sendKeys("");
		
		WebElement DASHBOARD_HEADER = driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(DASHBOARD_HEADER));
		
		//WebElement DASHBOARD_HEADER = driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
		Assert.assertTrue("wrong page", DASHBOARD_HEADER.isDisplayed());
		System.out.println("DashBoard Page");
		
		
	}

}
