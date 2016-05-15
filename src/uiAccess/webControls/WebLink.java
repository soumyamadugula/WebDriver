package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ILink;

public class WebLink extends WebControl
{
    public WebLink(Browser aBrowser, Locator aLocator){
        super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Link)
     }

    private ILink getLink()
    {
            return (ILink)Control;
        
    }
}
