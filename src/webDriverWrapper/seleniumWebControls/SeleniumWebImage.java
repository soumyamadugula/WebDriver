package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IImage;

public class SeleniumWebImage extends SeleniumWebControls implements IImage {
	public SeleniumWebImage(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	}
}
