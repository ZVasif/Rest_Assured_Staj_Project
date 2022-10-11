package CSP_07;

import CSP_07.Modul.Location;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Location_test {

    Cookies cookies;
    @BeforeClass
    public void Login(){
        baseURI="https://demo.mersys.io/";

        Map<String ,String > credential=new HashMap<>();
        credential.put("username","richfield.edu");
        credential.put("password","Richfield2020!");
        credential.put("rememberMe","true");

        cookies=

                given()
                        .contentType(ContentType.JSON)
                        .body(credential)

                        .when()
                        .post("auth/login")

                        .then()
                        .statusCode(200)
                        .extract().response().getDetailedCookies();
    }

    public String getRandomName(){
        return RandomStringUtils.randomAlphabetic(8).toLowerCase();
    }

    public String getRandomShortName(){
        return RandomStringUtils.randomAlphabetic(4).toLowerCase();

    }

    String locationID;
    String locationName;
    String locationShort;
    int locationCapacity=852;
    String locationSchoolID="5fe07e4fb064ca29931236a5";
    @Test
    public void createLocation(){

        locationName=getRandomName();
        locationShort=getRandomShortName();

        Location location=new Location();
        location.setId(locationID);
        location.setName(locationName);
        location.setShortName(locationShort);
        location.setCapacity(locationCapacity);
        location.setSchoolID(locationSchoolID);

        locationID=

                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(location)

                        .when()
                        .post("school-service/api/location")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")

                ;





    }


}
