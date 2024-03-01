package JavaStreamsDemo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsSelenium {

	@Test
	public void sorting() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click(); // to click on header to sort
		
		List<WebElement> listItems =  driver.findElements(By.xpath("//tr/td[1]"));
		
		//Getting text of listItem using Stream.
		
		List<String> OrgList = listItems.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// to sort the list using streams
		
		List<String> Sortedlist = OrgList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(OrgList, Sortedlist);// comparing two collection
		
		Assert.assertTrue(OrgList.equals(Sortedlist)); // return boolean true upon if both list are same.
		
		
	}
}
