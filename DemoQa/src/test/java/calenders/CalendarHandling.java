package calenders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(iFrame);
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
		dateSelector(31,"May","2024");
		driver.close();
		
	    
	}

	public static void dateSelector(int date,String selectMonth,String selectYear) {
		String monthAndYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    String[] split = monthAndYear.split(" ");
	    String month=split[0]; 
	    String year=split[1];
	    
	    if(date>31) {
	    	System.out.println("Invalid Date Selected: "+date+"/"+selectMonth+"/"+selectYear);
	    	return;
	    }
	    
	    if(selectMonth.equalsIgnoreCase("February")&&date>29) {
	    	System.out.println("Invalid Date Selected: "+date+"/"+selectMonth+"/"+selectYear);
	    	return;
	    	
	    }
	    
	    while(!(month.equalsIgnoreCase(selectMonth)&&year.equals(selectYear))) {
	    	driver.findElement(By.xpath("//span[text()='Next']")).click();
	    	monthAndYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    	 split = monthAndYear.split(" ");
		     month=split[0];
		     year=split[1];
	    
	    }
	    String xpath="//a[text()=\'"+date+"\']";
	    driver.findElement(By.xpath(xpath)).click();
		
		
		
	}
	
}
