package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IPage;

public class WebPage extends WebControl
{
    public WebPage(Browser Browser, Locator Locator){
        super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.Page);}
    { }

    @SuppressWarnings("unused")
	private IPage getPage()
    {
       
            return (IPage)Control;
        
    }
}
