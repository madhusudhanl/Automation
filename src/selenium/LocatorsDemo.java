package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Chrome driver setup;
//		System.setProperty("webdriver.chrome.driver","F:\\Work\\Udemy\\05Dec2023\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Edge driver setup;
//		System.setProperty("webdriver.msedge.driver", "F:\\Work\\Udemy\\05Dec2023\\Drivers\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Madhu");
		driver.findElement(By.name("inputPassword")).sendKeys("pass");
		driver.findElement(By.className("signInBtn")).click();
		String s = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(s);
//		Thread.sleep(500);
//		driver.close();
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Madhu");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Madhu149@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("madhus149@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String msg = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println("Reset password message " +msg);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("madhus149@gmail.com");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		driver.close();		
		
	}

}
