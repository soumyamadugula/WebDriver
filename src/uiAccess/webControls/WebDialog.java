package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IDialog;

public class WebDialog extends WebControl {
	
        public WebDialog(Browser aBrowser, Locator aLocator){
            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Dialog)}
        { }
   
        private IDialog getDialog()
        {
                return (IDialog)Control;
            
        }


        public void Test()
        {
            Dialog.getTitle();
        }


        public void AcceptDialog()
        {
            Dialog.AcceptDialog();
        }

        public void CancelDialog()
        {
            Dialog.CancelDialog();
        }

        public String GetDialogText()
        {
            return Dialog.GetDialogText();
        }
        public void SendText(String value)
        {
            Dialog.SendText(value);
        }

}
