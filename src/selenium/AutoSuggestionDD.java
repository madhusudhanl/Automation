package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestionDD {
	//Didn't work as excepted 

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("afr");
		Thread.sleep(4000);
		int count = driver.findElements(By.xpath("//li[@class= 'ui-menu-item']/a")).size();
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			
			String value = driver.findElements(By.xpath("//li[@class= 'ui-menu-item']/a")).get(i).getText();
			
			System.out.println(value);
			
			
			if(value.equalsIgnoreCase("Central African Republic")) {
				
				driver.findElements(By.cssSelector("ul[id='ui-id-1']")).get(i).click();
				break;
				
			}
			
		}
		
//		List<WebElement> options = driver.findElements(By.xpath("//li[@class= 'ui-menu-item']/a"));
//		for (WebElement option : options) {
//
//			// System.out.println(option.getText());
//
//			if (option.getText().equalsIgnoreCase("South Africa")) {
//
//				option.click();
//				break;
//			}
//
//		}
		System.out.println(driver.findElement(By.id("autosuggest")).getText());
		//driver.close();
	}

}
