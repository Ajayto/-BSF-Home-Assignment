package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.QAElements;

public class CartPage extends QAElements {
	@FindBy(css = ".a-truncate-cut") public WebElement productName;
	@FindBy(css=".sc-product-price") public WebElement textPrice;
	@FindBy(css=".a-dropdown-prompt") public WebElement textQuantity;
	@FindBy(css="#sc-subtotal-amount-buybox span.sc-price") public WebElement textSubTotal;

	public String getProductName() {
		return getText(productName);
	}

	public int getQuantity() {
		return Integer.parseInt(getText(textQuantity));
	}

	public float getPrice() {
		return Float.valueOf(getText(textPrice).replace("AED ", ""));
	}

	public float getSubTotal() {
		return Float.valueOf(getText(textSubTotal).replace("AED ", "").replace("," ,""));
	}
}
