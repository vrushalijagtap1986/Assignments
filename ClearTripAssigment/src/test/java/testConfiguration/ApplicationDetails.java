package testConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class ApplicationDetails {

    @Autowired
    private static String yamlPath = "src/main/resources/Application.yaml";
    private String browserName,appURL,FileName,SheetName;
    private static String app="ClearTrip";
    private static Map config = null;

    public ApplicationDetails(String browser,String url,String fName,String sName)
    {
        this.browserName =browser;
        this.appURL =url;
        this.FileName=fName;
        this.SheetName=sName;
    }

//    private static String getAppName()
//    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the application name:");
//        app=scanner.next();
//        scanner.close();
//        return app;
//    }

    public static Map getConfig() throws Exception
    {
      //  Map configTest = null;

        InputStream ip = new FileInputStream(yamlPath);
        try {
            if(ip == null)
                throw new FileNotFoundException();
            for(Object data : new Yaml().loadAll(ip))
            {
                config = (Map)((Map)data).get(app);
            }
            if(config==null)
                throw new NullPointerException();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return config;
    }

    public static void loadConfiguration() throws Exception
        {
            try {
                config = ApplicationDetails.getConfig();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    public static String getApplicationURL() throws Exception
    {
        return config.get("URL").toString();
    }
    public static String getBrowser() throws Exception
    {
//        loadConfiguration();
        return config.get("browserName").toString();
    }

    public static String getFileName()
    {
        return config.get("FileName").toString();
    }

            public static String getSheetName()
            {
                return config.get("SheetName").toString();
            }
}
