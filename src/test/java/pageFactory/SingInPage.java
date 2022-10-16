package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.QAElements;

public class SingInPage extends QAElements {
	@FindBy(id = "ap_email") public WebElement textboxEmail;
	@FindBy(css = ".a-list-item") public WebElement alertTextInValidEmail;
    @FindBy(id = "continue") public WebElement btnContinue;

	public void enaterEmail(String emailID) {
		enterText(textboxEmail, emailID);
	} 
	
	public String getAlertText() {
		return getText(alertTextInValidEmail);
	}
	
	public void clickOnContinue() {
		clickElement(btnContinue);
	}
	
	public boolean isEmailTextBoxDisplayed() {
		return textboxEmail.isDisplayed();
	}

}
