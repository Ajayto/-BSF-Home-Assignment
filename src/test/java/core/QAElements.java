package core;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAElements extends BrowserBase {


	public static void isExist(WebElement element){		
		assertTrue("Element not found in DOM", element.isDisplayed());
	}

	/**
	 * @function Exists
	 * @description To Check element is displayed or not, it will not trigger an assert
	 * @param WebElement - WebElement
	 * @return True if element exists, false otherwise 
	 */
	public static boolean elemantExists(WebElement element) {		
		return element.isDisplayed();
	}

	/**
	 * @function checkEnable
	 * @description To Check element is enabled or not
	 * @param WebElement - element
	 */
	public static void checkEnable(WebElement element) {
		assertTrue("Element not enabled in DOM", element.isEnabled());
	}

	/**
	 * @function waitToClickable
	 * @description Wait till element can be clicked
	 * @param WebElement - element
	 */
	public static void waitToClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		checkEnable(element);
	}

	/**@function isElementPresentByWebElement
	 * @description 
	 * @param element to verify if displayed or enabled
	 * @return true if element si displayed or enabled, false otherwise
	 */
	public static boolean isElementPresent(WebElement element)
	{
		return elmDisplayed(element) && elemnetEnabled(element);	
	}

	/**
	 * @function elmDisplayed
	 * @description Verify if element is displayed
	 * @param WebElement - WebElement
	 * @return true is element is displayed, false otherwise
	 */
	public static Boolean elmDisplayed(WebElement element) {
		return(element.isDisplayed());	
	}

	/**
	 * @function elmEnabled
	 * @description Verify if element is Enabled
	 * @param WebElement - WebElement
	 * @return true is element is Enabled, false otherwise
	 */
	public static Boolean elemnetEnabled(WebElement element) {
		return(element.isEnabled());	
	}

	/**
	 * @function enterText
	 * @description To Check element exists and enter text if displayed else fail  
	 * @param WebElement - element , String textToEnter
	 */
	public static void enterText(WebElement element,String textToEnter){
		isElementPresent(element);
		element.clear();
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
		element.sendKeys(del + textToEnter);
	}

	/**
	 * @function clickElement
	 * @description Click an element  
	 * @param WebElement - element to click
	 */
	public static void clickElement(WebElement element){
		try {
			waitToClickable(element);
			element.click();
		}
		catch(Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}

	/**
	 * @function getText
	 * @description Get text from an element  
	 * @param WebElement - element to get text from
	 */
	public static String getText(WebElement element){	
		isElementPresent(element);
		return element.getText();
	}

	/**
	 * @function QAElements.selectWithVisibleText
	 * @description To select list element by visible text
	 * @param WebElement-element, String-textToSelect
	 */
	public static void selectWithVisibleText(WebElement element, String textToSelect) {
		isElementPresent(element);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
	}

	/**
	 * @function selectWithIndex
	 * @description To Select list element with index
	 * @param WebElement-element, String-indexToSelect
	 */
	public static void selectWithIndex(WebElement element, int indexToSelect) {
		isElementPresent(element);
		Select select = new Select(element);
		select.selectByIndex(indexToSelect);
	}

	/**
	 * @function selectWithIndex
	 * @description To Select list element with value
	 * @param WebElement-element, String-valueToSelect
	 */
	public static void selectWithValue(WebElement element, String valueToSelect) {
		try {
			isElementPresent(element);
			Select select = new Select(element);
			select.selectByValue(valueToSelect);
		}
		catch (Exception e) {
			System.err.println("selectWithValue(): " + e.getMessage());
		}
	}

	/**
	 * @function selectCheckboxOrRadio
	 * @description To Select radio button or check box 
	 * @param WebElement-element, Boolean-value
	 */
	public static void selectCheckboxOrRadio(WebElement element, Boolean bState) {
		try {
			isElementPresent(element);
			if(element.isSelected())
			{
				if(bState == false) {
					element.click();
				}
			}
			else {
				if(bState==true) {
					element.click();
				}
			}
		}
		catch (Exception e) {
			System.err.println("selectCheckboxOrRadio(): " + e.getMessage());
		}
	}
}
