package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.ICheckBox;

public class SeleniumWebCheckBox extends SeleniumWebControls implements ICheckBox {
	
	public SeleniumWebCheckBox(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	}
	
	
	public void Check()
    {
        if(!getIsChecked())
        {
            aWebElement.click();
        }
    }       
}
