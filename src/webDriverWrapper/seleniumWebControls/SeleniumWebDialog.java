package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IDialog;

public class SeleniumWebDialog extends SeleniumWebControls implements IDialog {
	
	public SeleniumWebDialog(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
	}
	WebDriver webDriver = new FirefoxDriver();
	   public String getTitle()
       {
           throw new UnsupportedOperationException();
       }

       public void AcceptDialog()
       {
           ControlAccess.Actions.WebDriver.SwitchTo().Alert().Accept();
       }

       public void CancelDialog()
       {
           ControlAccess.getAction().WebDriver.SwitchTo().Alert().Dismiss();
       }
   
       public String GetDialogText()
       {
          return ControlAccess.getAction().webDriver.SwitchTo().Alert().Text;
       }

       public void SendText(String text)
       {
           ControlAccess.getAction().webDriver.SwitchTo().Alert().SendKeys(text);
       }                   

}
