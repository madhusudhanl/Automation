package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000L);

		// driver.findElement(By.xpath("//a[@value='BLR']")).click();

		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		// driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(1000L);

		driver.findElement(
				By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//

		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		/*
		 * driver.findElement(By.id("divpaxinfo")).click(); Thread.sleep(2000L);
		 * 
		 * System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // for
		 * // adding 4 adults using loops
		 * 
		 * int i = 1; while (i < 5) { driver.findElement(By.id("hrefIncAdt")).click();
		 * i++; }
		 * 
		 * driver.findElement(By.id("hrefIncChd")).click();
		 * driver.findElement(By.id("hrefIncInf")).click();
		 * driver.findElement(By.id("btnclosepaxoption")).click();
		 * 
		 * System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 * 
		 * Thread.sleep(2000L); // for visibility only
		 */
		driver.close();

	}

}
