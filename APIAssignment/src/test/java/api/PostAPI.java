package api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import cucumber.api.java.es.E;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;

import static io.restassured.RestAssured.given;

public class PostAPI
{
    ReadProperties readProperties = new ReadProperties();
    @Test()
        public void testPostAPI() throws Exception
        {
            readProperties.readProperties();
            String url = ReadProperties.baseURL;
            String queryParam = ReadProperties.getQueryParam;
            RestAssured.baseURI =url;
            RequestSpecification request = RestAssured.given();

            JSONObject requestParam = new JSONObject();
            requestParam.put("name","vrushali");
            requestParam.put("job","IT");
            request.body(requestParam.toJSONString());

            Response response = request.post(queryParam);

            int statusCode = response.getStatusCode();

            Assert.assertEquals(ReadProperties.createStatusCode,statusCode);
            System.out.println("The status code recieved: " + statusCode);

            System.out.println("Response body: " + response.body().asString());


        }
}
