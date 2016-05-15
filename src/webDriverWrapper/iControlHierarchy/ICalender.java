package webDriverWrapper.iControlHierarchy;

import webDriverWrapper.LocatorType;
import webDriverWrapper.seleniumWebControls.SeleniumWebControls;

public interface ICalender extends IControl{
	 SeleniumWebControls GetCalenderHeader(String locator, LocatorType locatorType);

     SeleniumWebControls GetMonthAndYear(String locator, LocatorType locatorType, String headerLocator, LocatorType headerLocatorType);

}
