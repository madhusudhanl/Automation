package selenium.PractiseCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingWindowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); // to scroll overall window.

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500"); // to scroll within the table.

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int total = 0;
		for (int i = 0; i < values.size(); i++) {

			int val2 = Integer
					.parseInt(driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText());
			// converting string value into integer since getText() return string.

			total = total + val2;

		}
		
		System.out.println(total);
		
		String recVal = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		
		int totalcaputred = Integer.parseInt(recVal);
		
		Assert.assertEquals(total,totalcaputred);
	}

}
