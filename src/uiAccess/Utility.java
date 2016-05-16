package uiAccess;

import java.util.ArrayList;
import java.util.List;

import uiAccess.webControls.WebButton;
import uiAccess.webControls.WebCalender;
import uiAccess.webControls.WebCell;
import uiAccess.webControls.WebCheckBox;
import uiAccess.webControls.WebComboBox;
import uiAccess.webControls.WebControl;
import uiAccess.webControls.WebDialog;
import uiAccess.webControls.WebEditBox;
import uiAccess.webControls.WebFrame;
import uiAccess.webControls.WebImage;
import uiAccess.webControls.WebLabel;
import uiAccess.webControls.WebLink;
import uiAccess.webControls.WebListBox;
import uiAccess.webControls.WebPage;
import uiAccess.webControls.WebRadioButton;
import uiAccess.webControls.WebRow;
import uiAccess.webControls.WebSpanArea;
import uiAccess.webControls.WebTable;
import webDriverWrapper.ControlType;
import webDriverWrapper.Drivers.Browser;
import webDriverWrapper.iControlHierarchy.IControl;

public class Utility {
	/// <summary>
		/// Description of Utility.
		/// </summary>
	       @SuppressWarnings("static-access")
		public
		static WebControl GetWebControlFromIContol(IControl Control, Browser Browser, Locator Locator, ControlType ConrolType)
	        {
	            WebControl webControl = null;
	            
	            if (ConrolType == ControlType.Button)
	            {
	                WebButton webButton = new WebButton(Browser, Locator);
	                webButton.Control = Control;
	                webControl = webButton;
	            }

	            if (ConrolType == ControlType.EditBox)
	            {
	                WebEditBox webEditBox = new WebEditBox(Browser, Locator);
	                webEditBox.Control = Control;
	               webControl = webEditBox;
	            }
	            
	            if (ConrolType == ControlType.Custom)
	            {
	                webControl = new WebControl(Browser, Locator);
	                webControl.Control = Control;
	             
	            }
	            if (ConrolType == ControlType.Calender)
	            {
	            	 WebCalender webCalender = new WebCalender(Browser, Locator);
	                 webCalender.Control = Control;
	                 webControl = webCalender;
	            }
	            
	            if (ConrolType == ControlType.ComboBox)
	            {
	            	WebComboBox webComboBox = new WebComboBox(Browser, Locator);
	                webComboBox.Control = Control;
	                webControl = webComboBox;
	            }

	            if (ConrolType == ControlType.CheckBox)
	            {
	                WebCheckBox webCheckBox = new WebCheckBox(Browser, Locator);
	                webCheckBox.Control = Control;
	                webControl = webCheckBox;
	            }

	            if (ConrolType == ControlType.Dialog)
	            {
	                WebDialog webDialog = new WebDialog(Browser, Locator);
	                webDialog.Control = Control;
	                webControl = webDialog;
	            }

	            if (ConrolType == ControlType.Frame)
	            {
	                WebFrame webFrame = new WebFrame(Browser, Locator);
	                webFrame.Control = Control;
	                webControl = webFrame;
	            }

	            if (ConrolType == ControlType.Image)
	            {
	                WebImage webImage = new WebImage(Browser, Locator);
	                webImage.Control = Control;
	                webControl = webImage;
	            }

	            if (ConrolType == ControlType.Label)
	            {
	                WebLabel webLabel = new WebLabel(Browser, Locator);
	                webLabel.Control = Control;
	                webControl = webLabel;
	            }

	            if (ConrolType == ControlType.Link)
	            {
	                WebLink webLink = new WebLink(Browser, Locator);
	                webLink.Control = Control;
	                webControl = webLink;
	            }

	            if (ConrolType == ControlType.ListBox)
	            {
	                WebListBox webListBox = new WebListBox(Browser, Locator);
	                webListBox.Control = Control;
	                webControl = webListBox;
	            }

	            if (ConrolType == ControlType.Page)
	            {
	                WebPage webPage = new WebPage(Browser, Locator);
	                webPage.Control = Control;
	                webControl = webPage;
	            }

	            if (ConrolType == ControlType.RadioButton)
	            {
	                WebRadioButton webRadioButton = new WebRadioButton(Browser, Locator);
	                webRadioButton.Control = Control;
	                webControl = webRadioButton;
	            }

	            if (ConrolType == ControlType.SpanArea)
	            {
	                WebSpanArea webSpanArea = new WebSpanArea(Browser, Locator);
	                webSpanArea.Control = Control;
	                webControl = webSpanArea;
	            }

	            if (ConrolType == ControlType.WebTable)
	            {
	                WebTable webTable = new WebTable(Browser, Locator);
	                webTable.Control = Control;
	                webControl = webTable;
	            }

	            if (ConrolType == ControlType.WebRow)
	            {
	                WebRow webRow = new WebRow(Browser, Locator);
	                webRow.Control = Control;
	                webControl = webRow;
	            }

	            if (ConrolType == ControlType.WebCell)
	            {
	                WebCell webCell = new WebCell(Browser, Locator);
	                webCell.Control = Control;
	                webControl = webCell;
	            }
	            
	            
	            return webControl;
	        }

	        public static List<WebControl> GetWebControlsFromIControlList(List<IControl> aIControlList, Browser Browser, Locator Locator,ControlType ConrolType)
	        {
	            List<WebControl> webControlList = new ArrayList<WebControl>();

	            for (IControl control : aIControlList)
	            {
	                webControlList.add(GetWebControlFromIContol(control, Browser, Locator, ConrolType));               
	            }

	            return webControlList;
	        }
	        
	    }
		
		
			
	