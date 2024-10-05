import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop1 {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/droppable/");
		
		WebElement fromElement=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement toElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
		Actions actions=new Actions(driver);
		Action dragAndDrop=actions.clickAndHold(fromElement).moveToElement(toElement).release().build();
		dragAndDrop.perform();
		String text=toElement.getText();
		if(text.equals("Dropped!")) {
			System.out.println("Source is dropped to target as expected");
		}else {
			System.out.println("Source couldn't be dropped to target as expected");
		}
		driver.close();
		driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		driver.navigate().to(driver.getCurrentUrl());
		
	}
}
