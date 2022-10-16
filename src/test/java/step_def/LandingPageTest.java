package step_def;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import core.BrowserBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LandingPage;
import pageFactory.SingInPage;
import pageFactory.YourListPage;

public class LandingPageTest {
	LandingPage landingPage;
	SingInPage singInPage;
	YourListPage yourListPage;

	@When("Select menu as {string} from account and list")
	public void select_menu_as_from_account_and_list(String menuName) {
		landingPage=PageFactory.initElements(BrowserBase.driver, LandingPage.class);
		landingPage.clickOnMenu(menuName);
	}

	@Then("Verify login page is displayed")
	public void verify_login_page_is_displayed() {
		singInPage=PageFactory.initElements(BrowserBase.driver, SingInPage.class);
		Assert.assertEquals(true,singInPage.isEmailTextBoxDisplayed() );

	}

	@When("I navigate back")
	public void i_navigate_back() {
		BrowserBase.driver.navigate().back();
	}

	@Then("Verify list page is displayed with text {string}")
	public void verify_list_page_is_displayed(String message) {
		yourListPage=PageFactory.initElements(BrowserBase.driver, YourListPage.class);
		org.junit.Assert.assertEquals(message,yourListPage.getTextListPage());
	}
}
