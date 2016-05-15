package uiAccess;

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

public class Utility {
	/// <summary>
		/// Description of Utility.
		/// </summary>
	       static WebControl GetWebControlFromIContol(IControl aControl, Browser aBrowser, Locator aLocator, ControlType aConrolType)
	        {
	            WebControl aWebControl = null;
	            
	            if (aConrolType == ControlType.Button)
	            {
	                WebButton aWebButton = new WebButton(aBrowser, aLocator);
	                aWebButton.Control = aControl;
	                aWebControl = aWebButton;
	            }

	            if (aConrolType == ControlType.EditBox)
	            {
	                WebEditBox aWebEditBox = new WebEditBox(aBrowser, aLocator);
	                aWebEditBox.Control = aControl;
	                aWebControl = aWebEditBox;
	            }
	            
	            if (aConrolType == ControlType.Custom)
	            {
	                aWebControl = new WebControl(aBrowser, aLocator);
	                aWebControl.Control = aControl;
	                //aWebControl = aWebEditBox;
	            }
	            if (aConrolType == ControlType.Calender)
	            {
	                WebCalender aWebCalender = new WebCalender(aBrowser, aLocator);
	                aWebCalender.Control = aControl;
	                aWebControl = aWebCalender;
	            }
	            
	            if (aConrolType == ControlType.ComboBox)
	            {
	                WebComboBox aWebComboBox = new WebComboBox(aBrowser, aLocator);
	                aWebComboBox.Control = aControl;
	                aWebControl = aWebComboBox;
	            }

	            if (aConrolType == ControlType.CheckBox)
	            {
	                WebCheckBox aWebCheckBox = new WebCheckBox(aBrowser, aLocator);
	                aWebCheckBox.Control = aControl;
	                aWebControl = aWebCheckBox;
	            }

	            if (aConrolType == ControlType.Dialog)
	            {
	                WebDialog aWebDialog = new WebDialog(aBrowser, aLocator);
	                aWebDialog.Control = aControl;
	                aWebControl = aWebDialog;
	            }

	            if (aConrolType == ControlType.Frame)
	            {
	                WebFrame aWebFrame = new WebFrame(aBrowser, aLocator);
	                aWebFrame.Control = aControl;
	                aWebControl = aWebFrame;
	            }

	            if (aConrolType == ControlType.Image)
	            {
	                WebImage aWebImage = new WebImage(aBrowser, aLocator);
	                aWebImage.Control = aControl;
	                aWebControl = aWebImage;
	            }

	            if (aConrolType == ControlType.Label)
	            {
	                WebLabel aWebLabel = new WebLabel(aBrowser, aLocator);
	                aWebLabel.Control = aControl;
	                aWebControl = aWebLabel;
	            }

	            if (aConrolType == ControlType.Link)
	            {
	                WebLink aWebLink = new WebLink(aBrowser, aLocator);
	                aWebLink.Control = aControl;
	                aWebControl = aWebLink;
	            }

	            if (aConrolType == ControlType.ListBox)
	            {
	                WebListBox aWebListBox = new WebListBox(aBrowser, aLocator);
	                aWebListBox.Control = aControl;
	                aWebControl = aWebListBox;
	            }

	            if (aConrolType == ControlType.Page)
	            {
	                WebPage aWebPage = new WebPage(aBrowser, aLocator);
	                aWebPage.Control = aControl;
	                aWebControl = aWebPage;
	            }

	            if (aConrolType == ControlType.RadioButton)
	            {
	                WebRadioButton aWebRadioButton = new WebRadioButton(aBrowser, aLocator);
	                aWebRadioButton.Control = aControl;
	                aWebControl = aWebRadioButton;
	            }

	            if (aConrolType == ControlType.SpanArea)
	            {
	                WebSpanArea aWebSpanArea = new WebSpanArea(aBrowser, aLocator);
	                aWebSpanArea.Control = aControl;
	                aWebControl = aWebSpanArea;
	            }

	            if (aConrolType == ControlType.WebTable)
	            {
	                WebTable aWebTable = new WebTable(aBrowser, aLocator);
	                aWebTable.Control = aControl;
	                aWebControl = aWebTable;
	            }

	            if (aConrolType == ControlType.WebRow)
	            {
	                WebRow aWebRow = new WebRow(aBrowser, aLocator);
	                aWebRow.Control = aControl;
	                aWebControl = aWebRow;
	            }

	            if (aConrolType == ControlType.WebCell)
	            {
	                WebCell aWebCell = new WebCell(aBrowser, aLocator);
	                aWebCell.Control = aControl;
	                aWebControl = aWebCell;
	            }
	            
	            
	            return aWebControl;
	        }

	        static List<WebControl> GetWebControlsFromIControlList(List<IControl> aIControlList, Browser aBrowser, Locator aLocator,ControlType aConrolType)
	        {
	            List<WebControl> aWebControlList = new List<WebControl>();

	            for (IControl aControl : aIControlList)
	            {
	                aWebControlList.Add(GetWebControlFromIContol(aControl, aBrowser, aLocator, aConrolType));               
	            }

	            return aWebControlList;
	        }
	        
	    }
		
		
			
	