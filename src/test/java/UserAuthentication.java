import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserAuthentication {
	@Test
	public void Authentication() {

		// Specify Base URI
		RestAssured.baseURI = "http://192.168.0.162:8080/api";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload
		JSONObject requestparam = new JSONObject();
		requestparam.put("MobileNo", "8087333794");
		requestparam.put("Password", "Pass@123");
		
	

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestparam.toJSONString());

		// Response Object
		Response response = httpRequest.request(Method.POST, "/Users/authenticate");
		

		// Print Response in Console Window
		String responsebody = response.getBody().asString();
		System.out.println("Respose Body Is = " + responsebody);

		// Statuscode Validation
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode is = " + statuscode);
		Assert.assertEquals(statuscode, 200);

		// StatusLine Verification
		String Statusline = response.getStatusLine();
		System.out.println("Statusline is = " + Statusline);
		
	}
}
