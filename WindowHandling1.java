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

public class WindowHandling1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		
		String homewindow = driver.getWindowHandle();
		System.out.println(homewindow);
		
		driver.findElement(By.name("newbrowserwindow123")).click();
		
		driver.manage().window().maximize();
		
		Set<String>allwindow = driver.getWindowHandles();
		System.out.println(allwindow);
		 
		allwindow.remove(homewindow);
		
		Iterator<String> itr = allwindow.iterator();
		String Childwindow = itr.next();
		
		driver.switchTo().window(Childwindow);
		driver.manage().window().maximize();
		
	   List<WebElement> menu = driver.findElements(By.xpath("//nav[@class='navigation main-navigation clr']/ul/li"));
	   System.out.println(menu.size());
	   
		
	   Actions act = new Actions(driver);
	   
	   for(int i=0;i<menu.size();i++) {
		   WebElement op = menu.get(i);
		   act.moveToElement(op).build().perform();
		   Thread.sleep(2000);
	   }
	   
	   driver.switchTo().defaultContent();
	   
	   driver.quit();
		
	}

}
