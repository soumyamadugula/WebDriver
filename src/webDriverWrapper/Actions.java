package webDriverWrapper;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IControl;
import webDriverWrapper.seleniumWebControls.SeleniumWebControls;

public class SeleniumActions {
	
	WebDriver webdriver;
	static WebElement webelement;

	 public WebDriver getWebDriver()
	 {
		 return this.webdriver;
	 }
	 
	 public void setWebDriver(WebDriver webdriver)
	 {
		 this.webdriver = webdriver;
	 }
     
     public WebElement getWebElement()
	 {
    	 return this.webelement;
	 }
	 
	 public void setWebElement(WebElement webelement)
	 {
		 this.webelement = webelement;
	 }
     private Actions getSeleniumSeleniumActions()
     {
         
     }
     private Actions getSeleniumActions()
     {
             return Actions(WebDriver);
         
     }

     public SeleniumActions(Browser browser, SeleniumWebControls control)
     {
    	 WebDriver WebDriver = browser.BrowserHandle;
    	 WebElement WebElement = control.aWebElement;
     }

     public SeleniumActions(WebDriver webdriver, WebElement webElement)
     {
    	 WebDriver WebDriver = webdriver;
         WebElement WebElement = webElement;
     }

     public static void MoveToElement(WebElement WebElement)
     {
         //Thread.Sleep(10000);
         SeleniumActions.MoveToElement((WebElement.aWebElement).Build().Perform();
         //Thread.Sleep(10000);
         //element.Click().Build().Perform();
     }

     public static void MoveToElement(int offSetX, int offSetY)
     {
         Actions.moveToElement(webelement, offSetX, offSetY).Build().Perform();
     }

     public void DragDrop(IControl target)
     {
         SeleniumActions.DragAndDrop(webelement, ((SeleniumWebControls)target).aWebElement).Build().Perform();
     }

     public void DragDropToOffset(int offSetX, int offSetY)
     {
         SeleniumActions.DragAndDropToOffset(webelement, offSetX, offSetY).Build().Perform();
     }

     public void NativeSelect(IControl WebElement)
     {
         SeleniumActions.MoveToElement(((SeleniumWebControls)WebElement).aWebElement).Click().Build().Perform();
     }
     public void SendKeys(String keys)
     {
         SeleniumActions.SendKeys(keys);

     }

     public void SendKeys(IControl WebElement, String keys)
     {
         SeleniumActions.SendKeys(((SeleniumWebControls)WebElement).aWebElement, keys);
     }

     public void ClickAndHold()
     {
         SeleniumActions.ClickAndHold(WebElement).Build().Perform();
     }

     public void ClickAndHold(IControl WebElement)
     {
         SeleniumActions.ClickAndHold(((SeleniumWebControls)WebElement).aWebElement).Build().Perform();
     }

     public void MoveByOffset(int xOffset, int yOffset)
     {
         SeleniumActions.MoveByOffset(xOffset, yOffset).Build().Perform();

     }
 }
}

}
