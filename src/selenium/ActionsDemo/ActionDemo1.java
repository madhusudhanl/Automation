package selenium.ActionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		// Defining Actions class 
		Actions at = new Actions(driver);
		
		WebElement accounts = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		
		WebElement searchbox = driver.findElement(By.xpath("//form[@id='nav-search-bar-form']"));
		
		//To enter characters in cap holding shift key
		at.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("small character").build().perform();
		
		//TO hover accounts
		at.moveToElement(accounts).build().perform();
		
		//To rightclick on element
		at.moveToElement(accounts).contextClick().build().perform();


		
	}

}
