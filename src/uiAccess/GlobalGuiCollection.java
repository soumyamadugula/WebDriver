package uiAccess;

import java.nio.file.Path;
import java.util.Dictionary;

public class GlobalGuiCollection {
        private static log4j.ILog Logger = log4j.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

        private static Dictionary<String, Dictionary<String, Guimap>> globalPageCollection;

        public GlobalGuiCollection()
        {
            log4j.ThreadContext.Properties["myContext"] = "Logging from GlobalGuiCollection Class";
            System.out.println("Inside GlobalGuiCollection Constructor!");
        }   

        public static Dictionary<String, Dictionary<String, Guimap>> getGlobalPageCollection(){
        {
         
                if (null == globalPageCollection)
                {
                    globalPageCollection = new Dictionary<String, Dictionary<String, Guimap>>();
                }
                return globalPageCollection;
            }

        public static Dictionary<String, Guimap> GetGuimap(String filepath)
        {
            String originalFilePath = filepath;
            Dictionary<String, Dictionary<String, Guimap>> collection = null;
            String filename = Path.getName(filepath);
            filename = filename.substring(0, filename.length() - 4);
            System.out.println(String.concat("Checking for " + filename + " Object Collection"));

            collection = GlobalPageCollection;

            if (collection != null && collection.ContainsKey(filename))
            {
                System.out.println(String.concat("Looks like there is an already existing "+ filename + " Object Collection"));

                    collection = globalPageCollection;
                    //if (!collection.ContainsKey(filename))
                    //{
                    //    Logger.Info("oooooohhhhhhh, i am hit");
                    //    AddNewGuiMap(filename, originalFilePath);
                    //}
                    collection[filename].FirstOrDefault().Value.LastUsedTime = DateTime.Now;
            }
            else
            {
                    AddNewGuiMap(filename, originalFilePath);
            }

            QueueCleanup();
            return collection[filename];
        }

        private static void AddNewGuiMap(String filename, String filepath)
        {
            LogCheckForCollection(filename);
            lock(globalPageCollection)
            {
                GlobalPageCollection.Add(filename, GuiMapParser.GetInstance().LoadGuiMap(filepath));
                Logger.Debug(String.concat("Successfully Created ", filename, " Object Collection!"));
            }            
        }

        private static void QueueCleanup()
        {
            ThreadPool.QueueUserWorkItem(Cleanup);
        }

        private static void Cleanup(object value)
        {
            Dictionary<String, Dictionary<String, Guimap>> temp = globalPageCollection;

            lock (globalPageCollection)
            {
                if (globalPageCollection != null && globalPageCollection.Count > 0)
                {
                    foreach (KeyValuePair<String, Dictionary<String, Guimap>> guiMap in globalPageCollection)
                    {
                        if (((TimeSpan)(DateTime.Now - guiMap.Value.Values.FirstOrDefault().LastUsedTime)).Minutes > 5)
                        {
                            temp.Remove(guiMap.Key);
                        }
                    }
                }

                globalPageCollection = temp;
                Logger.Info(String.Format("Unused guimaps collected, number of guimaps present now:{0}", globalPageCollection.Count));
            }
        }

        private static void LogCheckForCollection(String fileName)
            {
            //Logger.Debug(String.Concat("There is no existing ", fileName, " Object Collection"));
            //Logger.Debug(String.Concat("Creating a new instance for ", fileName, " Object Collection"));
            }

    }
}
