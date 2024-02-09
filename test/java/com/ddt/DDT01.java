package com.ddt;

import org.testng.annotations.Test;

public class DDT01 {



    @Test(dataProvider = "getMeData" )
    public void testForLogin(String email,String password, String status){
        System.out.println(email  + password  +status);
    }

    // Get the data from the Excel
    // One by one I have execute the TestFORlOGIN Method with the data

    public Object[][] getMeData(){

        return new Object[][]{
                {"valid@gmail.com","Wingify@1234","Valid"},
                {"invalid@gmail.com","Wingify@1234","InValid"}
        };
    }



}
