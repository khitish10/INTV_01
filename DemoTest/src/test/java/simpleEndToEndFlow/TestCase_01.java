package simpleEndToEndFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_01 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Open AUT URL
		driver.get("https://leafground.com/dashboard.xhtml");
		
		driver.findElement(By.xpath("(//a[@href=\"#\"])[5]")).click();
		driver.findElement(By.xpath("//span[text()='Frame']")).click();
		
		//Switch to 1st frame and click on first button
		WebElement btn_first_frame1 = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(btn_first_frame1);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println("Text present on 1st Button: "+driver.findElement(By.xpath("//button[@id='Click']")).getText());
		
		//Switch to parent frame
		driver.switchTo().parentFrame();
		
		//Switch to 3rd, followed by 4th frame and click on second button
		WebElement btn_second_frame3 = driver.findElement(By.xpath("//iframe[contains(@src,'page.')]"));
		driver.switchTo().frame(btn_second_frame3);
		WebElement btn_second_frame4=driver.findElement(By.xpath("//iframe[contains(@src,'frame')]"));
		driver.switchTo().frame(btn_second_frame4);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println("Text present on 2nd Button: "+driver.findElement(By.xpath("//button[@id='Click']")).getText());
		
		driver.quit();
		

	}

}
