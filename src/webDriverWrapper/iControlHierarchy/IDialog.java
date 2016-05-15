package webDriverWrapper.iControlHierarchy;

public interface IDialog {
	   String getTitle();
      public void AcceptDialog();
    public void CancelDialog();
       String GetDialogText();
     public void SendText(String text);
}
