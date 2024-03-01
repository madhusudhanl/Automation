package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownhandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		Dropdown with select tag are static dropdown and can be handling using select() in selenium.
		
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dd = new Select(staticdropdown);
		dd.selectByIndex(2);
		String valueSelected1 = dd.getFirstSelectedOption().getText();
		System.out.println("Value selected is "+valueSelected1);
		
		dd.selectByVisibleText("USD");
		String valueSelected2 = dd.getFirstSelectedOption().getText();
		System.out.println("Value selected is "+valueSelected2);
		
		dd.selectByValue("INR");	
		String valueSelected3 = dd.getFirstSelectedOption().getText();
		System.out.println("Value selected is "+valueSelected3);
		
		Thread.sleep(2000L);
		
		driver.close();
		
	}

}
