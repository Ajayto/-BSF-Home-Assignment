package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.QAElements;

public class YourListPage extends QAElements {
	@FindBy(xpath = "//span[text()='Lists']/parent::div") public WebElement texListMessage;

	public String getTextListPage(){
     return getText(texListMessage);
	}

}
