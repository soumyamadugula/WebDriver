package webDriverWrapper.seleniumWebControls;

import org.openqa.selenium.WebElement;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.ISpanArea;

public class SeleniumWebSpanArea extends SeleniumWebControls implements ISpanArea {
	
	public SeleniumWebSpanArea(WebElement WebElement, ControlType ControlType,
			ControlAccess access){super(WebElement,ControlType, access);
	
	
         this.ControlAccess = access;
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
