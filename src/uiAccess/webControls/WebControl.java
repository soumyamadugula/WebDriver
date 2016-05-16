package uiAccess.webControls;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.openqa.selenium.Keys;

import uiAccess.Actions;
import uiAccess.Locator;
import uiAccess.Utility;
import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.LocatorType;
import webDriverWrapper.iControlHierarchy.IControl;

public class WebControl {
	 private ControlAccess myControlAccess;
	public static IControl Control;
	private IControl ControlType;

      public void getControl() {}
      @SuppressWarnings("static-access")
	public IControl setControl() {
		return this.Control;
				}

     //private Browser myBrowser;

     //private LocatorType myLocatorType;

     //private String myLocator;

   public void getmyControlType(){}
   public IControl setmyControlType() {
		return this.ControlType;
				}

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
         myControlAccess.ControlType = ControlType;
         myControlAccess.IntializeControlAccess();
         //Control = myControlAccess.GetControl();
     }


     public boolean getEnabled()
     {
         
             return Control.getEnabled();
         

     }

     public Rectangle getBoundingRectangle()
     {
          return Control.BoundingRectangle;
     }

     public Image getScreenImage()
     {
        
             return Control.getControlImage();
         
     }

     public Point getClickablePoint()
     {
          return Control.getClickablePoint(); 
     }

     public boolean getVisible()
     {
          return Control.getVisible(); 

     }

     public String getText()
     {
          return Control.getText(); 
     }

     public String getInnerHtml()
     {
         
             return Control.InnerHtml(myControlAccess.getBrowser());
         
     }

     public String getOuterHtml()
     {
         
         
             return Control.OuterHtml(myControlAccess.getBrowser());
         
     }

     public boolean getIsChecked()
     {
          return Control.getIsChecked(); 
     }

     public String getTagName()
     {
         return Control.getTagName(); 
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
         List<IControl> aIControlList = new ArrayList<IControl>();
         aIControlList = myControlAccess.GetChildren(aLocator.ControlLocator, aLocator.LocatorType, aControlType);

         return Utility.GetWebControlsFromIControlList(aIControlList, myControlAccess.getBrowser(), aLocator, aControlType);
     }

     public void Highlight()
     {
         Control.Highlight(myControlAccess.getBrowser());
     }

     public void ClickAt()
     {
         myControlAccess.ClickAt();
     }

     public void Click()
     {
         Control.ExecuteJavaScript(myControlAccess.getBrowser(), "arguments[0].hidden = false");
         Control.Click();
     }

     public void Submit()
     {
         Control.Submit();
     }

     public void SendKeys(Keys keys)
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

     @SuppressWarnings("unchecked")
	public Dictionary<String, Object> GetAttributes()
     {
         return (Dictionary<String, Object>)Executejavascript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;");
     }

     public Object Executejavascript(String JavaScript)
     {
         return Control.ExecuteJavaScript(myControlAccess.getBrowser(), JavaScript);
     }

     public Object InjectJSInBrowser(String JavaScript)
     {
         return Control.InjectJSInBrowser(myControlAccess.getBrowser(), JavaScript);
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
         return Utility.GetWebControlsFromIControlList(aIControlList, myControlAccess.getBrowser(), new Locator(".//*", LocatorType.Xpath), ControlType);
     }

     public List<WebControl> WaitForChildren(String xpath, int maxTimeout)
     {
         List<IControl> aIControlList = new ArrayList<IControl>();
         aIControlList = Control.WaitForChildren(xpath, maxTimeout);
         return Utility.GetWebControlsFromIControlList(aIControlList, myControlAccess.getBrowser(), new Locator(xpath, LocatorType.Xpath), ControlType);
     }


 
}


