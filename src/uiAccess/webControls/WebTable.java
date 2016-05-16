package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IWebTable;

public class WebTable extends WebControl{
    private Browser browser;
    private Locator locator;

    public WebTable(Browser Browser, Locator Locator){
        super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.WebTable)}
    {
        browser = Browser;
        locator = Locator;
    }

    private IWebTable getWebTables()   {
            return (IWebTable)Control;
    }

    public ReadOnlyCollection<WebRow> getGetRows()
    { 
        return Utility.GetWebControlsFromIControlList(WebTables.GetAllRows().Cast<IControl>().ToList(), browser, locator, ControlType.WebRow).Cast<WebRow>().ToList().AsReadOnly();
            }

    public WebRow GetRowWithValue(String value)
    {
        for(WebRow row : GetRows)
        {
            if(row.getText().equals(value))
            {
                return row;
            }
        }
        return null;
    }
}