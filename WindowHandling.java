package seleniumPractice;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
	

		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL,Keys.END);	
		Thread.sleep(5000);

		String homeWindow = driver.getWindowHandle();
		System.out.println(homeWindow);

		WebElement homepage = driver.findElement(By.cssSelector("div>span>a>i[class='fa fa-instagram']"));
		homepage.click();
		Thread.sleep(5000);

		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);

		allWindow.remove(homeWindow);

		Iterator<String> itr = allWindow.iterator();
		String childWindow = itr.next();

		driver.switchTo().window(childWindow);


		driver.switchTo().defaultContent();
		//  oR
		//  driver.switchTo().window(homeWindow);

		driver.quit();
	}

}
