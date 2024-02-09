//package com.tta.selenium4learning.learnexecel.datadriven;
//
//import io.github.sskorol.core.DataSupplier;
//import io.github.sskorol.data.XlsxReader;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//import java.util.stream.Stream;
//
//import static io.github.sskorol.data.TestDataReader.use;
//
//public class DDTDemo03 {
//
//    WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
////        driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
////    @Test(dataProvider = "loginData")
////    public void testDataDriven(String id, String email, String password, String expectedResult) {
////        System.out.println(id + email + password + expectedResult);
//////        driver.get("https://app.vwo.com");
//////        WebElement emailElement = driver.findElement(By.id("login-username"));
//////        emailElement.clear();
//////        emailElement.sendKeys(email);
//////        WebElement passwordElement = driver.findElement(By.id("login-password"));
//////        passwordElement.clear();
//////        passwordElement.sendKeys(password);
//////        driver.findElement(By.id("js-login-btn")).click();
//////
//////        if (expectedResult.equalsIgnoreCase("Valid")) {
//////            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
//////            System.out.println(text);
//////            Assert.assertEquals(text,"Wingify");
//////        }
//////        if (expectedResult.equalsIgnoreCase("InValid")) {
//////            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
//////            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
//////            wait.until(ExpectedConditions.visibilityOf(error_message));
//////            Assert.assertTrue(error_message.isDisplayed());
//////            Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
//////        }
////    }
////
////
////    @DataProvider(name = "loginData")
////    public Object[][] testData() {
////        return new Object[][]{
////                {"TD1", "93npu2yyb0@esiix.comi", "Wingify@123", "InValid"},
////                {"TD2", "93npu2yyb0@esiix.com", "Wingify@123", "Valid"},
////
////        };
////    }
//
//
//
//
//    @DataSupplier
//    public Stream<ExcelClass> getDataFromExel(Method method) {
//        return use(XlsxReader.class)
//                .withTarget(ExcelClass.class)
//                .withSource("TataData2.xlsx")
//                .read();
//    }
//
//    @Test(dataProvider = "getDataFromExel" )
//    public void testData1(ExcelClass excelClass) {
//        System.out.println(excelClass);
//    }
//
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
//
//
//}
//
//
