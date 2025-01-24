import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PasswordSetting {
	@Test
	public void SetPassword() {

		// Specify Base URI
		RestAssured.baseURI = "http://lprsapi.demofms.com/api";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload
		JSONObject requestparam = new JSONObject();
		requestparam.put("MobileNo", "8669480709");
		requestparam.put("Password", "Pass@123");
		
	

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestparam.toJSONString());

		// Response Object
		Response response = httpRequest.request(Method.POST, "/OTP/SetPassword");

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
