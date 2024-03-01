package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//input[id='checkBoxOption1']
		
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		int count = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		
		System.out.println("Check box count "+count);
		
		driver.close();

	}

}
