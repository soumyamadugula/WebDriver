package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IListBox;

public class WebListBox extends WebControl
{
    public WebListBox(Browser aBrowser, Locator aLocator){
        super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.ListBox)}
    { }

    private IListBox getListBox()
    {
        
            return (IListBox)Control;
        
    }
}

