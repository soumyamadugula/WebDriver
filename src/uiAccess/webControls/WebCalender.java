package uiAccess.webControls;

import uiAccess.Locator;
import uiAccess.Utility;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.ICalender;

public class WebCalender extends WebControl {
	
	        private Browser browser;
	        private Locator locator;

	        public WebCalender(Browser aBrowser, Locator aLocator){
	            super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.Calender)}
	        {
	            browser = aBrowser;
	            locator = aLocator;
	        }

	        private ICalender getCalender()
	        {
	            
	            
	                return (ICalender)Control;
	            
	        }

	        private Locator calenderHeader;
	        public Locator getCalenderHeaderLocator()
	        { 
	            
	            
	                if(null == calenderHeader)
	                {
	                    return new Locator(String.Format("{0}/div", locator), LocatorType.Xpath);
	                }
	                else
	                {
	                    return calenderHeader;
	                }
	               
	            }
	        public Locator setCalenderHeaderLocator()
	            {
	                calenderHeader = value;
	            }
	        }

	        private Locator calenderMonthYear;
	        public Locator getCalenderMonthYearLocator()
	        {
	            
	                if (null == calenderMonthYear)
	                {
	                    return new Locator(String.Format("{0}/div", CalenderHeaderLocator), LocatorType.Xpath);
	                }
	                else
	                {
	                    return calenderMonthYear; 
	                    }

	            
	                public Locator setCalenderMonthYearLocator()
	            {
	                calenderMonthYear = value;
	            }
	        }
	                
	        public WebControl getCalenderHeader()
	        {
	            
	                return new WebControl(browser, locator);
	            
	        }
	                

	        public WebControl getGetMonthAndYear()
	        {
	            
	                return Utility.GetWebControlFromIContol(Calender.GetMonthAndYear(CalenderMonthYearLocator.ControlLocator, CalenderMonthYearLocator.LocatorType, CalenderHeaderLocator.ControlLocator, CalenderHeaderLocator.LocatorType), browser, locator, ControlType.Custom);
	            
	        }

	        //public WebControl NextMonth 
	        //{ 
	        //    get
	        //    {
	        //        return Utility.GetWebControlFromIContol(Calender.GetMonthAndYear,browser)
	        //    }
	        //}

	        public WebControl getGetCalenderHeader()
	        {
	            
	                return Utility.GetWebControlFromIContol(Calender.GetCalenderHeader(CalenderHeaderLocator.ControlLocator, CalenderHeaderLocator.LocatorType), browser, locator, ControlType.Custom);
	           
	        }

	        //public void NextMonth()
	        //{
	        //    GetButtons[1].Click();
	        //}

	        

	    }
	

