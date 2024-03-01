package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Round trip selection
		driver.findElement(By.cssSelector("input[id*='Trip_1']")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000L);

		// driver.findElement(By.xpath("//a[@value='BLR']")).click();

		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		// driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(1000L);

		driver.findElement(
				By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		// Calendar
		// Select current date
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			Assert.assertTrue(true);
			System.out.println("Its enabled");
		}else {
			Assert.assertTrue(false);
			System.out.println("Its disabled");
		}

		// Check box
		int count = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(count);
		Thread.sleep(2000);
		// to check whether check box is selected or not
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		// passenger
		/*
		 * driver.findElement(By.id("divpaxinfo")).click(); Thread.sleep(2000L);
		 * 
		 * //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 * 
		 * 
		 * int i = 1; while (i < 5) { // for adding 5 adults using loops
		 * driver.findElement(By.id("hrefIncAdt")).click(); i++; }
		 * 
		 * driver.findElement(By.id("hrefIncChd")).click();
		 * driver.findElement(By.id("hrefIncInf")).click();
		 * driver.findElement(By.id("btnclosepaxoption")).click();
		 * 
		 * Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),
		 * "5 Adult, 1 Child, 1 Infant");
		 * 
		 * //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 */
	}

}
