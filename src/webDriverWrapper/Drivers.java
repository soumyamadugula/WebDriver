package webDriverWrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.*;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class Drivers {
	    public enum BrowserType
	    {
	        Firefox,

	        IE,

	        Chrome,

	        HTMLUnit

	    }

	    public class Browser
	    {

	        private WebDriver FirefoxDriver()
	        {
	            {
	                //String downloadDir = String.Format(@"{0}\DownloadedFiles",Directory.GetCurrentDirectory());

	                if (!Directory.Exists(DownloadDirectory))
	                {
	                    Directory.CreateDirectory(DownloadDirectory);
	                }

	                FirefoxProfile firefoxProfile = new FirefoxProfile();
	                firefoxProfile.setPreference("browser.download.folderList", 2);
	                firefoxProfile.setPreference("browser.download.dir", DownloadDirectory);
	                //firefoxProfile.SetPreference("browser.helperApps.alwaysAsk.force", false); 

	                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
	                firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
	                firefoxProfile.setPreference("pdfjs.disabled", true);
	                firefoxProfile.setPreference("plugin.scan.plid.all", false);

	                if (null == BinaryPath)
	                {
	                    System.out.println("null binary path");
	                    return new FirefoxDriver(firefoxProfile);
	                }
	                else
	                {
	                    System.out.println(BinaryPath);
	                    return new FirefoxDriver(new FirefoxBinary(BinaryPath), firefoxProfile, TimeSpan.FromHours(2));
	                }

	            }

	        }

	        private WebDriver getIEDriver()
	        {
	            
	            
	                InternetExplorerOptions options = new InternetExplorerOptions();
	                options.IntroduceInstabilityByIgnoringProtectedModeSettings = true;
	                options.IgnoreZoomLevel = true;
	                return new InternetExplorerDriver(Config.DriverServerPath,options);
	            

	        }

	        private WebDriver ChromeDriver()
	        {
	            
	                return new ChromeDriver(Config.DriverServerPath);
	            

	        }

	        private WebDriver HTMLUnit()
	        {
	           
	            
	                ProcessStartInfo startInfo = new ProcessStartInfo("java.exe", String.Format(@"-jar {0}\selenium-server-standalone-2.8.0.jar -port {1} -trustAllSSLCertificates", Config.NativeSeleniumDriver, Port));
	                //startInfo.FileName = Config.NativeSeleniumDriver;
	                startInfo.UseShellExecute = false;
	                startInfo.CreateNoWindow = false;
	                startInfo.RedirectStandardOutput = true;

	                //Start the process
	                NativeSeleniumProcess = Process.Start(startInfo);

	                //NativeSeleniumProcess = Process.Start(Config.NativeSeleniumDriver);

	                while (!IsConnected()) ;
	                return new RemoteWebDriver(new Uri(String.Format(@"http://127.0.0.1:{0}/wd/hub", Port)), DesiredCapabilities.HtmlUnit(), TimeSpan.FromHours(2));
	            
	        }

	   

	        public String getBinaryPath() { }
	        public String setBinaryPath() { }
	   	         WebDriverBackedSelenium getBackedSelenium()
	        {
	            
	            
	                WebDriverBackedSelenium aDriverBackedSelenium = new WebDriverBackedSelenium(BrowserHandle, Url);
	                aDriverBackedSelenium.start();
	                return aDriverBackedSelenium;
	            
	        }

	        public WebDriver BrowserHandle;

	        BrowserType BrowserType;

	     
	        public Browser(BrowserType aBrowserType)
	        {
	            GetBrowser(aBrowserType);
	        }

	        public Browser(BrowserType aBrowserType, String binaryPath)
	        {
	            BinaryPath = binaryPath;
	            GetBrowser(aBrowserType);
	        }

	        public Browser(BrowserType aBrowserType, int port)
	        {
	            Port = port;
	            GetBrowser(aBrowserType);
	        }

	        public Browser(BrowserType aBrowserType, String binaryPath, String downloadDirectory)
	        {
	            BinaryPath = binaryPath;
	            DownloadDirectory = downloadDirectory;
	            GetBrowser(aBrowserType);

	        }

	       
	        public String getTitle()
	        {
	            
	            
	                return BrowserHandle.getTitle();
	            

	        }

	        public String getUrl()
	        {
	          
	                return BrowserHandle.getCurrentUrl();
	            
	        }

	        public String getCurrentWindowHandle()
	        {

	            
	                return BrowserHandle.getWindowHandle();
	            

	        }

	        public ReadOnlyCollection<String> getWindowHandles()
	        {
	            
	                return BrowserHandle.getWindowHandles();
	            
	        }



	        public void getNativeSeleniumProcess() {}
	        private void setNativeSeleniumProcess() {}
	        public  int getPort() {} 
	        private  int setPort() {} 
	        public String getDownloadDirectory() {}
	        public String setDownloadDirectory() {}
	    

	        public void GetBrowser(BrowserType aBrowserType)
	        {
	            //            ConfigureJava();
	            //            
	            //            Environment.SetEnvironmentVariable("JAVA_HOME",@"C:\Program Files\Java\jre7");
	            //            Environment.SetEnvironmentVariable("JAVA",@"%JAVA_HOME%\bin\java.exe");
	            //            Environment.SetEnvironmentVariable("JAVA_OPTS",@"%JAVA_TOOL_OPTONS% %_JAVA_OPTIONS%");
	            //            Environment.SetEnvironmentVariable("JAVA_TOOL_OPTIONS",null);
	            //            Environment.SetEnvironmentVariable("_JAVA_OPTIONS",null);

	            BrowserType = aBrowserType;

	            if (aBrowserType == webDriverWrapper.Drivers.BrowserType.Firefox)
	            {
	                BrowserHandle = FirefoxDriver();
	            }

	            if (aBrowserType == webDriverWrapper.Drivers.BrowserType.IE)
	            {
	                BrowserHandle = getIEDriver();
	            }

	            if (aBrowserType == webDriverWrapper.Drivers.BrowserType.Chrome)
	            {
	                BrowserHandle = ChromeDriver();
	            }

	            if (aBrowserType == webDriverWrapper.Drivers.BrowserType.HTMLUnit)
	            {
	                BrowserHandle = HTMLUnit();
	            }
	        }

	        public void SwitchBrowser(String BrowserTitle)
	        {
	            String CurrentWindow = getCurrentWindowHandle();

	            Iterable<String> AvailableWindowHandles = BrowserHandle.getWindowHandles();

	            for (String availableWindowHandle : AvailableWindowHandles)
	            {
	                if (BrowserHandle.switchTo().window(availableWindowHandle).getTitle().equals(BrowserTitle))
	                {
	                    BrowserHandle.switchTo().window(availableWindowHandle);
	                }
	            }
	            //BrowserHandle = BrowserHandle.SwitchTo().Window(BrowserTitle);

	        }

	        public void Navigate(String Url)
	        {
	            BrowserHandle.navigate().to(Url);
	        }

	        public void SwitchToFrame(int FrameIndex)
	        {
	            BrowserHandle.switchTo().frame(FrameIndex);
	        }

	        //public void SwitchToFrame(IWebElement WebElement)
	        //{
	        //    BrowserHandle.SwitchTo().Frame(WebElement);
	        //}

	        public void SwitchToFrame(String FrameName)
	        {
	            BrowserHandle.switchTo().frame(FrameName);
	        }

	        public void SwitchToDefaultContent()
	        {
	            BrowserHandle.switchTo().defaultContent();
	        }

	        public void Maximize()
	        {
	            BrowserHandle.manage().window().maximize();
	        }

	        public void DeleteAllCookies()
	        {
	            BrowserHandle.manage().deleteAllCookies();
	        }

	        public Object ExecuteJavaScript(String JavaScript)
	        {
	            return (((IJavaScriptExecutor)BrowserHandle).executeScript(JavaScript);
	            		//((JavaScriptExecutor)BrowserHandle).ExecuteScript(JavaScript);
	        }

	        public bitmap TakeSreenShot()
	        {
	            var ms = new MemoryStream(((ITakesScreenshot)BrowserHandle).GetScreenshot().AsByteArray);
	            return new Bitmap(ms);
	        }

	        public void GoBack()
	        {
	            BrowserHandle.navigate().back();
	        }

	        public void GoForward()
	        {
	            BrowserHandle.navigate().forward();
	        }

	        public void Refresh()
	        {
	            BrowserHandle.navigate().refresh();
	        }

	        public void Close()
	        {
	            BrowserHandle.close();
	        }

	        public void Quit()
	        {
	            BrowserHandle.quit();
	           // BrowserHandle.Dispose();
	        }

	        public void WaitForPageLoaded(int Timeout)
	        {
	            WebDriverBackedSelenium aDriverBackedSelenium = new WebDriverBackedSelenium(BrowserHandle, getUrl());

	            aDriverBackedSelenium.start();
	            aDriverBackedSelenium.WaitForPageToLoad(Timeout.ToString(CultureInfo.InvariantCulture));
	        }

	       

	        private boolean IsConnected()
	        {
	            TcpClient client = new TcpClient();
	            System.out.println("Connecting.....");
	            try
	            {
	                client.Connect("127.0.0.1", Port);
	                System.out.println("True");
	                return true;
	            }
	            catch
	            {
	                System.out.println("False");
	                return false;
	            }
	        }

	        private IntPtr WinGetHandle(String wName)
	        {
	            IntPtr hWnd = new IntPtr();

	            for (Process pList : Process.GetProcesses())
	            {
	                if (pList.MainWindowTitle.Contains(wName))
	                {
	                    hWnd = pList.MainWindowHandle;
	                }
	            }

	            return hWnd;
	        }

	        private void ConfigureJava()
	        {
	            //Process.Start(Config.IEDriverServerPath + "java.bat");

	            Process p = new Process();

	            p.StartInfo.FileName = "cmd.exe";

	            p.StartInfo.Arguments = "/C " + Config.DriverServerPath + "/java.bat";

	            p.Start();

	            p.WaitForExit();

	        }
	    }
	}

