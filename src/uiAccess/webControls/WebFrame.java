package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IFrame;

public class WebFrame extends WebControl{
	
    
        public WebFrame(Browser Browser, Locator Locator){
            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.Frame);}
        { }

        @SuppressWarnings("unused")
		private IFrame getFrame()
        {
           
           
                return (IFrame)Control;
           
        
    
}

}
