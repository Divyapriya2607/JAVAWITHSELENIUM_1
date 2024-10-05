import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	private static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/");
		WebElement elem=driver.findElement(By.xpath("(//div[@class='category-cards']/div)[3]//div[3]"));
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		elem.click();
		WebElement windowLink=driver.findElement(By.xpath("//div[@class='left-pannel']//div[3]"));
		windowLink.click();
		driver.findElement(By.xpath("(//div[contains(@class,'element-list')])[3]/ul/li[1]")).click();
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("(//div[@id='browserWindows']//following::button)[1]")).click();
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.)
		 */
		String originalTab=driver.getWindowHandle();
		List<String> tabs=new ArrayList<>(driver.getWindowHandles());
		for(String tab:tabs) {
		if(!tab.equals(tabs)) {
			driver.switchTo().window(tab);
			break;
		}
		}
		WebElement textOfNewTab=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		String text=textOfNewTab.getText();
		System.out.println("New Tab Text"+text);
		driver.switchTo().window(originalTab);
	}

}
