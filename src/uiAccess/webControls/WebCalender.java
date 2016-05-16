package uiAccess.webControls;

import uiAccess.Locator;
import uiAccess.Utility;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.LocatorType;
import webDriverWrapper.iControlHierarchy.ICalender;

public class WebCalender extends WebControl {
	
	        public Browser browser;
	        private Locator locator;

	        public WebCalender(Browser Browser, Locator Locator){
	            super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.Calender);}
	        {
	        	 this.browser = browser;
	             this.locator = locator;
	        }

	        private ICalender getCalender()
	        {
	            
	            
	                return (ICalender)Control;
	            
	        }

	        private Locator calendarHeader;
	        public Locator getCalenderHeaderLocator()
	        { 
	            
	            
	                if(null ==  this.calendarHeader)
	                {
	                    return new Locator(String.format("{0}/div", locator), LocatorType.Xpath);
	                }
	                else
	                {
	                    return  this.calendarHeader;
	                }
	               
	            }
	        public void setCalenderHeaderLocator(Locator calendarHeader) {
	            
	        	  this.calendarHeader = calendarHeader;
	            
	        }

	        private Locator calenderMonthYear;
	        public Locator getCalenderMonthYearLocator()
	        {
	            
	                if (null == calenderMonthYear)
	                {
	                    return new Locator(String.format("{0}/div", this.locator), LocatorType.Xpath);
	                }
	                else
	                {
	                	  return this.calendarHeader;
	                    }
	        }
	            
	                public void setCalenderMonthYearLocator() {
	            
	                calenderMonthYear = calendarHeader;
	            
	        }
	                
	        public WebControl getCalenderHeader()
	        {
	            
	                return new WebControl(browser, locator);
	            
	        }
	                

	        public WebControl getGetMonthAndYear()
	        {
	            
	            return Utility.GetWebControlFromIContol(this.getCalender().GetMonthAndYear(this.getCalenderMonthYearLocator().ControlLocator, this.getCalenderMonthYearLocator().LocatorType, this.getCalenderHeaderLocator().ControlLocator, this.getCalenderHeaderLocator().LocatorType), this.browser, this.locator, ControlType.Custom);
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
	            
	        	  return Utility.GetWebControlFromIContol(this.getCalender().GetCalenderHeader(this.getCalenderHeaderLocator().ControlLocator, this.getCalenderHeaderLocator().LocatorType), this.browser, this.locator, ControlType.Custom);
	              
	        }

	        //public void NextMonth()
	        //{
	        //    GetButtons[1].Click();
	        //}

	        

	    }
	

