package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IWebRow;

public class WebRow extends  WebControl
{
    private Browser browser;
    private Locator locator;

    public WebRow(Browser aBrowser, Locator aLocator){
        super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.WebRow)}
    {
        browser = aBrowser;
        locator = aLocator;
    }
    private IWebRow getWebRows()
    {
      
            return (IWebRow)Control;
      }
    public ReadOnlyCollection<WebCell> getGetCells()
    {
            return Utility.GetWebControlsFromIControlList(WebRows.GetAllCells().Cast<IControl>().ToList(), browser, locator, ControlType.WebCell).Cast<WebCell>().ToList().AsReadOnly();
   }
}