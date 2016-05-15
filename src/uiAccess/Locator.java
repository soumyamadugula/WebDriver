package uiAccess;

public class Locator {
	 public Locator()
     {

     }

     public Locator(String Locator, LocatorType LocatorType)
     {
         ControlLocator = Locator;
         this.LocatorType = LocatorType;
     }
     public String ControlLocator;
     public LocatorType LocatorType;
}
