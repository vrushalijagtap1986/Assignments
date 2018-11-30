package APIs;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

    public ReadProperties(){}
    private static final String FilePath = "src/main/resources/API.properties";

    public static String baseURL,getQueryParam,postQueryParam,putQueryParam,contentType,contentEncoding;
    public static int statusCode,createStatusCode;

    File file =new File(FilePath);
        public void readProperties() throws Exception {
            try {
                FileInputStream fis = new FileInputStream(file);
                Properties prop =  new Properties();
                prop.load(fis);
                if(prop.isEmpty())
                    throw new NullPointerException();
                else
                    baseURL =prop.getProperty("baseURL");
                    getQueryParam =prop.getProperty("getQueryParam");
                    postQueryParam = prop.getProperty("postQueryParam");
                    putQueryParam =prop.getProperty("putQueryParam");
                    contentType = prop.getProperty("contentType");
                    contentEncoding =prop.getProperty("contentEncoding");
                    statusCode =Integer.parseInt(prop.getProperty("statusCode"));
                createStatusCode =Integer.parseInt(prop.getProperty("createStatusCode"));
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
}

}
