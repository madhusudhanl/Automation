package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"F:\\Work\\Udemy\\05Dec2023\\Drivers\\chromedriver-win64\\chromedriver.exe"); // this step can avoided since Selenium manager will do the downloading and mapping of Chrome driver.
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getCurrentUrl()); 
		driver.close();

	}

}
