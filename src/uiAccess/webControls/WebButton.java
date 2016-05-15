package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IButton;

public class WebButton extends WebControl {
        public WebButton(Browser aBrowser, Locator aLocator ) {
            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Button) }
        { }

        private IButton getButton()
        {
           
                return (IButton)Control;
            
        }

        public void Click()
        {
            Button.Click();
        }

    }
}
}
