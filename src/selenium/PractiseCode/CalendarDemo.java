package selenium.PractiseCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1325)");
		Thread.sleep(3000);
		
		//
		
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		List <WebElement> dates = driver.findElements(By.xpath("//div[@class='dayContainer']/span"));
		
		int count = driver.findElements(By.xpath("//div[@class='dayContainer']/span")).size();
		
		//System.out.println(count);

		for(int i=0 ;i<count;i++) {
			
			String singledate = driver.findElements(By.xpath("//div[@class='dayContainer']/span")).get(i).getText();
			
			if(singledate.equalsIgnoreCase("27")) {
				
				driver.findElements(By.xpath("//div[@class='dayContainer']/span")).get(i).click();
				break;
				
			}
		}
	}

}
