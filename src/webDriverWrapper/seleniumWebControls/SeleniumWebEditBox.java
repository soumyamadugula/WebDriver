package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IEditBox;

public class SeleniumWebEditBox extends SeleniumWebControls implements IEditBox {
	
	public SeleniumWebEditBox(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	}
	 public void JSSendKeys(String aText)
     {
         switch (aControlAccess.getLocatorType())
         {
             case Id:
                 ExecuteJavaScript(aControlAccess.getBrowser(), String.format("document.getElementById('{0}').value='{1}'", aControlAccess.getLocator(), aText));
                 break;

             case Name:
                 ExecuteJavaScript(aControlAccess.getBrowser(), String.format("document.getElementsByName('{0}')[0].value='{0}'", aControlAccess.getLocator(), aText));
                 break;

             case ClassName:
                 ExecuteJavaScript(aControlAccess.getBrowser(), String.format("document.getElementsByClassName('{0}')[0].value='{0}'", aControlAccess.getLocator(), aText));
                 break;

             case PartialLinkText:
                 break;
             case TagName:
                 ExecuteJavaScript(aControlAccess.getBrowser(), String.format("document.getElementsByTagName('{0}')[0].value='{0}'", aControlAccess.getLocator(), aText));
                 break;

             default:
                 ExecuteJavaScript(aControlAccess.getBrowser(), String.format("document.getElementById('{0}').value='{0}'", aControlAccess.getLocator(), aText));
                 break;
         }

     }


     public void Clear()
     {
         aWebElement.clear();
     }
}

