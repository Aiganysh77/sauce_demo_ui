package step_definitions.api_demo_steps;

import apiModels.RequestBody;
import apiModels.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.Config;

public class Api_demo_step_defs {

   ResponseBody responseBody;

    @Given("User validates get method with the {string}")
    public void user_validates_get_method_with_the(String resource) throws JsonProcessingException {

        Response response = RestAssured.get(Config.getProperty("baseURL") + resource);

        ObjectMapper objectMapper = new ObjectMapper();
        responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        System.out.println(response.statusCode());
        Assert.assertEquals("API Server down", 200, response.statusCode());
        System.out.println(response.asString());

    }


    @Given("User validates post method with {string}")
    public void user_validates_post_method_with(String resource)  {
        String uri = Config.getProperty("baseURL") + resource;
        RequestBody requestBody = new RequestBody();
        requestBody.setBody("bar");
        requestBody.setUserId(1);
        requestBody.setTitle("foo");

        ObjectMapper ob = new ObjectMapper();
        String bodyJSON = "";
        try {
            bodyJSON = ob.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Response response = RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).body(bodyJSON).when().post(uri);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        try {
            responseBody = ob.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String actualBody = responseBody.getBody();
        String expectedBody = "bar";
        Assert.assertEquals("Body has wrong value", actualBody,expectedBody );


    }


    @Given("User validates put method with {string}")
    public void user_validates_put_method_with(String resource) {
        String uri = Config.getProperty("baseURL") + resource;
        RequestBody requestBody = new RequestBody();
        requestBody.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJSON = "";
        try {
            bodyJSON = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).body(bodyJSON).when().put(uri);
        System.out.println(response.asString());
        System.out.println("STATUS CODE: " + response.statusCode());
        try {
             responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int actualId = responseBody.getId();
        int expectedId = 1;

        Assert.assertEquals("Id not updated", actualId,expectedId);


    }

    @Given("User validates delete method with {string}")
    public void user_validates_delete_method_with(String resource) {
        String uri = Config.getProperty("baseURL") + resource;

        Response response = RestAssured.delete(uri);

        System.out.println("STATUS CODE: " + response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            System.err.println("Warning! \nResponse couldn't map properly with Jackson library!");
        }

         Response response1 = RestAssured.get(Config.getProperty("baseURL") + resource);

        Assert.assertEquals("Delete operation failed", 200, response.statusCode());

    }






}
