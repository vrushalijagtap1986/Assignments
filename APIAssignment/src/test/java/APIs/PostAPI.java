package APIs;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.testng.ITestContext;

import static io.restassured.RestAssured.given;

@Component
public class PostAPI extends ReadProperties
{
@Test
public void testPostAPI() throws Exception
        {
            try {
                readProperties();
                String url = ReadProperties.baseURL;
                String queryParam = ReadProperties.getQueryParam;
                RestAssured.baseURI = url;
                RequestSpecification request = RestAssured.given();

                JSONObject requestParam = new JSONObject();
                requestParam.put("name", "vrushali");
                requestParam.put("job", "IT");
                request.body(requestParam.toJSONString());

                Response response = request.post(queryParam);

                int statusCode = response.getStatusCode();

                Assert.assertEquals(ReadProperties.createStatusCode, statusCode);
                System.out.println("The status code recieved: " + statusCode);

                System.out.println("Response body: " + response.body().asString());
            }
            catch (Exception e)
            {
                throw new Exception(e);
            }

        }
}
