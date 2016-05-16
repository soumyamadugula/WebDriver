package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IListBox;

public class WebListBox extends WebControl
{
    public WebListBox(Browser Browser, Locator Locator){
        super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.ListBox);}
    { }

    @SuppressWarnings("unused")
	private IListBox getListBox()
    {
        
            return (IListBox)Control;
        
    }
}

