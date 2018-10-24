package org.springframework.cloud.contract.verifier.tests;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.labs.game.cartservice.ContractVerifierBase;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

public class ContractVerifierTest extends ContractVerifierBase {

	@Test
	public void validate_cart_service_111() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("customer","111")
					.get("/cart-items");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(0);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(1);
			assertThatJson(parsedJson).array().contains("['product']").isEqualTo("BBB");
			assertThatJson(parsedJson).array().contains("['customer']").isEqualTo("111");
			assertThatJson(parsedJson).array().contains("['quantity']").isEqualTo(1);
			assertThatJson(parsedJson).array().contains("['product']").isEqualTo("AAA");
	}

	@Test
	public void validate_cart_service_222() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("customer","222")
					.get("/cart-items");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).array().contains("['product']").isEqualTo("CCC");
			assertThatJson(parsedJson).array().contains("['product']").isEqualTo("EEE");
			assertThatJson(parsedJson).array().contains("['quantity']").isEqualTo(1);
			assertThatJson(parsedJson).array().contains("['customer']").isEqualTo("222");
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(4);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(3);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(2);
			assertThatJson(parsedJson).array().contains("['product']").isEqualTo("DDD");
	}

	@Test
	public void validate_cart_service_333() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("customer","777")
					.get("/cart-items");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
	}

}
