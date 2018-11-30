package APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Component
public class GetAPI extends ReadProperties{

//    @Test()
    public GetAPI(){
        super();
    }

    public void testGetAPI() throws Exception
    {
        readProperties();

        String url = ReadProperties.baseURL;
        String queryParam = ReadProperties.getQueryParam;
        RestAssured.baseURI =url;
        RequestSpecification request = RestAssured.given();

//        int code = get("https://reqres.in/api/users/2").getStatusCode();
//                System.out.println("Actual Status code :"+code);
        Response response = request.get(queryParam);

        int code =response.getStatusCode();
        System.out.println("Actual code :"+code);
        Assert.assertEquals(ReadProperties.statusCode,code);

        System.out.println("Actual response :"+response.body().asString());

        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(ReadProperties.contentEncoding,contentEncoding);
        String contentType = response.header("Content-Type");
        Assert.assertEquals(ReadProperties.contentType,contentType);

    }
}
