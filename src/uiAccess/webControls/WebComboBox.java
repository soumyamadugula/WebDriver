package uiAccess.webControls;

import org.openqa.selenium.Keys;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IComboBox;
import webDriverWrapper.iControlHierarchy.IControl;

public class WebComboBox extends WebControl {
	  public WebComboBox(Browser Browser, Locator Locator){
      super(Browser, Locator.LocatorType, Locator.ControlLocator, ControlType.ComboBox);}
 

  private IComboBox getComboBox()
  {
      
      
          return (ICombobox)Control;
      
  }

  public ReadOnlyCollection<String> GetAllOptions()
  {
      return getComboBox().GetAllOptions();
  }

  public void SelectByText(String textOption)
  {
	  this.getComboBox().SelectByText(textOption);
  }

  public void SelectByText(String textOption, int timeOut)
  {
	  this.getComboBox().SelectByText(textOption, timeOut);
  }

  public void SelectByIndex(int index)
  {
	  this.getComboBox().SelectByIndex(index);
  }

  public void SelectByIndex(int index, int timeOut)
  {
	  this.getComboBox().SelectByIndex(index, timeOut);
  }

  public void SelectByValue(String value)
  {
	  this.getComboBox().SelectByValue(value);
  }

  public void DeselectAll()
  {
	  this.getComboBox().DeselectAll();
  }

  public void DeselectByIndex(int index)
  {
	  this.getComboBox().DeselectByIndex(index);
  }

  public void DeselectByText(String text)
  {
	  this.getComboBox().DeselectByText(text);
  }

  public void DeselectByValue(String value)
  {
	  this.getComboBox().DeselectByValue(value);
  }

  public void NativeSelect(String text, String childrenXpath, int timeOut)
  {
	  this.getComboBox().Click();


      for (IControl option : getComboBox().WaitForChildren(childrenXpath, timeOut))
      {
          if (!option.getText().equals(text))
          {
        	  getComboBox().SendKeys(Keys.DOWN);
          }
          else
          {
              break;
          }
      }
      if (childrenXpath.contains("optgroup"))
      {
    	  getComboBox().SendKeys(Keys.DOWN);
    	  getComboBox().SendKeys(Keys.RETURN);
      }
      else
      {
    	  getComboBox().SendKeys(Keys.RETURN);
      }
  }


}
