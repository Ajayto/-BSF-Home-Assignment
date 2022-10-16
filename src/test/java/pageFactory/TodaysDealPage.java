package pageFactory;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.QAElements;

public class TodaysDealPage extends QAElements {
	@FindBy(xpath = "//a[@data-type='filter']") public List<WebElement> allCatageriy;
	@FindBy(xpath = "//div[@data-testid='grid-deals-container']//img")public List<WebElement> allProduct;
	@FindBy(xpath = "//img[@alt='asin image url']") public List<WebElement> AllSubProduct;
	public void selectCatageriyByIndex(int index){
		System.out.println("allCatageriy"+allCatageriy.size());
		clickElement(allCatageriy.get(index-1));
	}

	public void SelectProductByIndex(int productIndex) throws InterruptedException {
		clickElement(allProduct.get(productIndex-1));
		System.out.println(AllSubProduct.size());
		if(AllSubProduct.size()>0) {

			clickElement(AllSubProduct.get(0));
		}
	}
}
