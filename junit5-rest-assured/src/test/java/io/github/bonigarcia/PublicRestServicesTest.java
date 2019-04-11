
package io.github.bonigarcia;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PublicRestServicesTest {

    @Disabled("http://echo.jsontest.com/ is over its serving quota from time to time")
    @Test
    void testEchoService() {
        String key = "foo";
        String value = "bar";
        given().when().get("http://echo.jsontest.com/" + key + "/" + value)
                .then().assertThat().statusCode(200).body(key, equalTo(value));
    }

    @Test
    void testCountryService() {
        given().when()
                .get("http://services.groupkt.com/country/get/iso2code/ES")
                .then().assertThat().statusCode(200)
                .body("RestResponse.result.name", equalTo("Spain"));
    }

}
