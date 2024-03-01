package selenium.PractiseCode;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksandScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		int totalcount = driver.findElements(By.tagName("a")).size();
		
		System.out.println("Total count of driver "+ totalcount);
		
		// Limiting the scope of driver only to footer section
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		
		int footerlinkcount = footerdriver.findElements(By.tagName("a")).size();
		
		System.out.println("Footer link count "+ footerlinkcount);

		// Limiting the scope of driver only to footer section
		WebElement coloumdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
		
		int colonumlinkcount = coloumdriver.findElements(By.tagName("a")).size();
		
		System.out.println("Footer coloum link count "+ colonumlinkcount);
		
		for(int i=1; i<colonumlinkcount; i++) {
			
			String controlclick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumdriver.findElements(By.tagName("a")).get(i).sendKeys(controlclick);
			Thread.sleep(3000);
						
		}
		
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> loop = windowhandle.iterator();
		
		while(loop.hasNext()) {			//hasnext() lets us know whether there is any element present.
			String nextwindow = loop.next();		// get the handle of next window
			
			driver.switchTo().window(nextwindow); // switching to that window.
			
			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
			
		}
	}

}
