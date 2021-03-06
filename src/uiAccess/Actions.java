package uiAccess;

import uiAccess.webControls.WebControl;
import webDriverWrapper.ControlAccess;

public class Actions {
	 private ControlAccess thisControlAccess;

     public Actions(ControlAccess controlAccess)
     {
         thisControlAccess = controlAccess;
     }

     public void MoveToElement(WebControl webElement)
     {
         thisControlAccess.getAction().moveToElement(webElement.Control);            
     }

     public void MoveToElement(int offSetX, int offSetY)
     {
         thisControlAccess.getAction().moveToElement(offSetX, offSetY);
     }

     public void DragDrop(WebControl target)
     {
         thisControlAccess.Action.DragDrop(target.Control);
     }

     public void DragDropToOffset(int offSetX, int offSetY)
     {
         thisControlAccess.Action.DragDropToOffset(offSetX, offSetY);
     }

     public void NativeSelect(WebControl webElement)
     {
         thisControlAccess.Action.NativeSelect(webElement.Control);
     }

     public void SendKeys(String keys)
     {
         thisControlAccess.Action.SendKeys(keys);
     }

     public void SendKeys(WebControl webElement, String keys)
     {
         thisControlAccess.Action.SendKeys(webElement.Control, keys);
     }
}
