package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String Username = "Madhu";
		System.setProperty("webdriver.chrome.driver",
				"F:\\Work\\Udemy\\05Dec2023\\Drivers\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		// calling method by creating object 
		LocatorsDemo2 ob = new LocatorsDemo2();
		String pwd = ob.getPassword(driver);
		System.out.println(pwd);
				
		//String pwd = getPassword(driver); calling method directly.
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(Username);
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello "+Username+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); //text() is present only for xpath and not for css selector.
		//button[text()='Log Out'] -- both xpaths are same .
		
		driver.close();
	}
	
	public  String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordstring = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordpart1 = passwordstring.split("'");
		String[] passwordpart2= passwordpart1[1].split("'");
		String requiredPass = passwordpart2[0];
		return  requiredPass;
		
		
		//0th index - Please use temporary password

		//1st index - rahulshettyacademy' to Login.

		//0th index - rahulshettyacademy

		//1st index - to Login.
		
	}

}
