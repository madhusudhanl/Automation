package selenium.VeggieKartPrg;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings("unused")
public class VeggiekartOptimized {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // updated way of using implict wait in selenium 4 

		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String[] ItemNeeded = { "Mushroom", "Apple", "Musk Melon" };
		
		VeggiekartOptimized call = new VeggiekartOptimized(); // creating object and calling method
		call.addItemsToCart(driver, ItemNeeded);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
				
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		
		String msg = driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
		
		System.out.println(msg);
		
	}

	public void addItemsToCart(WebDriver driver, String[] ItemNeeded) {

		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {

			String productName = products.get(i).getText(); // Cashews - 1 Kg
			String[] productSplit = productName.split("-"); // productSplit[0] = 'Cashews 'and productSplit[0] = '1 Kg'
			String formattedProd = productSplit[0].trim();

			// Now we have convert array to arrayList, so that it become easy for searching.
			// System.out.println("--"+formattedProd);

			List itemNamelist = Arrays.asList(ItemNeeded);
			// System.out.println(itemNamelist);

			if (itemNamelist.contains(formattedProd)) {

				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break; since we are checking multiple items no need to break.

				if (j == ItemNeeded.length) {// to come out of loop statement once the lenght/count of the array is
												// passed
					break;
				}
			}

		}
	}
}
