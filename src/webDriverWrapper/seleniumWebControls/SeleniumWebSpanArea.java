package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.ISpanArea;

public class SeleniumWebSpanArea extends SeleniumWebControls implements ISpanArea {
	
	public SeleniumWebSpanArea(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	
         this.aControlAccess = access;
     }

     /// <summary>
     /// Gets all rows.
     /// </summary>
     /// <returns></returns>
     public ReadOnlyCollection<SeleniumWebRow> GetAllRows()
     {
         return Utility.GetControlsFromWebElements(aWebElement.FindElements(By.TagName("tr")), ControlType.WebRow, controlAccess).Cast<SeleniumWebRow>().ToList().AsReadOnly();
     }

}
