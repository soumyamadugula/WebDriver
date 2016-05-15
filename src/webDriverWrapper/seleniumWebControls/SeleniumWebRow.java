package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IWebRow;

public class SeleniumWebRow extends SeleniumWebControls implements IWebRow {
	
	public SeleniumWebRow(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	
	
        this.aControlAccess = access;
    }

    //public ReadOnlyCollection<IWebElement> GetCells()
    //{
    //    return aWebElement.FindElements(By.TagName("td"));
    //}

    

    public ReadOnlyCollection<SeleniumWebCell> GetAllCells()
    {
        return Utility.GetControlsFromWebElements(aWebElement.FindElements(By.TagName("td")), ControlType.WebCell, controlAccess).Cast<SeleniumWebCell>().ToList().AsReadOnly();
    }

}
