package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IRadioButton;

public class WebRadioButton extends WebControl
	    {
	        public WebRadioButton(Browser aBrowser, Locator aLocator){
	            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.RadioButton)}
	         

	        private IRadioButton getRadioButton()
	        {
	                return (IRadioButton)Control;
	           
	        }

}
