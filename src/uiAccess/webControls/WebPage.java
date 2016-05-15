package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IPage;

public class WebPage extends WebControl
{
    public WebPage(Browser aBrowser, Locator aLocator){
        super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Page)}
    { }

    private IPage getPage()
    {
       
            return (IPage)Control;
        
    }
}
