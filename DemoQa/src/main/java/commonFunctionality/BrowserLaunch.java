package commonFunctionality;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends ReadProperties {
	WebDriver driver;
	
public WebDriver initializeBrowser()  {
	
	readProperty();
	
	String browserName=prop.getProperty("Browser");
	
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver();
		driver=new EdgeDriver();
	}else if(browserName.equalsIgnoreCase("Internet Explorer")) {
		WebDriverManager.iedriver();
		driver=new InternetExplorerDriver();
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
}
	
}
