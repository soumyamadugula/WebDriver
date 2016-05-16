package webDriverWrapper.iControlHierarchy;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import org.openqa.selenium.Keys;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.LocatorType;
import webDriverWrapper.Drivers.Browser;

public interface IControl {
	boolean getEnabled();

    Point getClickablePoint();

    Rectangle getBoundingRectangle();

    Image getControlImage();

    boolean getVisible();

    String getText();

    boolean getIsChecked();

    String getTagName();

    IControl getParent();

    Point ScrollToElement();

    List<IControl> GetChildren(String Locator, LocatorType aLocatorType, ControlType aControlType, ControlAccess access);

   public void Highlight(Browser aBrowser);

  public  void Click();

  public  void Submit();

  public void SendKeys(Keys down);

  public  void DesktopMouseClick();

  public  void DesktopMouseClick(int offsetX, int offsetY);

  public void DesktopMouseDrag(int offsetX, int offsetY);

    String GetAttributeFromNode(String Attribute);

    Object ExecuteJavaScript(Browser aBrowser, String JavaScript);

    Object InjectJSInBrowser(Browser aBrowser, String JavaScript);

    boolean HasChildren();

    boolean HasChildrenWithXpath(String xpath);

    List<IControl> WaitForChildren(int maxTimeout);

    List<IControl> WaitForChildren(String xpath, int maxTimeout);

    String InnerHtml(Browser aBrowser);

    String OuterHtml(Browser aBrowser);

}
