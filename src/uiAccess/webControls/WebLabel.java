package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ILabel;

public class WebLabel extends WebControl{

        public WebLabel(Browser aBrowser, Locator aLocator){
            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Label)}
        { }

        private ILabel getLabel()
        {
                return (ILabel)Control;
            
}

}
