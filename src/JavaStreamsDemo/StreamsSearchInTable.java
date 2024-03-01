package JavaStreamsDemo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsSearchInTable {
	@Test
	public void searching() {
		//Pagination concept if element not found in first page then click on next button go next and perform operation.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Almond");
		
		List<WebElement> vegList = driver.findElements(By.xpath("//tr/td[1]"));
		// result with 1 row
		
	List<WebElement> firstList = vegList.stream().filter(veggie->veggie.getText().contains("Almond"))
			.collect(Collectors.toList());
	
	// result with 1 row, so if you compare size of two list you'll the results.
	
	Assert.assertEquals(vegList.size(),firstList.size());
		

	}
}

