package webDriverWrapper.seleniumWebControls;

import java.util.ArrayList;
import java.util.List;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import webDriverWrapper.ControlAccess;
import webDriverWrapper.ControlType;
import webDriverWrapper.iControlHierarchy.IComboBox;

public class SeleniumWebComboBox extends SeleniumWebControls implements IComboBox {
	
	public SeleniumWebComboBox(WebElement aWebElement, ControlType aControlType,
			ControlAccess access){super(aWebElement, aControlType, access);
	
	}
	public ReadOnlyCollection<String> GetAllOptions()
    {
        Select element = new Select(aWebElement);
        List<WebElement> options = element.getOptions();
        List<String> optionsToReturn = new ArrayList<String>();

        for (WebElement option : options)
        {
            optionsToReturn.add(option.getText());
        }
        return optionsToReturn.AsReadOnly();

    }

    public void SelectByText(String textOption)
    {
        Select element = new Select(aWebElement);
        element.selectByVisibleText(textOption);
    }

    public void SelectByIndex(int index)
    {
        Select element = new Select(aWebElement);
        element.selectByIndex(index);
    }

    public void SelectByValue(String value)
    {
        Select element = new Select(aWebElement);
        element.selectByValue(value);
    }

    public void DeselectAll()
    {
        Select element = new Select(aWebElement);
        element.deselectAll();
    }

    public void DeselectByIndex(int index)
    {
        Select element = new Select(aWebElement);
        element.deselectByIndex(index);
    }

    public void DeselectByText(String text)
    {
        Select element = new Select(aWebElement);
        element.deselectByVisibleText(text);
    }

    public void DeselectByValue(String value)
    {
        Select element = new Select(aWebElement);
        element.deselectByValue(value);
    }

    public void SelectByIndex(int index, int maxTimeout)
    {
        DateTime start;
        double timeElapsed = 0;
        Select element = new Select(aWebElement);


        start = DateTime.now;

        while (element.getOptions().Count <= 1 && timeElapsed < maxTimeout)
        {
            timeElapsed = ((TimeSpan)(DateTime.Now - start)).TotalMilliseconds;
        }

        if (element.getOptions().Count() >= 1)
        {
            SelectByIndex(index);
            //Logger.Debug(String.Format("Inside HtmlSelectExtension , option available in {0}ms", timeElapsed));
        }
        else
        {
            //Logger.Debug(String.Format("Inside HtmlSelectExtension , option not available in {0}ms", timeElapsed));
        }
    }

    public void SelectByText(String text, int maxTimeout)
    {
        DateTime start;
        double timeElapsed = 0;
        Select element = new Select(aWebElement);

        start = DateTime.Now;

        try
        {
            while (element.getOptions().Where(option => option.Text.Equals(text)).Count() == 0 && timeElapsed < maxTimeout)
            {
                timeElapsed = ((TimeSpan)(DateTime.Now - start)).TotalMilliseconds;
                aControlAccess.IntializeControlAccess();
                element = new Select(aWebElement);
            }
        }
        catch (StaleElementReferenceException e)
        {

        }

        if (element.getOptions().Where(option = option.Text.Equals(text)).Count() != 0)
        {
            SelectByText(text);
            //Logger.Debug(String.Format("Inside HtmlSelectExtension , option available in {0}ms", timeElapsed));
        }
        else
        {
            // Logger.Debug(String.Format("Inside HtmlSelectExtension , option not available in {0}ms", timeElapsed));
        }
    }

}

