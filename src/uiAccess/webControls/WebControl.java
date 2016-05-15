package uiAccess.webControls;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import uiAccess.Utility;
import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.LocatorType;
import webDriverWrapper.iControlHierarchy.IControl;

public class WebControl {
	 private ControlAccess myControlAccess;

      IControl Control;

     //private Browser myBrowser;

     //private LocatorType myLocatorType;

     //private String myLocator;

    ControlType myControlType;


     public WebControl(Browser aBrowser, LocatorType aLocatorType, String aLocator, ControlType aControlType)
     {
         myControlAccess = new ControlAccess();
         myControlAccess.Browser = aBrowser;
         myControlAccess.LocatorType = aLocatorType;
         myControlAccess.Locator = aLocator;
         myControlAccess.ControlType = aControlType;
         myControlAccess.IntializeControlAccess();
         //Control = myControlAccess.GetControl();
     }

     public WebControl(Browser aBrowser, Locator aLocator)
     {
         myControlAccess = new ControlAccess();
         myControlAccess.Browser = aBrowser;
         myControlAccess.LocatorType = aLocator.LocatorType;
         myControlAccess.Locator = aLocator.ControlLocator;
         myControlAccess.ControlType = ControlType.Custom;
         myControlAccess.IntializeControlAccess();
         //Control = myControlAccess.GetControl();
     }


     public boolean getEnabled()
     {
         
             return Control.Enabled;
         

     }

     public Rectangle getBoundingRectangle()
     {
          return Control.BoundingRectangle;
     }

     public Image getScreenImage()
     {
        
             return Control.GetControlImage;
         
     }

     public Point getClickablePoint()
     {
          return Control.ClickablePoint; 
     }

     public boolean getVisible()
     {
          return Control.Visible; 

     }

     public String getText()
     {
          return Control.Text; 
     }

     public String getInnerHtml()
     {
         
             return Control.InnerHtml(myControlAccess.Browser);
         
     }

     public String getOuterHtml()
     {
         
         
             return Control.OuterHtml(myControlAccess.Browser);
         
     }

     public booleanean getIsChecked()
     {
          return Control.IsChecked; 
     }

     public String getTagName()
     {
         return Control.TagName; 
     }

     public Actions getAction()
     {
                 
             return new Actions(myControlAccess);
         

     }

     public IControl getSeleniumControl()
     {
         
             return Control;
         
     }

     public Point ScrollToElement()
     {
         return Control.ScrollToElement();
     }

     public boolean IsControlPresent()
     {
         return myControlAccess.IsElementPresent();
     }

     public void GetControl()
     {
         Control = myControlAccess.GetControl();
     }

     public ReadOnlyCollection<IControl> GetControls()
     {
         return myControlAccess.GetControls();
     }

     public List<WebControl> GetChildren(Locator aLocator, ControlType aControlType)
     {
         List<IControl> aIControlList = new List<IControl>();
         aIControlList = myControlAccess.GetChildren(aLocator.ControlLocator, aLocator.LocatorType, aControlType);

         return Utility.GetWebControlsFromIControlList(aIControlList, myControlAccess.Browser, aLocator, aControlType);
     }

     public void Highlight()
     {
         Control.Highlight(myControlAccess.Browser);
     }

     public void ClickAt()
     {
         myControlAccess.ClickAt();
     }

     public void Click()
     {
         Control.ExecuteJavaScript(myControlAccess.Browser, "arguments[0].hidden = false");
         Control.Click();
     }

     public void Submit()
     {
         Control.Submit();
     }

     public void SendKeys(String keys)
     {
         Control.SendKeys(keys);
     }


     public void DesktopMouseClick()
     {
         Control.DesktopMouseClick();
     }

     public void JSClick()
     {
         Executejavascript("arguments[0].click();");
     }

     public void DesktopMouseClick(int offsetX, int offsetY)
     {
         Control.DesktopMouseClick(offsetX, offsetY);
     }

     public void DesktopMouseDrag(int offsetX, int offsetY)
     {
         Control.DesktopMouseDrag(offsetX, offsetY);
     }

     public String GetAttribute(String AttributeName)
     {
         return Control.GetAttributeFromNode(AttributeName);
     }

     public Dictionary<String, Object> GetAttributes()
     {
         return (Dictionary<String, Object>)Executejavascript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;");
     }

     public Object Executejavascript(String JavaScript)
     {
         return Control.ExecuteJavaScript(myControlAccess.Browser, JavaScript);
     }

     public Object InjectJSInBrowser(String JavaScript)
     {
         return Control.InjectJSInBrowser(myControlAccess.Browser, JavaScript);
     }

     public boolean HasChildren()
     {
         return Control.HasChildren();
     }

     public boolean HasChildrenWithXpath(String xpath)
     {
         return Control.HasChildrenWithXpath(xpath);
     }

     public List<WebControl> WaitForChildren(int maxTimeout)
     {
         List<IControl> aIControlList = new ArrayList<IControl>();
         aIControlList = Control.WaitForChildren(maxTimeout);
         return Utility.GetWebControlsFromIControlList(aIControlList, myControlAccess.Browser, new Locator(".//*", LocatorType.Xpath), ControlType.Custom);
     }

     public List<WebControl> WaitForChildren(String xpath, int maxTimeout)
     {
         List<IControl> aIControlList = new ArrayList<IControl>();
         aIControlList = Control.WaitForChildren(xpath, maxTimeout);
         return Utility.GetWebControlsFromIControlList(aIControlList, myControlAccess.Browser, new Locator(xpath, LocatorType.Xpath), ControlType.Custom);
     }


 
}


