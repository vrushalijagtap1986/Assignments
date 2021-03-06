package testConfiguration;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.Properties;

public class ApplicationDetails {

    private static final String FilePath = "src/main/resources/Application.properties";

//    private static String app="ClearTrip";
//    private static Map config = null;
    File file =new File(FilePath);
    private static final Properties prop =new Properties();

//    public static Map getConfig() throws Exception
//    {
//      //  Map configTest = null;
//
//        InputStream ip = new FileInputStream(yamlPath);
//        try {
//            if(ip == null)
//                throw new FileNotFoundException();
//            for(Object data : new Yaml().loadAll(ip))
//            {
//                config = (Map)((Map)data).get(app);
//            }
//            if(config==null)
//                throw new NullPointerException();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return config;
//    }

/*    public static void loadConfiguration() throws Exception
        {
            try {
                config = ApplicationDetails.getConfig();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }*/
public static void readProperties() {
    try {

       FileInputStream fis = new FileInputStream(FilePath);
          prop.load(fis);
        if (prop.isEmpty())
            throw new NullPointerException();

    } catch (Exception e)
            {
                e.printStackTrace();
            }
}

    public static String getApplicationURL() {
//        return config.get("URL").toString();
        return prop.get("URL").toString();

    }
    public static String getBrowser() {
//        loadConfiguration();
//        return config.get("browserName").toString();
        return prop.get("browserName").toString();

    }

    public static String getFileName()
    {
//        return config.get("FileName").toString();
        return prop.get("FileName").toString();
    }

     public static String getSheetName()
            {
//                return config.get("SheetName").toString();
                return prop.get("SheetName").toString();
            }
}
