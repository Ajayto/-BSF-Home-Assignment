package step_def;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import core.BaseClass;
import core.BrowserBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LandingPage;
import pageFactory.SingInPage;

public class LoginTest {

	SingInPage singInPage;
	@Given("I am on landing page")
	public void openApp() {
		BrowserBase.launchApp();
	}
	@When("I click on sing in button")
	public void i_click_on_sing_in_button() {
		LandingPage landingPage=PageFactory.initElements(BaseClass.driver,LandingPage.class);
		landingPage.clickOnSignInButton();
	}
	@When("I enter email address as {string} and click on continue")
	public void enterEmailAndClickContinue(String email) {  
		singInPage=PageFactory.initElements(BaseClass.driver,SingInPage.class);
		singInPage.enaterEmail(email);
		singInPage.clickOnContinue();
	}
	@Then("I verify error message is displayed as {string}")
	public void i_verify_error_message_is_displayed_as(String alertText) {
		Assert.assertEquals(singInPage.getAlertText(),alertText );
	}
}
