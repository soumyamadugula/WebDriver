package webDriverWrapper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webDriverWrapper.iControlHierarchy.IControl;
import webDriverWrapper.seleniumWebControls.SeleniumWebButton;
import webDriverWrapper.seleniumWebControls.SeleniumWebCalender;
import webDriverWrapper.seleniumWebControls.SeleniumWebCell;
import webDriverWrapper.seleniumWebControls.SeleniumWebCheckBox;
import webDriverWrapper.seleniumWebControls.SeleniumWebComboBox;
import webDriverWrapper.seleniumWebControls.SeleniumWebControls;
import webDriverWrapper.seleniumWebControls.SeleniumWebDialog;
import webDriverWrapper.seleniumWebControls.SeleniumWebEditBox;
import webDriverWrapper.seleniumWebControls.SeleniumWebFrame;
import webDriverWrapper.seleniumWebControls.SeleniumWebImage;
import webDriverWrapper.seleniumWebControls.SeleniumWebLabel;
import webDriverWrapper.seleniumWebControls.SeleniumWebLink;
import webDriverWrapper.seleniumWebControls.SeleniumWebListBox;
import webDriverWrapper.seleniumWebControls.SeleniumWebPage;
import webDriverWrapper.seleniumWebControls.SeleniumWebRadioButton;
import webDriverWrapper.seleniumWebControls.SeleniumWebRow;
import webDriverWrapper.seleniumWebControls.SeleniumWebSpanArea;
import webDriverWrapper.seleniumWebControls.SeleniumWebTable;

public class Utility {
	  public static IControl GetControlFromWebElement(WebElement aWebElement, ControlType aControlType, ControlAccess access)
      {
          if (aControlType == ControlType.Button)
          {
              return new SeleniumWebButton(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.EditBox)
          {
              return new SeleniumWebEditBox(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Calender)
          {
              return new SeleniumWebCalender(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Custom)
          {
              return new SeleniumWebControls(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.ComboBox)
          {
              return new SeleniumWebComboBox(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.CheckBox)
          {
              return new SeleniumWebCheckBox(aWebElement, aControlType,access);
          }

          if (aControlType == ControlType.Dialog)
          {
              return new SeleniumWebDialog(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Frame)
          {
              return new SeleniumWebFrame(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Image)
          {
              return new SeleniumWebImage(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Label)
          {
              return new SeleniumWebLabel(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Link)
          {
              return new SeleniumWebLink(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.ListBox)
          {
              return new SeleniumWebListBox(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.Page)
          {
              return new SeleniumWebPage(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.RadioButton)
          {
              return new SeleniumWebRadioButton(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.SpanArea)
          {
              return new SeleniumWebSpanArea(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.WebTable)
          {
              return new SeleniumWebTable(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.WebRow)
          {
              return new SeleniumWebRow(aWebElement, aControlType, access);
          }

          if (aControlType == ControlType.WebCell)
          {
              return new SeleniumWebCell(aWebElement, aControlType, access);
          }

          else return null;
      }

      @SuppressWarnings("unchecked")
	public
	static List<IControl> GetChildren(String Locator, LocatorType aLocatorType, ControlType aControlType, WebElement aWebElement, ControlAccess access)
      {
          if (aLocatorType == LocatorType.Id)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.id(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.Name)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.name(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.TagName)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.tagName(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.Xpath)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.xpath(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.ClassName)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.className(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.Css)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.cssSelector(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.LinkText)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.linkText(Locator)), aControlType, access);
          }

          if (aLocatorType == LocatorType.PartialLinkText)
          {
              return Utility.GetControlsFromWebElements((Iterable<WebElement>) aWebElement.findElement(By.linkText(Locator)), aControlType, access);
          }

          else return null;
      }

      static List<IControl> GetControlsFromWebElements(Iterable<WebElement> aWebElements, ControlType aControlType, ControlAccess access)
      {
          List<IControl> aControl = new ArrayList<IControl>();

          for (WebElement aWebElement : aWebElements)
          {
              if (aControlType == ControlType.Button)
              {
                  aControl.add(new SeleniumWebButton(aWebElement, aControlType,access));
              }

              if (aControlType == ControlType.EditBox)
              {
                  aControl.add(new SeleniumWebEditBox(aWebElement, aControlType, access));
              }
              
               if (aControlType == ControlType.Custom)
              {
                  aControl.add(new SeleniumWebControls(aWebElement, aControlType, access));
              }

               if (aControlType == ControlType.Calender)
               {
                   aControl.add(new SeleniumWebCalender(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.ComboBox)
               {
                   aControl.add(new SeleniumWebComboBox(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.CheckBox)
               {
                   aControl.add(new SeleniumWebCheckBox(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.Dialog)
               {
                   aControl.add(new SeleniumWebDialog(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.Frame)
               {
                   aControl.add(new SeleniumWebFrame(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.Image)
               {
                   aControl.add(new SeleniumWebImage(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.Label)
               {
                   aControl.add(new SeleniumWebLabel(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.Link)
               {
                   aControl.add(new SeleniumWebLink(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.ListBox)
               {
                   aControl.add(new SeleniumWebListBox(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.Page)
               {
                   aControl.add(new SeleniumWebPage(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.RadioButton)
               {
                   aControl.add(new SeleniumWebRadioButton(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.SpanArea)
               {
                   aControl.add(new SeleniumWebSpanArea(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.WebTable)
               {
                   aControl.add(new SeleniumWebTable(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.WebRow)
               {
                   aControl.add(new SeleniumWebRow(aWebElement, aControlType, access));
               }

               if (aControlType == ControlType.WebCell)
               {
                   aControl.add(new SeleniumWebCell(aWebElement, aControlType, access));
               }

          }

          return aControl;
      }

      public static By GetByFromLocator(LocatorType locatorType, String locator)
      {
          switch (locatorType)
          {
              case ClassName:
                  return By.className(locator);

              case Css:
                  return By.cssSelector(locator);

              case Id:
                  return By.id(locator);

              case LinkText:
                  return By.linkText(locator);

              case Name:
                  return By.name(locator);

              case PartialLinkText:
                  return By.partialLinkText(locator);

              case TagName:
                  return By.tagName(locator);

              case Xpath:
                  return By.xpath(locator);

              default:
                  return By.xpath(locator);
          }
      }
  

}
