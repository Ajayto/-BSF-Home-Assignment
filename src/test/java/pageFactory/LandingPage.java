package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import core.QAElements;

public class LandingPage extends QAElements {
	@FindBy(xpath = "//a[@id='nav-link-accountList']/span") public WebElement lnkSingIn;
	@FindBy(id="nav-cart") public WebElement iconCart;

	public void  clickOnSignInButton(){
		clickElement(lnkSingIn);
	}

	public void clickOnMenu(String menuName) {
		driver.findElement(By.xpath("//a[text()=\""+menuName+"\"]")).click();		
	}

	public void clickOnCartIcon() {
		waitToClickable(iconCart);
		clickElement(iconCart);
	}

	public void moveToAccountAndList() {
		Actions act= new Actions(driver);
		act.moveToElement(lnkSingIn).perform();
	}

	public void selectAccountMenu(String menuName) {
		moveToAccountAndList();
		driver.findElement(By.xpath("//span[text()='"+menuName+"']")).click();

	}
}
