package APIs.ResponseExtract_ITestContext;

import APIs.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import org.junit.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PutRequest {
    ReadProperties readProperties = new ReadProperties();
    private String RetrivedID;
//    @BeforeClass(alwaysRun=true)
//    @SuppressWarnings("unchecked")
//    public void fetchData(ITestContext context) {
//      RetrivedID = (String) context.getAttribute(PostRequest.Set_Id);
//        }

@Test
public void verifyPutRequest(ITestContext context) throws Exception {
    readProperties.readProperties();
    String url = ReadProperties.baseURL;
    String queryParam = ReadProperties.putQueryParam;

    RestAssured.baseURI = url;
    RequestSpecification request = RestAssured.given();

    JSONObject requestParam = new JSONObject();
    System.out.println("Request id :" + RetrivedID);
    requestParam.put("id",context.getAttribute(PostRequest.Set_Id) );
    requestParam.put("name", "morpheus");
    requestParam.put("job", "zion resident");
    request.body(requestParam.toJSONString());

    Response response = request.put(queryParam);

    int statusCode = response.getStatusCode();
    System.out.println("Response body :"+response.body().asString());
    Assert.assertEquals(ReadProperties.statusCode, statusCode);
}
}
