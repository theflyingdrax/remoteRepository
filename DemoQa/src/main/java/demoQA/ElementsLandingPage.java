package demoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsLandingPage {
	WebDriver drivre;

	public ElementsLandingPage(WebDriver driver) {
		this.drivre = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Text Box']")
	private WebElement textBoxOption;

	@FindBy(id="userName")
	private WebElement fullNameField;
	
	@FindBy(id="userEmail")
	private WebElement emailField;
	
	@FindBy(xpath = "//span[text()='Check Box']")
	private WebElement checkBoxOption;
	
	@FindBy(id="currentAddress")
	private WebElement currentAddressField;

	@FindBy(id="permanentAddress")
	private WebElement permanentAddressField;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	@FindBy(css="div[class='border col-md-12 col-sm-12']")
	private WebElement verifySubmit;
	
	public WebElement textBoxOption() {
		return textBoxOption;
	}
	
	public WebElement fullNameField() {
		return fullNameField;
	}

	public WebElement checkBoxOption() {
		return checkBoxOption;
	}
	
	public WebElement emailField() {
		return emailField;
	}
	
	public WebElement currentAddressField() {
		return currentAddressField;
	}
	
	public WebElement permanentAddressField() {
		return permanentAddressField;
	}
	
	public WebElement submitButton() {
		return submitButton;
	}
	public WebElement verifySubmit() {
		return verifySubmit;
	}
}
