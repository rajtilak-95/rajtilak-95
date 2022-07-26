package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelectDropDown {

	public static void main(String[] args) {
    
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		WebElement dropdownList = driver.findElement(By.xpath("//select[@id='first']"));
		
		Select s1 = new Select(dropdownList);
		
		System.out.println("is multiSelect: "+s1.isMultiple());
		
		List<WebElement> options = s1.getOptions();
		
		System.out.println("all options: "+options.size());
		
		for(int i=0;i<options.size();i++) {
			System.out.println("options are : "+options.get(i).getText());
		}
		 
		
		String SelectedOption = s1.getFirstSelectedOption().getText();
		System.out.println(SelectedOption);
//		s1.selectByIndex(0);
		s1.selectByValue("Google");
//		s1.selectByVisibleText("Yahoo");
		
		System.out.println(s1.getFirstSelectedOption().getText());
		
		driver.close();
		
		
		
		
		
	}

}
