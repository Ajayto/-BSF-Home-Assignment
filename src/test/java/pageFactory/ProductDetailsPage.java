package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.QAElements;

public class ProductDetailsPage extends QAElements {
	@FindBy(id = "productTitle") public WebElement productName;
	@FindBy(xpath = "//*[@id='corePrice_feature_div']/div/span/span[1]") public WebElement textPrice;
	@FindBy(id = "quantity") public WebElement dropDownQuantity;
	@FindBy(id = "add-to-cart-button") public WebElement addToCartButton;
	@FindBy(id = "attachSiNoCoverage") public WebElement btnNoThanks;

	public String getProductName() {
		return getText(productName);
	}
	public float getPrice() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		String priceInText= (String)executor.executeScript("return arguments[0].innerText;", textPrice);
		float productPrice=Float.valueOf(priceInText.replace("AED", ""));
		return productPrice;
	}

	public void selectQuantity(String visiableText){
		selectWithVisibleText(dropDownQuantity,visiableText );
	}

	public void clickOnAddToCart() throws InterruptedException {
		addToCartButton.click();
		Thread.sleep(1000);
		if(btnNoThanks.isDisplayed()) {
			btnNoThanks.click();
		}
		Thread.sleep(1000);
	}

}
