package webDriverWrapper.seleniumWebControls;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.LocatorType;
import webDriverWrapper.Utility;
import webDriverWrapper.iControlHierarchy.IControl;

public class SeleniumWebControls implements IControl {

     protected ControlType aControlType;
      public WebElement aWebElement;
      ControlAccess aControlAccess;

     
     SeleniumWebControls(WebElement aWebElement, ControlType aControlType)
     {
         this.aWebElement = aWebElement;
         this.aControlType = aControlType;
     }

     public SeleniumWebControls(WebElement aWebElement, ControlType aControlType, ControlAccess access){
         super();
         this.aControlAccess = access;
     }

   
     public boolean getEnabled()
     {
         
             return aWebElement.isEnabled();

         
     }

     public Point getClickablePoint()
     {
         
             int X = BoundingRectangle.X + BoundingRectangle.Width / 2;
             int Y = BoundingRectangle.Y + 60 + BoundingRectangle.Height / 2;

             //System.Windows.Point
             return new Point(X, Y);
         
     }

     public Rectangle getBoundingRectangle()
     {
         
         
             return new Rectangle(ScrollToElement(), aWebElement.Size);
         
     }

     public Image getControlImage()
     {
      
      

             byte[] imageArray = ((ITakesScreenshot)aControlAccess.Browser.BrowserHandle).GetScreenshot().AsByteArray;
             byte[] ms = new MemoryStream(imageArray);
             return Image.FromStream(ms);
             //Rectangle controlBox = BoundingRectangle;
             //Bitmap bmpScreenCapture = new Bitmap(controlBox.Width, controlBox.Height);
             //using (Graphics g = Graphics.FromImage(bmpScreenCapture))
             //{
             //    g.CopyFromScreen(controlBox.X + controlBox.Width,
             //                     controlBox.Y + controlBox.Height,
             //                     controlBox.X,
             //                     controlBox.Y,
             //                     controlBox.Size
             //                     );
             //}

             // Bitmap bmpScreenCapture = new Bitmap(Screen.PrimaryScreen.Bounds.Width,
             //                             Screen.PrimaryScreen.Bounds.Height);

             // using (Graphics g = Graphics.FromImage(bmpScreenCapture))
             // {
             //     g.CopyFromScreen(Screen.PrimaryScreen.Bounds.X,
             //                         Screen.PrimaryScreen.Bounds.Y,
             //                         0, 0,
             //                         bmpScreenCapture.Size,
             //                         CopyPixelOperation.SourceCopy);
             // }

             //return bmpScreenCapture;
         }
     

     public boolean getVisible()
     {
         
         
             return aWebElement.isDisplayed();
         
     }

     public String getTagName()
     {
         
         
             return aWebElement.getTagName();
         
     }

     public IControl getParent()
     {
         
         
             return Utility.GetControlFromWebElement(aWebElement.findElement(By.xpath("./..")), ControlType.Custom, this.aControlAccess);
         
     }

     public String getText()
     {
         
         
             return aWebElement.getText();
         
     }

     public String OuterHtml(Browser aBrowser)
     {
         return (String)ExecuteJavaScript(aBrowser, "return arguments[0].outerHTML;");
     }

     public String InnerHtml(Browser aBrowser)
     {
         return (String)ExecuteJavaScript(aBrowser, "return arguments[0].innerHTML;");
     }

     public boolean getIsChecked()
     {
         
             return aWebElement.isSelected();
         
     }

     public Point ScrollToElement()
     {
         //return ((ILocatable)aWebElement).Coordinates.LocationOnScreen;
         //ExecuteJavaScript(aControlAccess.Browser, "arguments[0].scrollIntoView(true);");
         return ((RemoteWebElement)aWebElement).LocationOnScreenOnceScrolledIntoView;
     }

     public List<IControl> GetChildren(String Locator, LocatorType aLocatorType, ControlType aControlType, ControlAccess access)
     {
         return Utility.GetChildren(Locator, aLocatorType, aControlType, aWebElement, access);
     }

     private void WaitForVisible()
     {
         WebDriverWait wait = new WebDriverWait(aControlAccess.Browser.BrowserHandle, TimeSpan.FromMinutes(2));

         wait.Until(ExpectedConditions.ElementIsVisible(Utility.GetByFromLocator(aControlAccess.LocatorType, aControlAccess.Locator)));
     }

     public void Click()
     {
         WaitForVisible();
         aWebElement.click();
     }

     public void Submit()
     {
         WaitForVisible();
         aWebElement.submit();
     }

     public void DesktopMouseClick()
     {
         ScrollToElement();
         Win32.DeskTopMouseClick(this);
     }

     public void DesktopMouseClick(int offsetX, int offsetY)
     {
         ScrollToElement();
         Win32.DeskTopMouseClick(this, offsetX, offsetY);
     }

     public void DesktopMouseDrag(int offsetX, int offsetY)
     {
         //ScrollToElement();
         Win32.DeskTopMouseDrag(this, offsetX, offsetY);
     }

     public void SendKeys(String text)
     {
         WaitForVisible();
         aWebElement.sendKeys(text);
     }

     public void Highlight(Browser aBrowser)
     {
         IJavascriptExecutor aScriptExecutor = (IJavascriptExecutor)aBrowser.BrowserHandle;

         Object aStyle = aScriptExecutor.executeScript("arguments[0].getAttribute('style');", aWebElement);
         aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", aWebElement,
                                       "border: 4px solid red;");

         //for (int i = 0; i < 5; i++)
         //{
         //    //aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", aWebElement,"color: red; border: 4px solid red;");

         //    object aStyle = aScriptExecutor.executeScript("arguments[0].getAttribute('style');", aWebElement);
         //    aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", aWebElement,
         //                                  "border: 4px solid red;");
         //    //Thread.Sleep(50);

         //    //aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);",
         //    //    aWebElement, aStyle);
         //}
     }

     public Object ExecuteJavaScript(Browser aBrowser, String JavaScript)
     {
         JavascriptExecutor aScriptExecutor = (JavascriptExecutor)aBrowser.BrowserHandle;

         return aScriptExecutor.executeScript(JavaScript, aWebElement);

     }

     public Object InjectJSInBrowser(Browser aBrowser, String JavaScript)
     {
         JavascriptExecutor aScriptExecutor = (JavascriptExecutor)aBrowser.BrowserHandle;

         return aScriptExecutor.executeScript(JavaScript);
     }

     public String GetAttributeFromNode(String Attribute)
     {
         return aWebElement.getAttribute(Attribute);
     }


     public boolean HasChildren()
     {
         return GetChildren("//*", LocatorType.Xpath, ControlType.Custom, aControlAccess).Count() > 0;
     }

     public boolean HasChildrenWithXpath(String xpath)
     {
         return GetChildren(xpath, LocatorType.Xpath, ControlType.Custom, aControlAccess).Count() > 0;
     }

     public List<IControl> WaitForChildren(int maxTimeout)
     {
         Date start;
         double timeElapsed = 0;
         Select element = new Select(aWebElement);


         start = new Date();

         while (!HasChildren() && timeElapsed < maxTimeout)
         {
             timeElapsed = ((TimeSpan)(new Date() - start)).TotalMilliseconds;
         }

         return GetChildren(".//*", LocatorType.Xpath, ControlType.Custom, aControlAccess);
     }

     public List<IControl> WaitForChildren(String xpath, int maxTimeout)
     {
         Date start;
         double timeElapsed = 0;
         Select element = new Select(aWebElement);


         start = new Date();

         while (!HasChildren() && timeElapsed < maxTimeout)
         {
             timeElapsed = ((TimeSpan)(new Date() - start)).TotalMilliseconds;
         }

         return GetChildren(xpath, LocatorType.Xpath, ControlType.Custom, aControlAccess);
     }

}


