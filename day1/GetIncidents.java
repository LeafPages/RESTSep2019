package day1;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidents {
	
	@Test
	public void getAllIncidents() {
		
		// End Point URL
		RestAssured.baseURI = "https://dev64481.service-now.com/api/now/v2/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "7QSEbbY9Hnqb");
		
		// Send a request (Ctrl+2 -> L)
		Response response = RestAssured
				.given()
				.log()
				.all()
				.get();
		
		// Print
		//response.prettyPrint();
		
		JsonPath jsonResponse = response.jsonPath();
		List<String> allIncidentNumbers = jsonResponse.getList("result.number");
		System.out.println(allIncidentNumbers.size());
		for (String eachIncident : allIncidentNumbers) {
			System.out.println(eachIncident);
		}
		
		
	}

}
