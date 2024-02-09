package vwoSignFlow.utils;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String dynamicId = "automation"+ (int)Math.floor(Math.random()*1000);
    public static String dynamicDomain = "1secmail.com";

    public static String giveMeEmail(){
        Faker faker = Faker.instance();
        return faker.internet().emailAddress();
    }


    public static String verifyFindEmail(String id,String domain){

        String url1= "https://www.1secmail.com/api/v1/?action=getMessages&login="+id+"&domain="+domain;
        System.out.println(url1);

        Response r = RestAssured.given().when().get(url1).then().log().all().extract().response();
        JsonPath jsonPath = JsonPath.from(r.asString());
        System.out.println(jsonPath.get("[0].id").toString());
        String mailId = jsonPath.get("[0].id").toString();

        String url2= "https://www.1secmail.com/api/v1/?action=readMessage&login="+id+"&domain="+domain+"&id="+mailId;
        System.out.println(url2);
        Response r2 = RestAssured.given().when().get(url2).then().log().all().extract().response();
        JsonPath jsonPath2 = JsonPath.from(r2.asString());
        String test = jsonPath2.get("body").toString();

        // https://regex101.com/r/h6DKR2/1
        Pattern pattern = Pattern.compile("<a[\\s]+([^>]+)>((?:.(?!\\<\\/a\\>))*.)</a>");
        Matcher matcher = pattern.matcher(test);
        String withhref = null;
        if (matcher.find())
        {
            //System.out.println(matcher.group(1));
            withhref=matcher.group(1);
        }
        String[] splitLink = withhref.split("href=");
        String finalUrl = splitLink[1].replace("\\\""," ");
        System.out.println(finalUrl);
        return finalUrl;
    }

}
