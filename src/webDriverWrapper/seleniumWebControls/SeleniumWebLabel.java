package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.ILabel;

public class SeleniumWebLabel extends SeleniumWebControls implements ILabel{
	public SeleniumWebLabel(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
	}
}
