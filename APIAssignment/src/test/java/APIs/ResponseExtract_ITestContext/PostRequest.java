package APIs.ResponseExtract_ITestContext;

import APIs.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;


import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {
    private ReadProperties readProperties = new ReadProperties();
    private String baseURL;
    private String postQueryParam;
    public static String Set_Id;
    private String id;

    @AfterClass(alwaysRun = true)
    public void setAttribute(ITestContext context)
    {

//        request.getSession().setAttribute(Set_Id,id);

        context.setAttribute(Set_Id,id);
//        System.out.println("Set_Id:"+Set_Id);
    }

    @Test
    public void verifyPostRequest() throws Exception
    {
     try {
            readProperties.readProperties();
            baseURL =ReadProperties.baseURL;
            postQueryParam =ReadProperties.postQueryParam;
            RestAssured.baseURI =baseURL;

            RequestSpecification request = RestAssured.given();
            JSONObject requestParam = new JSONObject();
         requestParam.put("name", "vrushali");
         requestParam.put("job", "IT");
            request.body(requestParam.toJSONString());

//                given().
//                 body("{\"name\":\"vrushali\",\"job\":\"IT\"}").
////                 formParam("job", "IT").
//                 when().post(baseURL+postQueryParam).
//                        then().assertThat().statusCode(ReadProperties.createStatusCode).log().all();
            Response response = request.post(postQueryParam);
            int statusCode = response.getStatusCode();

            id= response.path("id");
//          context.setAttribute(Set_Id,id);
//          System.out.println("Set_Id:"+Set_Id);
            System.out.println("Response body :"+response.body().asString());
            System.out.println("Current id value is :"+id);
            Assert.assertEquals(ReadProperties.createStatusCode, statusCode);
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
    }

 /*   @Test
    public void verifyPutRequest(ITestContext context) throws Exception {
        readProperties.readProperties();
        String url = ReadProperties.baseURL;
        String queryParam = ReadProperties.getQueryParam;

        RestAssured.baseURI = url;
        RequestSpecification request = given();

        JSONObject requestParam = new JSONObject();
        System.out.println("Request id :" + context.getAttribute(Set_Id));
        requestParam.put("id", context.getAttribute(Set_Id));
        requestParam.put("name", "morpheus");
        requestParam.put("job", "zion resident");
        request.body(requestParam.toJSONString());
        Response response = request.put(queryParam);

        int statusCode = response.getStatusCode();
        System.out.println("Response body :"+response.body().asString());
        Assert.assertEquals(ReadProperties.statusCode, statusCode);
    }*/


}
