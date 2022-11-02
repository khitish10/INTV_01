package convertToPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
	WebDriver driver;
	public FramePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='Click']")
	WebElement first_button;
	
	@FindBy(xpath="//button[@id='Click']")
	WebElement second_button;
	
	public void clickFirstButton() {
		WebElement btn_first_frame1 = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(btn_first_frame1);
		first_button.click();
		System.out.println("Text present on 1st Button: "+driver.findElement(By.xpath("//button[@id='Click']")).getText());
		driver.switchTo().parentFrame();
	}
	
	public void clickSecondButton() {
		WebElement btn_second_frame3 = driver.findElement(By.xpath("//iframe[contains(@src,'page.')]"));
		driver.switchTo().frame(btn_second_frame3);
		WebElement btn_second_frame4=driver.findElement(By.xpath("//iframe[contains(@src,'frame')]"));
		driver.switchTo().frame(btn_second_frame4);
		second_button.click();
		System.out.println("Text present on 2nd Button: "+driver.findElement(By.xpath("//button[@id='Click']")).getText());
		
	}
	

}
