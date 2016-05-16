package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IEditBox;

public class WebEditBox extends WebControl {
	
        public WebEditBox(Browser Browser, Locator Locator){
            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.EditBox);}
        { }

        private IEditBox getEditBox()
        {
            
                            return (IEditBox)Control;
            
        }

        /// <summary>
        /// Works only for Id, Name, ClassName and TagName , for any other locator type default Id is used
        /// </summary>
        /// <param name="Text"></param>
        public void JSSendKeys(String Text)
        {
        	 this.getEditBox().JSSendKeys(Text);            
        }

        public void Clear()
        {
        	this.getEditBox().Clear();
        }

     
}


