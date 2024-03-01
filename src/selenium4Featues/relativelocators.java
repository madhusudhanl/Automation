package selenium4Featues;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativelocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// some of new locators added in Selenium 4.x
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//above(); -- relative locator.
		
		WebElement inputName = driver.findElement(By.xpath("//input[@name='name']"));
		
		//(driver.findElement(with(By.tagName("label")).above(inputName).getText()));
		
		System.out.println (driver.findElement(with(By.tagName("label")).above(inputName)).getText());
		
		WebElement dob = driver.findElement(By.xpath("//label[contains(text(),'Date of Birth')]"));
		
		Thread.sleep(3000);
		
		//below(); -- relative locator.
		driver.findElement(with(By.tagName("input")).below(dob)).click();
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(550,180)");
		
		//toLeftOf(); -- relative locator.
		WebElement chkbox = driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(chkbox)).click();
		
		//toRightOf(); -- relative locator.
		WebElement radiobt = driver.findElement(By.id("inlineRadio1"));
		String st = driver.findElement(with(By.tagName("label")).toRightOf(radiobt)).getText();
		System.out.println(st);
		
		
		
	}

}
