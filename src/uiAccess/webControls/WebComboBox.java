package uiAccess.webControls;

import uiAccess.Locator;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IComboBox;

public class WebComboBox {
	  public WebComboBox(Browser aBrowser, Locator aLocator){
      super(aBrowser, aLocator.LocatorType, aLocator.ControlLocator, ControlType.ComboBox)}
  { }

  private IComboBox getComboBox()
  {
      
      
          return (ICombobox)Control;
      
  }

  public ReadOnlyCollection<String> GetAllOptions()
  {
      return ComboBox.GetAllOptions();
  }

  public void SelectByText(String textOption)
  {
      ComboBox.SelectByText(textOption);
  }

  public void SelectByText(String textOption, int timeOut)
  {
      ComboBox.SelectByText(textOption, timeOut);
  }

  public void SelectByIndex(int index)
  {
      ComboBox.SelectByIndex(index);
  }

  public void SelectByIndex(int index, int timeOut)
  {
      ComboBox.SelectByIndex(index, timeOut);
  }

  public void SelectByValue(String value)
  {
      ComboBox.SelectByValue(value);
  }

  public void DeselectAll()
  {
      ComboBox.DeselectAll();
  }

  public void DeselectByIndex(int index)
  {
      ComboBox.DeselectByIndex(index);
  }

  public void DeselectByText(String text)
  {
      ComboBox.DeselectByText(text);
  }

  public void DeselectByValue(String value)
  {
      ComboBox.DeselectByValue(value);
  }

  public void NativeSelect(String text, String childrenXpath, int timeOut)
  {
      ComboBox.Click();

      byte[] test = ComboBox.WaitForChildren(childrenXpath, timeOut);

      for (IControl option : ComboBox.WaitForChildren(childrenXpath, timeOut))
      {
          if (!option.Text.Equals(text))
          {
              ComboBox.SendKeys(WebDriverWrapper.Keys.KeyDown);
          }
          else
          {
              break;
          }
      }
      if (childrenXpath.Contains("optgroup"))
      {
          ComboBox.SendKeys(WebDriverWrapper.Keys.KeyDown);
          ComboBox.SendKeys(WebDriverWrapper.Keys.Enter);
      }
      else
      {
          ComboBox.SendKeys(WebDriverWrapper.Keys.Enter);
      }
  }


}
