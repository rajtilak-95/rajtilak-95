package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover_Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");

		//List of Hovering Element
		List <WebElement> menu =  driver.findElements(By.cssSelector("nav[class='desktop-navbar']>div>div"));
 
		System.out.println("size is : "+menu.size());

		for (WebElement i : menu) {
			System.out.println(i.getText());
		}

		Actions act = new Actions(driver);

		for (int i = 0; i < menu.size(); i++) {
			WebElement ops = menu.get(i);
			act.moveToElement(ops).build().perform();
			Thread.sleep(5000);

		}
		driver.close();

	}


}
