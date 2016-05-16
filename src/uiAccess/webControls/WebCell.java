package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;

public class WebCell extends WebControl {
         public WebCell(Browser Browser, Locator Locator){
            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.WebCell);}
       

}
