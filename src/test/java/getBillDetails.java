import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getBillDetails {
	@Test
	public void getBillDetailsforcontractor() {

		// Specify Base URI
		RestAssured.baseURI = "http://lprsapi.demofms.com/api";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload
		JSONObject requestparam = new JSONObject();
		
	
		requestparam.put("PartyID","17");
		requestparam.put("WorkID", "1");
		
	
		httpRequest.header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6Ijg2Njk0ODA3MDkiLCJuYmYiOjE2ODcxNzQxNzgsImV4cCI6MTY4NzI2MDU3OCwiaWF0IjoxNjg3MTc0MTc4fQ.mKssDj_FdGQCwjm2CRwL8l2j-2VETqM7AC5HtpSWtUQ");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparam.toJSONString());

		// Response Object
		Response response = httpRequest.request(Method.GET, "/BillDetails/GetBillDetailsWithBillID");

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
