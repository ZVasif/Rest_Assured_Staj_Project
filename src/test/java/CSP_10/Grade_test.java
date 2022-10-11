package CSP_10;

import CSP_10.Model.Grade;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Grade_test {

    Cookies cookies;

    @BeforeClass
    public void Login(){

        baseURI="https://demo.mersys.io/";

        Map<String ,String >credential=new HashMap<>();
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

    String gradeID;
    String gradeName;
    String gradeshortName;
    int gradeOrder=776;

    @Test
    public void createGrade(){

        gradeName=getRandomName();
        gradeshortName=getRandomShortName();

        Grade grade=new Grade();
        grade.setId(gradeID);
        grade.setName(gradeName);
        grade.setShortName(gradeshortName);
        grade.setOrder(gradeOrder);

        gradeID=
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(grade)

                        .when()
                        .post("school-service/api/grade-levels")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id");
        }

        @Test(dependsOnMethods = "createGrade")
        public void updateGrade(){

            gradeName=getRandomName();

            Grade grade=new Grade();
            grade.setId(gradeID);
            grade.setName(gradeName);
            grade.setShortName(gradeshortName);
            grade.setOrder(gradeOrder);

            given()
                    .cookies(cookies)
                    .contentType(ContentType.JSON)
                    .body(grade)

                    .when()
                    .put("school-service/api/grade-levels")

                    .then()
                    .log().body()
                    .statusCode(200)
                    .body("name",equalTo(gradeName));

        }
        @Test(dependsOnMethods = "updateGrade")
    public void deleteGrade(){

            given()
                    .cookies(cookies)
                    .pathParams("gradeID",gradeID)

                    .when()
                    .delete("school-service/api/grade-levels/{gradeID}")

                    .then()
                    .log().body()
                    .statusCode(200)
                  ;

        }


    }
