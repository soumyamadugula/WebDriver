
package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.LocatorType;
import webDriverWrapper.Utility;
import webDriverWrapper.iControlHierarchy.ICalender;

public class SeleniumWebCalender extends SeleniumWebControls implements ICalender{
	
	public SeleniumWebCalender(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
			this.aControlAccess = access;
     }


     //public ReadOnlyCollection<SeleniumWebButton> MoveToNextMonth()
     //{
     //    return Utility.GetControlsFromWebElements(aWebElement.findElements(By.TagName("a")), ControlType.Button, controlAccess).Cast<SeleniumWebButton>().ToList().AsReadOnly();
     //}

     public SeleniumWebControls GetCalenderHeader(String locator, LocatorType locatorType)
     {
         switch(locatorType)
         {
             case ClassName:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.className(locator)), ControlType.Custom, aControlAccess);

             case Css:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.cssSelector(locator)), ControlType.Custom, aControlAccess);

             case Id:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.id(locator)), ControlType.Custom, aControlAccess);

             case LinkText:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.linkText(locator)), ControlType.Custom, aControlAccess);

             case Name:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.name(locator)), ControlType.Custom, aControlAccess);

             case PartialLinkText:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.partialLinkText(locator)), ControlType.Custom, aControlAccess);

             case Xpath:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.xpath(locator)), ControlType.Custom, aControlAccess);

             default:
                 return (SeleniumWebControls)Utility.GetControlFromWebElement(aWebElement.findElement(By.tagName(locator)), ControlType.Custom, aControlAccess);
                            
         }
     }


     public SeleniumWebControls GetMonthAndYear(String locator, LocatorType locatorType, String headerLocator, LocatorType headerLocatorType)
     {

         return (SeleniumWebControls)Utility.GetControlFromWebElement(GetCalenderHeader(headerLocator, headerLocatorType).aWebElement.findElement(By.className(locator)), ControlType.Custom, aControlAccess);
     }
 
}
