package files;

import io.restassured.path.json.JsonPath;

public class reUsable {
	
	public static JsonPath rawToJson(String response)
	{
		//RawToJson
		JsonPath js1 = new JsonPath(response);
		return js1;
	}

	

}
