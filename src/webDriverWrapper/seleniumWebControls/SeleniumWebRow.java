package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IWebRow;

public class SeleniumWebRow extends SeleniumWebControls implements IWebRow {
	
	public SeleniumWebRow(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement, ControlType, access);
	
	
	
        this.ControlAccess = access;
    }

    //public ReadOnlyCollection<IWebElement> GetCells()
    //{
    //    return WebElement.FindElements(By.TagName("td"));
    //}

    

    public ReadOnlyCollection<SeleniumWebCell> GetAllCells()
    {
        return Utility.GetControlsFromWebElements(WebElement.FindElements(By.TagName("td")), ControlType.WebCell, controlAccess).Cast<SeleniumWebCell>().ToList().AsReadOnly();
    }

}
