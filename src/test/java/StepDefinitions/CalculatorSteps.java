package StepDefinitions;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps {
	Calculator cal;
	int actualResult;

	@Given("^I have a working calculator$")
	public void i_have_a_working_calculator() throws Throwable {
		cal = new Calculator();

	}

	@When("^I perform \\*addition\\* operation of (\\d+) and (\\d+)$")
	public void i_perform_addition_operation_of_and(int val1, int val2) throws Throwable {

		actualResult = cal.add(val1, val2);
	}

	@Then("^I should get (\\d+)$")
	public void i_should_get(int expectedResult) throws Throwable {
		assertEquals(expectedResult, actualResult);

	}

	@When("^I perform \\*subtraction\\* operation of (\\d+) and (\\d+)$")
	public void i_perform_subtraction_operation_of_and(int val1, int val2) throws Throwable {
		actualResult = cal.subtract(val1, val2);

	}

	@Then("^I should get \"([^\"]*)\"$")
	public void i_should_get(String expectedResult) throws Throwable {
		int expectedResult1 = Integer.parseInt(expectedResult);
		assertEquals(expectedResult1, actualResult);

	}

	@When("^I perform \\*Multiplication\\* operation of (\\d+) and (\\d+)$")
	public void i_perform_Multiplication_operation_of_and(int val1, int val2) throws Throwable {
		actualResult = cal.multiply(val1, val2);

	}

	@When("^I perform \\*Division\\* operation of (\\d+) and (\\d+)$")
	public void i_perform_Division_operation_of_and(int val1, int val2) throws Throwable {
		actualResult = cal.divison(val1, val2);

	}

}
