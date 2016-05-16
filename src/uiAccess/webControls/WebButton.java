package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IButton;

public class WebButton extends WebControl {
        public WebButton(Browser Browser, Locator Locator ) {
            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.Button);
         }

        private IButton getButton()
        {
           
                return (IButton)Control;
            
        }

        public void Click()
        {
        	 this.getButton().Click();
        }
}
