package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.ICheckBox;

public class SeleniumWebCheckBox extends SeleniumWebControls implements ICheckBox {
	
	public SeleniumWebCheckBox(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
	}
	
	
	public void Check()
    {
        if(!getIsChecked())
        {
            WebElement.click();
        }
    }       
}
