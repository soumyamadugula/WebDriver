package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IEditBox;

public class SeleniumWebEditBox extends SeleniumWebControls implements IEditBox {
	
	public SeleniumWebEditBox(WebElement aWebElement, ControlType ControlType,
			ControlAccess access){super(aWebElement, ControlType, access);
	
	}
	 public void JSSendKeys(String aText)
     {
         switch (ControlAccess.getLocatorType())
         {
             case Id:
                 ExecuteJavaScript(ControlAccess.getBrowser(), String.format("document.getElementById('{0}').value='{1}'", ControlAccess.getLocator(), aText));
                 break;

             case Name:
                 ExecuteJavaScript(ControlAccess.getBrowser(), String.format("document.getElementsByName('{0}')[0].value='{0}'", ControlAccess.getLocator(), aText));
                 break;

             case ClassName:
                 ExecuteJavaScript(ControlAccess.getBrowser(), String.format("document.getElementsByClassName('{0}')[0].value='{0}'", ControlAccess.getLocator(), aText));
                 break;

             case PartialLinkText:
                 break;
             case TagName:
                 ExecuteJavaScript(ControlAccess.getBrowser(), String.format("document.getElementsByTagName('{0}')[0].value='{0}'", ControlAccess.getLocator(), aText));
                 break;

             default:
                 ExecuteJavaScript(ControlAccess.getBrowser(), String.format("document.getElementById('{0}').value='{0}'", ControlAccess.getLocator(), aText));
                 break;
         }

     }


     public void Clear()
     {
         WebElement.clear();
     }
}

