package webDriverWrapper.seleniumWebControls;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

     protected ControlType ControlType;
      public WebElement WebElement;
      ControlAccess ControlAccess;

     
     SeleniumWebControls(WebElement WebElement, ControlType ControlType)
     {
         this.WebElement = WebElement;
         this.ControlType = ControlType;
     }

     public SeleniumWebControls(WebElement WebElement, ControlType ControlType, ControlAccess access){
         super();
         this.ControlAccess = access;
     }

   
     public boolean getEnabled()
     {
         
             return WebElement.isEnabled();

         
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
         
         
             return new Rectangle(ScrollToElement(), WebElement.Size);
         
     }

     public Image getControlImage()
     {
      
      

             byte[] imageArray = ((ITakesScreenshot)ControlAccess.Browser.BrowserHandle).GetScreenshot().AsByteArray;
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
         
         
             return WebElement.isDisplayed();
         
     }

     public String getTagName()
     {
         
         
             return WebElement.getTagName();
         
     }

     public IControl getParent()
     {
         
         
             return Utility.GetControlFromWebElement(WebElement.findElement(By.xpath("./..")), webDriverWrapper.ControlType.Custom, this.ControlAccess);
         
     }

     public String getText()
     {
         
         
             return WebElement.getText();
         
     }

     public String OuterHtml(Browser Browser)
     {
         return (String)ExecuteJavaScript(Browser, "return arguments[0].outerHTML;");
     }

     public String InnerHtml(Browser Browser)
     {
         return (String)ExecuteJavaScript(Browser, "return arguments[0].innerHTML;");
     }

     public boolean getIsChecked()
     {
         
             return WebElement.isSelected();
         
     }

     public Point ScrollToElement()
     {
         //return ((ILocatable)WebElement).Coordinates.LocationOnScreen;
         //ExecuteJavaScript(ControlAccess.Browser, "arguments[0].scrollIntoView(true);");
         return ((RemoteWebElement)WebElement).LocationOnScreenOnceScrolledIntoView;
     }

     public List<IControl> GetChildren(String Locator, LocatorType aLocatorType, ControlType ControlType, ControlAccess access)
     {
         return Utility.GetChildren(Locator, aLocatorType, ControlType, WebElement, access);
     }

     private void WaitForVisible()
     {
         WebDriverWait wait = new WebDriverWait(ControlAccess.Browser.BrowserHandle, TimeSpan.FromMinutes(2));

         wait.Until(ExpectedConditions.ElementIsVisible(Utility.GetByFromLocator(ControlAccess.LocatorType, ControlAccess.Locator)));
     }

     public void Click()
     {
         WaitForVisible();
         WebElement.click();
     }

     public void Submit()
     {
         WaitForVisible();
         WebElement.submit();
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

    

     public void Highlight(Browser Browser)
     {
         JavascriptExecutor ScriptExecutor = (JavascriptExecutor)Browser.BrowserHandle;

         @SuppressWarnings("unused")
		Object Style = ScriptExecutor.executeScript("arguments[0].getAttribute('style');", WebElement);
         ScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", WebElement,
                                       "border: 4px solid red;");

         //for (int i = 0; i < 5; i++)
         //{
         //    //aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", WebElement,"color: red; border: 4px solid red;");

         //    object aStyle = aScriptExecutor.executeScript("arguments[0].getAttribute('style');", WebElement);
         //    aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", WebElement,
         //                                  "border: 4px solid red;");
         //    //Thread.Sleep(50);

         //    //aScriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);",
         //    //    WebElement, aStyle);
         //}
     }

     public Object ExecuteJavaScript(Browser Browser, String JavaScript)
     {
         JavascriptExecutor aScriptExecutor = (JavascriptExecutor)Browser.BrowserHandle;

         return aScriptExecutor.executeScript(JavaScript, WebElement);

     }

     public Object InjectJSInBrowser(Browser Browser, String JavaScript)
     {
         JavascriptExecutor aScriptExecutor = (JavascriptExecutor)Browser.BrowserHandle;

         return aScriptExecutor.executeScript(JavaScript);
     }

     public String GetAttributeFromNode(String Attribute)
     {
         return WebElement.getAttribute(Attribute);
     }


     public boolean HasChildren()
     {
         return GetChildren("//*", LocatorType.Xpath, webDriverWrapper.ControlType.Custom, ControlAccess).Count() > 0;
     }

     public boolean HasChildrenWithXpath(String xpath)
     {
         return GetChildren(xpath, LocatorType.Xpath, webDriverWrapper.ControlType.Custom, ControlAccess).Count() > 0;
     }

     public List<IControl> WaitForChildren(int maxTimeout)
     {
         Date start;
         double timeElapsed = 0;
         Select element = new Select(WebElement);


         start = new Date();

         while (!HasChildren() && timeElapsed < maxTimeout)
         {
             timeElapsed = ((TimeSpan)(new Date() - start)).TotalMilliseconds;
         }

         return GetChildren(".//*", LocatorType.Xpath, webDriverWrapper.ControlType.Custom, ControlAccess);
     }

     public List<IControl> WaitForChildren(String xpath, int maxTimeout)
     {
         Date start;
         double timeElapsed = 0;
         Select element = new Select(WebElement);


         start = new Date();

         while (!HasChildren() && timeElapsed < maxTimeout)
         {
             timeElapsed = ((TimeSpan)(new Date() - start)).TotalMilliseconds;
         }

         return GetChildren(xpath, LocatorType.Xpath, webDriverWrapper.ControlType.Custom, ControlAccess);
     }

	@Override
	public void SendKeys(Keys text) {
		 
	         WaitForVisible();
	         WebElement.sendKeys(text);
	     }
		
	}



