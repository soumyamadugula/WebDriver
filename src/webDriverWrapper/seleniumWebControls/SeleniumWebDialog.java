package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IDialog;

public class SeleniumWebDialog extends SeleniumWebControls implements IDialog {
	
	public SeleniumWebDialog(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	}
	WebDriver webDriver = new FirefoxDriver();
	   public String getTitle()
       {
           throw new UnsupportedOperationException();
       }

       public void AcceptDialog()
       {
           aControlAccess.getAction().WebDriver.SwitchTo().Alert().Accept();
       }

       public void CancelDialog()
       {
           aControlAccess.getAction().WebDriver.SwitchTo().Alert().Dismiss();
       }
   
       public String GetDialogText()
       {
          return aControlAccess.getAction().webDriver.SwitchTo().Alert().Text;
       }

       public void SendText(String text)
       {
           aControlAccess.getAction().webDriver.SwitchTo().Alert().SendKeys(text);
       }                   

}
