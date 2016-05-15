package webDriverWrapper;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.Drivers.BrowserType;
import webDriverWrapper.iControlHierarchy.IControl;
import webDriverWrapper.iControlHierarchy.IControlAccess;
	  public class ControlAccess extends IControlAccess
	    {
	        public Browser getBrowser() { }
	        public Browser setBrowser() {}
	        public String getLocator() {}
	        public String setLocator() {}
	        public LocatorType getLocatorType() { }
	        public LocatorType setLocatorType() {}
	        public ControlType getControlType() { }
	        public ControlType setControlType() {}
	        //public BrowserType BrowserType { get; set; }
	        
	        private WebElement aWebElement;
	        private ReadOnlyCollection<WebElement> aWebElements;
	        private WebDriver aWebDriver;
	        private String aLocator;
	        private LocatorType aLocatorType;
	        private ControlType aControlType;
	        private BrowserType aBrowserType;
			
	        public void IntializeControlAccess()
	        {
	            aBrowserType = Browser.BrowserType;
	            aWebDriver = Browser.BrowserHandle;
	            aLocatorType = LocatorType;
	            aLocator = Locator;
	            aControlType = ControlType;            
	        }

	        private void InitializeWebElement()
	        {
	            if (LocatorType == LocatorType.Id)
	            {
	                aWebElement = aWebDriver.findElement(By.id(aLocator));
	            }
	            if (getLocatorType() == LocatorType.Name)
	            {
	                aWebElement = aWebDriver.findElement(By.name(aLocator));               
	            }

	            if (getLocatorType() == LocatorType.Css)
	            {
	                aWebElement = aWebDriver.findElement(By.cssSelector(aLocator));
	            }

	            if (getLocatorType() == LocatorType.TagName)
	            {
	                aWebElement = aWebDriver.findElement(By.tagName(aLocator));
	            }

	            if (getLocatorType() == LocatorType.Xpath)
	            {
	                aWebElement = aWebDriver.findElement(By.xpath(aLocator));
	            } 

				if (getLocatorType() == LocatorType.LinkText)
	            {
					aWebElement = aWebDriver.findElement(By.linkText(aLocator));
	            }

				if (getLocatorType() == LocatorType.ClassName)
	            {
					aWebElement = aWebDriver.findElement(By.className(aLocator));
	            } 			
				
	            
	        }

	        private void InitializeWebElements()
	        {
	            if (getLocatorType() == LocatorType.Id)
	            {
	                aWebElements = aWebDriver.findElements(By.id(aLocator));
	            }

	            if (getLocatorType() == LocatorType.Name)
	            {
	                aWebElements = aWebDriver.findElements(By.name(aLocator));
	            }

	            if (getLocatorType() == LocatorType.Css)
	            {
	                aWebElements = aWebDriver.findElements(By.cssSelector(aLocator));
	            }

	            if (getLocatorType() == LocatorType.TagName)
	            {
	                aWebElements = aWebDriver.findElements(By.tagName(aLocator));
	            }

	            if (getLocatorType() == LocatorType.Xpath)
	            {
	                aWebElements = aWebDriver.findElements(By.xpath(aLocator));
	            }

	            if (getLocatorType() == LocatorType.LinkText)
	            {
	                aWebElements = aWebDriver.findElements(By.linkText(aLocator));
	            }

	            if (getLocatorType() == LocatorType.ClassName)
	            {
	                aWebElements= aWebDriver.findElements(By.className(aLocator));
	            }


	        }               

	        public boolean IsElementPresent()
	        {
	            try
	            {
	                InitializeWebElement();
	            }
	            catch(NoSuchElementException e)
	            {
	                return false;
	            }
	            
	            return true;
	        }

	        public Actions getAction()
	        {
	            
	                return Actions(aWebDriver, aWebElement);
	           
	        }
	        
	        public void ClickAt()
	        {
	        	Browser.BackedSelenium.ClickAt(aLocator,"0,0");
	        }

	        public IControl getControl()
	        {
	            InitializeWebElement();
	            return Utility.GetControlFromWebElement(aWebElement, aControlType,this);
	        }
	        
	        public ReadOnlyCollection<IControl> GetControls()
	        {
	            InitializeWebElements();
	            return Utility.GetControlsFromWebElements(aWebElements, aControlType,this).AsReadOnly();
	        }
	        
	        public List<IControl> GetChildren(String Locator, LocatorType aLocatorType, ControlType aControlType)
	        {
	            return Utility.GetChildren(Locator, aLocatorType, aControlType,aWebElement,this);                        
	        } 

	    }

