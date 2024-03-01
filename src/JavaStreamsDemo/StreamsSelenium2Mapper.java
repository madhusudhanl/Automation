package JavaStreamsDemo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsSelenium2Mapper {

	@Test
	public void sorting() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click(); // to click on header to sort
		
		List<WebElement> listItems =  driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> price = listItems.stream().filter(q->q.getText().contains("Apple"))
				.map(q->getItemPrice(q)).collect(Collectors.toList()); // we calling the function getItemprice and passing the list q
		
		price.forEach(q->System.out.println(q));
		
	}

	private String getItemPrice(WebElement q) {
		// TODO Auto-generated method stub
		// here q already has  values of Apple now we need find price by  traversing to next column. so we can start q.findElement;
		String price = q.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
}
