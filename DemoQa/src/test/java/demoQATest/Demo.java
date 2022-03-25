package demoQATest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static WebDriver driver;
	static JavascriptExecutor jse;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");

		WebElement hotel = driver.findElement(By.xpath("(//a[@class='makeFlex hrtlCenter column'])[1]"));
		WebElement homeStay = driver.findElement(By.xpath("(//a[@class='makeFlex hrtlCenter column'])[2]"));
		WebElement holiday = driver.findElement(By.xpath("(//a[@class='makeFlex hrtlCenter column'])[3]"));

		 jse = (JavascriptExecutor) driver;
		jse.executeScript(
				"document.getElementsByClassName('autopop__wrap  makeFlex column defaultCursor')[0].remove();");
		jse.executeScript("document.getElementsByClassName('topbarInputBox footerInput')[0].value=\"0987654321\"");
		jse.executeScript("arguments[0].click()", hotel, homeStay, holiday);
		Thread.sleep(2000);
		jse.executeScript("arguments[1].click()", hotel, homeStay, holiday);
		Thread.sleep(2000);
		jse.executeScript("arguments[2].click()", hotel, homeStay, holiday);
	}

	public static void javaScriptClick(String type,String homeStay,String holiday) throws InterruptedException {
		jse.executeScript("arguments[0].click()", type, homeStay, holiday);
		Thread.sleep(2000);
		jse.executeScript("arguments[1].click()", type, homeStay, holiday);
		Thread.sleep(2000);
		jse.executeScript("arguments[2].click()", type, homeStay, holiday);
		
	}
	
	
}



