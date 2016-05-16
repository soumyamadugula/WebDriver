package uiAccess;

import webDriverWrapper.LocatorType;

public class Locator {
	 public LocatorType LocatorType;
	 public String ControlLocator;
	public Locator()
     {

     }

	 public Locator(String Locator, LocatorType LocatorType)
     {
         ControlLocator = Locator;
         this.LocatorType = LocatorType;
     }
     /// <summary>
     /// Gets or sets the control locator.
     /// </summary>
     /// <value>
     /// The control locator.
     /// </value>
     public String getControlLocator() {
		return ControlLocator;
     }
     public void setControlLocator() { 
    
     }
     /// <summary>
     /// Gets or sets the type of the locator.
     /// </summary>
     /// <value>
     /// The type of the locator.
     /// </value>
     public LocatorType getLocatorType() {
		return LocatorType;
    	 
     }
     public void setLocatorType() { }
 }
