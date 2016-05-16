package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IImage;

public class WebImage extends WebControl {


        public WebImage(Browser Browser, Locator Locator){
            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.Image);}
        { }

        @SuppressWarnings("unused")
		private IImage getImage()
            {
                return (IImage)Control;
            }
       }
