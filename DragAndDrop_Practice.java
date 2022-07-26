package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop_Practice {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		driver.manage().window().maximize();

		WebElement frame =  driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
		driver.switchTo().frame(frame);


		//List od WebElement
		List<WebElement> source = driver.findElements(By.cssSelector("ul[id='gallery']>li"));
		WebElement target = driver.findElement(By.cssSelector("div[id='trash']"));


		Actions act = new Actions(driver);
		act.dragAndDrop(source.get(0), target).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(source.get(1), target).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(source.get(2), target).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(source.get(3), target).build().perform();
		Thread.sleep(2000);



		driver.close();
	}

}
