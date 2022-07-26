package seleniumPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling2 {

	public static void main(String[] args) throws InterruptedException {
	

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Tab");
		
		String homeWindow = driver.getWindowHandle();
		System.out.println(homeWindow);
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		allWindow.remove(homeWindow);
		
		Iterator <String> itr = allWindow.iterator();
		String childwindow = itr.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		
		List<WebElement> menu = driver.findElements(By.cssSelector("div[id='menu']>ul>li"));
		
		Actions act = new Actions(driver);
		
		for(int i = 0;i<menu.size();i++) {
			WebElement op = menu.get(i);
			act.moveToElement(op).build().perform();
			Thread.sleep(2000);
		}
		
		driver.switchTo().defaultContent();
		
		driver.quit();
		
		
		
		
		
		
	}

}
