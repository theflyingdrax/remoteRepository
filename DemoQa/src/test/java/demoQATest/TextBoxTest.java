package demoQATest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commonFunctionality.BrowserLaunch;
import demoQA.ElementsLandingPage;

public class TextBoxTest extends BrowserLaunch {
	public WebDriver driver;

	@Test(groups="Sanity")
	public void textBoxTest() {
		driver = initializeBrowser();
		driver.get(prop.getProperty("URL"));
		ElementsLandingPage elementsLandingPage=new ElementsLandingPage(driver);
		elementsLandingPage.textBoxOption().click();
		elementsLandingPage.fullNameField().sendKeys(prop.getProperty("FullName"));
		elementsLandingPage.emailField().sendKeys(prop.getProperty("Email"));
		elementsLandingPage.currentAddressField().sendKeys(prop.getProperty("CurrentAddress"));
		elementsLandingPage.permanentAddressField().sendKeys(prop.getProperty("PermanentAddress"));
		driver.close();
		
		
		

	}

}
