package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IWebTable;

public class SeleniumWebTable extends SeleniumWebControls implements IWebTable {
	public SeleniumWebTable(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
	}

}
