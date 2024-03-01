package selenium4Featues;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowTab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// New feature added in Selenium 4.x invoking multiple window/tab using single
		// driver instance.

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);// going to new tab.
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String parentTab = it.next(); // parent tab with index 0
		String childTab = it.next(); // child tab with index 1

		driver.switchTo().window(childTab);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver
				.findElements(By.xpath("//a[starts-with (@href,'https://courses.rahulshettyacademy.com/p')][1]")).get(1)
				.getText();
		driver.switchTo().window(parentTab);
		WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
		nameField.sendKeys(courseName);

		Thread.sleep(3000);
		driver.quit();
	}

}
