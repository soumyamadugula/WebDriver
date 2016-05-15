package webDriverWrapper.iControlHierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import webDriverWrapper.seleniumWebControls.SeleniumWebRow;

public interface IWebTable extends IControl {
	  List<SeleniumWebRow> seleniumwebrows = new ArrayList<SeleniumWebRow>();
	  
	  @SuppressWarnings("static-access")
	default List<SeleniumWebRow> GetAllRows()
	   {
		   return Collections.unmodifiableList(this.seleniumwebrows);
	   }
}
