package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ISpanArea;

public class WebSpanArea extends WebControl
{
    public WebSpanArea(Browser aBrowser, Locator aLocator){
        super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.SpanArea)}
    { }

    private ISpanArea getSpanArea()
    {
            return (ISpanArea)Control;
        }
    }