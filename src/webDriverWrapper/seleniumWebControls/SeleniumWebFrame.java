package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IFrame;

public class SeleniumWebFrame extends SeleniumWebControls implements IFrame{
	public SeleniumWebFrame(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	}
}
