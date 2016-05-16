package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ICheckBox;

public class WebCheckBox extends WebControl {
	 public WebCheckBox(Browser Browser, Locator Locator){
     super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.CheckBox);}
 { }

 private ICheckBox getCheckBox()
 {
     
     
         return (ICheckBox)Control;
     
 }

 public void Check()
 {
	 this.getCheckBox().Check();
 }
         

}


