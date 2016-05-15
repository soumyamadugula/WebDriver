package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IFrame;

public class WebFrame extends WebControl{
	
    
        public WebFrame(Browser aBrowser, Locator aLocator){
            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Frame)}
        { }

        private IFrame getFrame()
        {
           
           
                return (IFrame)Control;
           
        
    
}

}
