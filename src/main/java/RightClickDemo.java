import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickDemo {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver =new ChromeDriver(options);
		driver.get("https://demoqa.com/buttons");
		
		System.out.println("demoqa webpage displayed");
		Actions actions=new Actions(driver);
		//WebElement rightClickButton=driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		WebElement rightClickButton=driver.findElement(By.id("rightClickBtn"));
		WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
		/*
		 * JavascriptExecutor jse=(JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 */
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		
		actions.doubleClick(doubleClickButton).perform();
		//actions.contextClick(rightClickButton).perform();
		System.out.println("Right Click context menu displayed");
		
	}

}
