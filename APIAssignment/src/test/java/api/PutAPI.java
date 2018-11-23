package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class PutAPI {
    ReadProperties readProperties = new ReadProperties();
    @Test()
    public void testPutAPI() throws Exception{
        readProperties.readProperties();
        String url = ReadProperties.baseURL;
        String queryParam = ReadProperties.getQueryParam;

        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParam = new JSONObject();
        requestParam.put("name", "morpheus");
        requestParam.put("job", "zion resident");
        request.body(requestParam.toJSONString());

        Response response = request.put(queryParam);

        int statusCode = response.getStatusCode();

        Assert.assertEquals(ReadProperties.statusCode, statusCode);
        System.out.println("The status code recieved: " + statusCode);

        System.out.println("Response body: " + response.body().asString());

    }
}