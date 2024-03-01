package selenium.ActionsDemo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));

		driver.findElement(By.className("blinkingText")).click();
		Set<String> windowhandle = driver.getWindowHandles(); // will fetch number window in form of set
																// [parentId,childId]

		Iterator<String> it = windowhandle.iterator(); // using iterator will have traverse to required window

		String parentwindow = it.next();
		String childwindow = it.next();

		driver.switchTo().window(childwindow);
		
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='im-para red']"))));      

		String para = driver.findElement(By.cssSelector(".im-para.red")).getText(); // use dot insted of space in class
																					// name in css selector

		String[] childpara1 = para.split("at");

		String childpara2 = childpara1[1].trim();

		String[] childpara3 = childpara2.split("with");
		
		String emailId1 = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("with")[0].trim();
		System.out.println("Out put from debug and watch "+emailId1);

		String emailId = childpara3[0].trim();

		System.out.println(emailId);

		driver.switchTo().window(parentwindow);
		// Thread.sleep(3000);

		driver.findElement(By.id("username")).sendKeys(emailId);

//		System.out.println(childpara1[1]);
//		System.out.println(para);
	}

}
