package convertToPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Open AUT URL
		driver.get("https://leafground.com/dashboard.xhtml");
		
		//Create object of Landing page and call its methods
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickBrowserIcon();
		landingPage.clickFrameOption();
		
		//Create object of Frame page and call its methods
		FramePage framePage=new FramePage(driver);
		framePage.clickFirstButton();
		framePage.clickSecondButton();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
