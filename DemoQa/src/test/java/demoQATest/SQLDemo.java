package demoQATest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SQLDemo {
	WebDriver driver;

	@Test
	public void test() throws IOException, SQLException {
		Properties prop = new Properties();
		String dataFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\demoQATest\\data.properties";
		FileInputStream fis = new FileInputStream(dataFilePath);
		prop.load(fis);

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorialsninjacredentias",
				prop.getProperty("username"), prop.getProperty("password"));
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from logincredentials where Sr_no=1;");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		resultSet.next();
			driver.findElement(By.id("input-email")).sendKeys(resultSet.getString("email"));
			driver.findElement(By.id("input-password")).sendKeys(resultSet.getString("password"));
			driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
			driver.close();

		

	}

}
