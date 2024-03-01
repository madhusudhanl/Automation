package selenium.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); // to scroll overall window.

		int col = driver.findElements(By.cssSelector("table[name='courses'] th")).size();
		int row = driver.findElements(By.cssSelector("table[name='courses'] tr")).size();

		String row2 = driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText();

		System.out.println("Col count " + col);
		System.out.println("Row count " + row);
		System.out.println(row2);

	}

}
