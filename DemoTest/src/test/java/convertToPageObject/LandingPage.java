package convertToPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='#'])[5]")
	WebElement icon_browser;
	
	@FindBy(xpath="//span[text()='Frame']")
	WebElement optn_frame;
	
	public void clickBrowserIcon() {
		icon_browser.click();
	}
	
	public void clickFrameOption() {
		optn_frame.click();
	}

}
