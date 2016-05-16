package uiAccess;

import java.util.Date;

public class GuiMap {
	  private Date nowTimeStamp;

      private String id;
      private String name;
      private String xpath;
      private String className;
      private String logicalName;
      private String tagname;
      private String identificationType;
      private String content;
      private String atribute;

      /// <summary>
      /// Initializes a new instance of the <see cref="Guimap"/> class.
      /// </summary>
      public GuiMap()
      {
          //log4net.ThreadContext.Properties["myContext"] = "Logging from GuiMap Class";
          nowTimeStamp = new Date();
      }

      public Date getLastUsedTime()
      {
        
              return nowTimeStamp;
      }        
              public Date setLastUsedTime() {
          
              nowTimeStamp = value;
          
      }
      /// <summary>
      /// Gets or sets the type of the identification.
      /// </summary>
      /// <value>
      /// The type of the identification.
      /// </value>
      public String getIdentificationType()
      
           { return identificationType; }
      public String setIdentificationType()
            { identificationType = value; }
      
      /// <summary>
      /// Gets or sets the tagname.
      /// </summary>
      /// <value>
      /// The tagname.
      /// </value>
      public String getTagname()
      
           { return tagname; }
           public String setTagname()  { tagname = value; }
      

      /// <summary>
      /// Gets or sets the name of the logical.
      /// </summary>
      /// <value>
      /// The name of the logical.
      /// </value>
      public String getLogicalName()
           { return logicalName; }
      public String setLogicalName()
      { logicalName = value; }
      

      /// <summary>
      /// Gets or sets the name of the class.
      /// </summary>
      /// <value>
      /// The name of the class.
      /// </value>
      public String getClassName()
      
           { return className; }
      public String setClassName()
       { className = value; }
      
      /// <summary>
      /// Gets or sets the identifier.
      /// </summary>
      /// <value>
      /// The identifier.
      /// </value>
      public String getId()
      
           { return id; }
      public String setId()
      { id = value; }
      

      /// <summary>
      /// Gets or sets the name.
      /// </summary>
      /// <value>
      /// The name.
      /// </value>
      public String getName()
      
           { return name; }
           public String setName() { name = value; }
      

      /// <summary>
      /// Gets or sets the xpath.
      /// </summary>
      /// <value>
      /// The xpath.
      /// </value>
      public String getXpath()
      { return xpath; }
          public String setXpath()  
          { xpath = value; }
      

      public String getContent()
      { return content; }
      public String setContent()
      { content = value; }
      

      public String getAtribute()
           { return atribute; }
      public String setAtribute() { atribute = value; }
}
