package selenium.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		int count = driver.findElements(By.tagName("frame")).size();
		System.out.println(count);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		
		String text = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(text);
		

	}

}
