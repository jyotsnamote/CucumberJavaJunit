package StepDefinitions;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestApiSteps {

	Response response;
	private ValidatableResponse json;
	JSONObject requestParams;
	public static String id;

	@Given("^POST request with valid input$")
	public void post_request_with_valid_input(DataTable inputdata) throws Throwable {

		requestParams = new JSONObject();
		List<List<String>> data = inputdata.raw();

		requestParams.put(data.get(0).get(0), data.get(0).get(1));
		requestParams.put(data.get(1).get(0), data.get(1).get(1));
		requestParams.put(data.get(2).get(0), data.get(2).get(1));
		System.out.println("+++" + requestParams);

	}

	@Given("^the system requests POST \"([^\"]*)\"$")
	public void the_system_requests_POST(String URI) throws Throwable {

		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		request.body(requestParams.toJSONString());
		response = request.post();

	}

	@Then("^the status code is (\\d+)$")
	public void the_status_code_is(int actualStatuscode) throws Throwable {
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, actualStatuscode);

	}

	@Then("^response includes the following$")
	public void response_includes_the_following(DataTable responsedata) throws Throwable {

		JsonPath jsonPathEvaluator = response.jsonPath();

		for (Map<String, String> data : responsedata.asMaps(String.class, String.class)) {

			assertEquals(data.get("employee_name"), jsonPathEvaluator.get("employee_name"));
			assertEquals(data.get("employee_salary"), jsonPathEvaluator.get("employee_salary"));
			assertEquals(data.get("employee_age"), jsonPathEvaluator.get("employee_age"));
			assertEquals(data.get("profile_image"), jsonPathEvaluator.get("profile_image"));

		}

	}

	@Then("^response Of POST request includes the following and ID generated is notnull and numeric value$")
	public void response_Of_POST_request_includes_the_following_and_ID_generated_is_notnull_and_numeric_value(
			DataTable responsedata) throws Throwable {

		JsonPath jsonPathEvaluator = response.jsonPath();

		for (Map<String, String> data : responsedata.asMaps(String.class, String.class)) {

			assertEquals(data.get("name"), jsonPathEvaluator.get("name"));
			assertEquals(data.get("salary"), jsonPathEvaluator.get("salary"));
			assertEquals(data.get("age"), jsonPathEvaluator.get("age"));
			// checking ID is generated and it should be numeric value
			id = jsonPathEvaluator.get("id");
			assert (StringUtils.isNotEmpty(id));
			assert (StringUtils.isNumeric(id));

		}
	}

	@Given("^the system requests GET \"([^\"]*)\"$")
	public void the_system_requests_GET(String URI) throws Throwable {

		RestAssured.baseURI = URI;
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.get("/" + id);

		ResponseBody body = response.getBody();
		String bodyAsString = body.asString();
		System.out.println(bodyAsString);

	}

	@Given("^Update salary of the employee to following$")
	public void update_salary_of_the_employee_to_following(DataTable inputdata) throws Throwable {

		requestParams = new JSONObject();
		List<List<String>> data = inputdata.raw();
		requestParams.put(data.get(0).get(0), data.get(0).get(1));
	}

	@Given("^the system requests PUT \"([^\"]*)\"$")
	public void the_system_requests_PUT(String URI) throws Throwable {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		request.body(requestParams.toJSONString());
		response = request.put("/" + id);

	}

	@Given("^the system requests DELETE \"([^\"]*)\"$")
	public void the_system_requests_DELETE(String URI) throws Throwable {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		response = request.delete("/" + id);

	}

	@Then("^response Of DELETE request includes the following$")
	public void response_Of_DELETE_request_includes_the_following(DataTable responsedata) throws Throwable {
		JsonPath jsonPathEvaluator = response.jsonPath();

		for (Map<String, String> data : responsedata.asMaps(String.class, String.class)) {

			assertEquals(data.get("text"), jsonPathEvaluator.get("text"));
		}
	}

	@Then("^validating response$")
	public void validating_response(DataTable inputdata) throws Throwable {

		JsonPath jsonPathEvaluator = response.jsonPath();

		List<List<String>> data = inputdata.raw();

		assert (StringUtils.isAlpha((CharSequence) jsonPathEvaluator.get(data.get(0).get(0))));
		assert (StringUtils.isNumeric((CharSequence) jsonPathEvaluator.get(data.get(0).get(1))));
		assert (StringUtils.isNumeric((CharSequence) jsonPathEvaluator.get(data.get(0).get(2))));

	}

	@Given("^the system requests GET \"([^\"]*)\" for validation of schema$")
	public void the_system_requests_GET_for_validation_of_schema(String URI) throws Throwable {

		RestAssured.baseURI = URI;
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.get("/74388");
	}

}
