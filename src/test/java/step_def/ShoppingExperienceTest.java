package step_def;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import Data.Data;
import core.BrowserBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.CartPage;
import pageFactory.LandingPage;
import pageFactory.ProductDetailsPage;
import pageFactory.TodaysDealPage;

public class ShoppingExperienceTest {
	TodaysDealPage todaysDealPage;
	ProductDetailsPage productDetailsPage;
	LandingPage landingPage;
	@When("I navigate to menu {string}")
	public void i_navigate_to_menu(String menu) {
	    landingPage=PageFactory.initElements(BrowserBase.driver, LandingPage.class);
		landingPage.clickOnMenu(menu);
	}
	@When("I select category as {string}")
	public void i_select_category_as(String category) throws InterruptedException {
		Thread.sleep(3000);
		todaysDealPage=PageFactory.initElements(BrowserBase.driver, TodaysDealPage.class);
		int categoryNumber=Integer.parseInt(category);
		System.out.println("categoryNumber"+categoryNumber);
		todaysDealPage.selectCatageriyByIndex(categoryNumber);
		

	}
	@When("Select quantity as {string}")
	public void select_quantity_as(String quantity) {
		productDetailsPage.selectQuantity(quantity);
		Data.productDetails.put(Data.productEnum.QUANTITY, quantity);
		Data.productDetails.put(Data.productEnum.PRODUCT_NAME,productDetailsPage.getProductName());
		Data.productDetails.put(Data.productEnum.PRICE,productDetailsPage.getPrice());
		Data.productDetails.put(Data.productEnum.SUB_TOTAL,productDetailsPage.getPrice()*Integer.parseInt(quantity));
		
	}
	@When("Navigate to cart")
	public void navigate_to_cart() throws InterruptedException {
		productDetailsPage.clickOnAddToCart();
		landingPage.clickOnCartIcon();
	}
	@Then("Verify correct item is added in cart")
	public void verify_correct_item_is_added_in_cart() { 
		CartPage cartPage= PageFactory.initElements(BrowserBase.driver,CartPage.class);
		Data.productOnCart.put(Data.productEnum.QUANTITY, cartPage.getQuantity());
		Data.productOnCart.put(Data.productEnum.PRODUCT_NAME,cartPage.getProductName());
		Data.productOnCart.put(Data.productEnum.PRICE,cartPage.getPrice());
		Data.productOnCart.put(Data.productEnum.SUB_TOTAL,cartPage.getSubTotal());
		System.out.println("Data.productOnCart"+Data.productOnCart);
		System.out.println("Data.productDetails"+Data.productDetails);
		Assert.assertEquals(Data.productOnCart, Data.productDetails);
		
	}

	@When("I select product with index {string}")
	public void selectProduct(String product) throws InterruptedException {
		int productIndex=Integer.parseInt(product);
		todaysDealPage.SelectProductByIndex(productIndex);	
	    productDetailsPage= PageFactory.initElements(BrowserBase.driver,ProductDetailsPage.class );
	}

}
