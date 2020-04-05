package core.api.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient {
    private final static String BASE_URI = "https://ivan-ltd.inv.bg";
    private final static String BASE_PATH = "/RESTapi";
    private final static String USER_EMAIL = "ipettkov@abv.bg";
    private final static String PASSWORD = "ivan123";

    protected final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void setRestClient() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
        RestAssured.authentication = RestAssured.preemptive().basic(USER_EMAIL, PASSWORD);
    }

    protected Response post(String url, String body) {
        Response response = RestAssured.given().log().all().body(body).when().post(url);
        response.prettyPrint();

        return response;
    }

    protected Response get(String url, String id) {
        Response response = RestAssured.given().log().all().when().get(url + "/" + id);
        response.prettyPrint();

        return response;
    }

    protected Response get(String url) {
        Response response = RestAssured.given().log().all().when().get(url);
        response.prettyPrint();

        return response;
    }

    protected Response delete(String url, String id) {
        Response response = RestAssured.given().contentType(ContentType.JSON).log().all().delete(url + "/" + id);
        response.prettyPrint();

        return response;
    }
}
