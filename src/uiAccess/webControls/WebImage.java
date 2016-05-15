package uiAccess.webControls;

import webDriverWrapper.iControlHierarchy.IImage;

public class WebImage extends WebControl {


        public WebImage(Browser aBrowser, Locator aLocator){
            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Image)}
        { }

        private IImage getImage()
            {
                return (IImage)Control;
            }
       }
