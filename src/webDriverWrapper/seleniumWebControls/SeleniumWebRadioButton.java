package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IRadioButton;

public class SeleniumWebRadioButton extends SeleniumWebControls implements IRadioButton{
	public SeleniumWebRadioButton(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
	}

	@Override
	public void Check() {
		// TODO Auto-generated method stub
		
		if (!getIsChecked())
        {
            WebElement.click();
        }
		
	}
}
