import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;
import files.reUsable;



public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if Add Place API is working as expected
// given - all input details
// when - Submit the API - resource,http method
// Then - validate the response
		
		// Pushing my downloaded code to GIThub
		//****
		//****
		System.out.println("Test");
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).
		header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		// Add Place ----> Update Place with New Address ----> Get Place to validate if new address present in response
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		String newAddress = "70 Summer walk, USA California";
		//update Address
		
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"     ///update address
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		// Get Place to verify updated address is correct
		System.out.println("Call Get after update");
		String response_afterUpdate = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeId)
				.when().get("maps/api/place/get/json")
				.then().assertThat().log().all().statusCode(200).
				extract().response().asString();
				// Add Place ----> Update Place with New Address ----> Get Place to validate if new address present in response
				
				System.out.println(response_afterUpdate);
				//JsonPath js1 = new JsonPath(response_afterUpdate);
				JsonPath js1 = reUsable.rawToJson(response_afterUpdate);
				String actualAddress = js1.getString("address");
				System.out.println(actualAddress);
				//Assert.assertEquals(actualAddress,newAddress);
				Assert.assertEquals(actualAddress,newAddress);
				
				/*if (newAddress == actualAddress)
				{
					System.out.println("Pass");
				}*/
				
				
		
	}

	
}
