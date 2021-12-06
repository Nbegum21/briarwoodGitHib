package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleGetClass {
    private static final Logger LOGGER = LogManager.getLogger(SimpleGetClass.class);

    @Test
    public void getAllUser () {
        LOGGER.info("........API Test: Get All User.........");

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(),200);

        JsonPath jsonPath = response.jsonPath();
        List<String> lisEmails = jsonPath.get("data.email");

        String expectedEmailId = "george.bluth@reqres.in";
        boolean emailExit = lisEmails.contains(expectedEmailId);
        Assert.assertTrue(emailExit,expectedEmailId + "doest not exit");

        LOGGER.info(".........End Test: Get All User..........");
    }
}
