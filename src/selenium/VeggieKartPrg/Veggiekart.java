package selenium.VeggieKartPrg;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

@SuppressWarnings("unused")
public class Veggiekart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		int j = 0;

		String[] ItemNeeded = { "Mushroom", "Apple", "Musk Melon" };

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

				if (j == ItemNeeded.length) {// to come out of loop statement once the lenght/count of the array is passed
					break;
				}
			}

		}

	}

}
