package selenium.PractiseCode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksDemo2 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		// Same broken link program with soft assertion

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// String Url = driver.findElement(By.xpath("//a[contains(text(),'Broken
		// Link')]")).getAttribute("href");
		// System.out.println(Url);

		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		int count = links.size();
		
		SoftAssert as = new SoftAssert();
		
		for (int i = 0; i < count; i++) {

			String url = links.get(i).getAttribute("href");

			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int resCode = con.getResponseCode();
			System.out.println(resCode);
			as.assertTrue(resCode<400, "The broken link text is "+links.get(i).getText());
			

		}
		
		as.assertAll();
	}

}
