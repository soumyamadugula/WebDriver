package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IWebRow;

public class WebRow extends  WebControl
{
    private Browser browser;
    private Locator locator;

    public WebRow(Browser Browser, Locator Locator){
        super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.WebRow);}
    {
        browser = Browser;
        locator = Locator;
    }
    private IWebRow getWebRows()
    {
      
            return (IWebRow)Control;
      }
    public ReadOnlyCollection<WebCell> getGetCells()
    {
            return Utility.GetWebControlsFromIControlList(this.getWebRows().GetAllCells().Cast<IControl>().ToList(), this.getbrowser(), this.getlocator(), ControlType.WebCell).Cast<WebCell>().ToList().AsReadOnly();
   }
}