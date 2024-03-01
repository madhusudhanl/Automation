package selenium.PractiseCode;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("_yyyymmdd_hhmmss").format(new Date());
		String Filename = "SS"+timestamp+".png";
		
		File destFile = new File("F:\\Work\\Udemy\\05Dec2023\\Screenshots\\" +Filename); 
		FileUtils.copyFile(scrFile, destFile);
	}

}
