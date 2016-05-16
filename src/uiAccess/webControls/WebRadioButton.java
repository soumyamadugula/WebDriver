package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IRadioButton;

public class WebRadioButton extends WebControl
	    {
	        public WebRadioButton(Browser Browser, Locator Locator){
	            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.RadioButton);}
	         

	        @SuppressWarnings("unused")
			private IRadioButton getRadioButton()
	        {
	                return (IRadioButton)Control;
	           
	        }

}
