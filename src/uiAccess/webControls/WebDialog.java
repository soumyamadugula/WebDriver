package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IDialog;

public class WebDialog extends WebControl {
	
        public WebDialog(Browser Browser, Locator Locator){
            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.Dialog);}
        { }
   
        private IDialog getDialog()
        {
                return (IDialog)Control;
            
        }


        public void Test()
        {
        	this.getDialog().getTitle();
        }


        public void AcceptDialog()
        {
        	this.getDialog().AcceptDialog();
        }

        public void CancelDialog()
        {
        	this.getDialog().CancelDialog();
        }

        public String GetDialogText()
        {
            return this.getDialog().GetDialogText();
        }
        public void SendText(String value)
        {
        	this.getDialog().SendText(value);
        }

}
