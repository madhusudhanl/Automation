package JavaStreamsDemo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsSeleniumPagination {

	@Test
	public void sorting() {
		//Pagination concept if element not found in first page then click on next button go next and perform operation.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click(); // to click on header to sort
		
		List<WebElement> listItems =  driver.findElements(By.xpath("//tr/td[1]"));
		List<String> price;
		
		do 
		{
			listItems =  driver.findElements(By.xpath("//tr/td[1]"));// we have to find items every time a page is loaded
			price = listItems.stream().filter(q->q.getText().contains("Wheat"))
					.map(q->getItemPrice(q)).collect(Collectors.toList()); // we calling the function getItemprice and passing the list q
			
			price.forEach(q->System.out.println("The price of Item is "+q));
			if(price.size()<1) { // if item not found in 1st page then goto to next page by clicking next button
				
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
			
		}
		while(price.size()<1); // check size of list, price is list of item and to check the size we use size method.
		
		
	}
	private String getItemPrice(WebElement q) {
		// TODO Auto-generated method stub
		// here q already has  values of Apple now we need find price by  traversing to next column. so we can start q.findElement;
		String price = q.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
}
