package APIs;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticationAPI {
    String url ="http://restapi.demoqa.com/authentication/CheckForAuthentication/";

    @Test
    public void verityAuthentication()
    {
        RestAssured.baseURI =url;
        RequestSpecification requestSpecification;
//        requestSpecification.header("contentType","application/json");

        PreemptiveBasicAuthScheme preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
        preemptiveBasicAuthScheme.setUserName("ToolsQA");
        preemptiveBasicAuthScheme.setPassword("TestPassword");
        RestAssured.authentication =preemptiveBasicAuthScheme;

        requestSpecification = RestAssured.given();
        requestSpecification.header("contentType","application/json");


        Response response = requestSpecification.get();

        System.out.println("Response :"+response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }
}
