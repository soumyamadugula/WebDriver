package uiAccess.webControls;

import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ICheckBox;

public class WebCheckBox {
	 public WebCheckBox(Browser aBrowser, Locator aLocator){
     super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.CheckBox)}
 { }

 private ICheckBox getCheckBox()
 {
     
     
         return (ICheckBox)Control;
     
 }

 public void Check()
 {
     CheckBox.Check();
 }
         

}


