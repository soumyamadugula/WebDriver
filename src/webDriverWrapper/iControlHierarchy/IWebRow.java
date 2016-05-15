package webDriverWrapper.iControlHierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import webDriverWrapper.seleniumWebControls.SeleniumWebCell;

public interface IWebRow extends IControl {
	   List<SeleniumWebCell> seleniumwebcells = new ArrayList<SeleniumWebCell>();
	   
	   @SuppressWarnings("static-access")
	default List<SeleniumWebCell> GetAllCells()
	   {
		   return Collections.unmodifiableList(this.seleniumwebcells);
	   }
}
