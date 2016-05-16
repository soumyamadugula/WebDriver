
package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.LocatorType;
import webDriverWrapper.Utility;
import webDriverWrapper.iControlHierarchy.ICalender;

public class SeleniumWebCalender extends SeleniumWebControls implements ICalender{
	
	public SeleniumWebCalender(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
			this.ControlAccess = access;
     }


     //public ReadOnlyCollection<SeleniumWebButton> MoveToNextMonth()
     //{
     //    return Utility.GetControlsFromWebElements(WebElement.findElements(By.TagName("a")), ControlType.Button, controlAccess).Cast<SeleniumWebButton>().ToList().AsReadOnly();
     //}

     public SeleniumWebControls GetCalenderHeader(String locator, LocatorType locatorType)
     {
         switch(locatorType)
         {
             case ClassName:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.className(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             case Css:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.cssSelector(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             case Id:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.id(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             case LinkText:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.linkText(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             case Name:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.name(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             case PartialLinkText:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.partialLinkText(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             case Xpath:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.xpath(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);

             default:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(WebElement.findElement(By.tagName(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);
                            
         }
     }


     public SeleniumWebControls GetMonthAndYear(String locator, LocatorType locatorType, String headerLocator, LocatorType headerLocatorType)
     {

         return (SeleniumWebControls)Utility.GetControlFromWebElement(GetCalenderHeader(headerLocator, headerLocatorType).WebElement.findElement(By.className(locator)), webDriverWrapper.ControlType.Custom, ControlAccess);
     }
 
}
