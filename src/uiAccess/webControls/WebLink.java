package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ILink;

public class WebLink extends WebControl
{
    public WebLink(Browser Browser, Locator Locator){
        super(Browser,Locator.LocatorType, Locator.ControlLocator, ControlType.Link);
     }

    @SuppressWarnings("unused")
	private ILink getLink()
    {
            return (ILink)Control;
        
    }
}
