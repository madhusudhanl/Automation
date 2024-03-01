package selenium4Featues;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

// New feature added in Selenium 4.x taking screenshot of particular web-element instead entry page.

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
		nameField.sendKeys("Taking Element Screenshot");
		
		// code for taking WebElement screenshot
		File scrFile = nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("webElementSS.png"));
		
		// code for taking complete screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("full-screenshot.png"));
		
		//to find dimension of field
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
		
		
		driver.close();
	}

}
