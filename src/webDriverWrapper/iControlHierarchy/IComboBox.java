package webDriverWrapper.iControlHierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import webDriverWrapper.seleniumWebControls.SeleniumWebRow;

public interface IComboBox extends IControl {

	public List<String> GetAllOptions();
	
	public void SelectByText(String option);

	public void SelectByIndex(int index);

	public void SelectByValue(String value);

	public void DeselectAll();

	public void DeselectByIndex(int index);

	public void DeselectByText(String text);

	public void DeselectByValue(String value);

	public void SelectByIndex(int index, int maxTimeout);

	public void SelectByText(String text, int maxTimeout);

}
