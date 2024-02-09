package com.vwo.main.utils;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class CommonUtils {

    WebDriver driver;
    CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method is to generate random string
     */
    public String generateRamdomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    /**
     * Method is to generate random numeric digits
     */
    public String generateRamdomNumerals() {
        String generatedString = RandomStringUtils.randomNumeric(5);
        return (generatedString);
    }

    /**
     * Method is to launch the url
     */
    public void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (TimeoutException e) {
            Assert.fail("Timed out !!! Application didn't load. Aborting !!!");
        }
    }

    /**
     * Method is to get the current url
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Method is to get the page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Method is to click on the element
     */
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    public void click(By by) {
        this.click(WaitForElementToBeClickable(by));
    }

    /**
     * Method is to click on element using javascript executor
     */
    public void clickByJavaScript(By by) {
        this.clickByJavaScript(WaitForElementToBeClickable(by));
    }

    public void clickByJavaScript(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    /**
     * Method is to wait for element to be clickable on the page
     */
    public WebElement WaitForElementToBeClickable(By by) {
        WebElement webelement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            webelement = wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
        return webelement;
    }

    /**
     * Method is to set text in textbox field
     */
    public void setText(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(new CharSequence[]{value});
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    public void setText(By by, String value) {
        this.setText(findObject(by), value);
    }

    /**
     * Method is to find the object using by class and return webelement
     */
    public WebElement findObject(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
        return element;
    }

    /**
     * Method is to wait for the page to load
     */
    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(pageLoadCondition);
    }

    /**
     * Method is to capture the screenshot
     */
    public void captureScreen(WebDriver driver, String tname) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + tname + ".png");
            FileUtils.copyFile(source, target);
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    /**
     * Method is to wait for specific seconds using thread.sleep
     */
    public void waitForSeconds(int d) {
        try {
            Thread.sleep((long) (d * 1000));
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    /**
     * Method is to scroll to page end
     */
    public void scrollToPageEnd() {
        Actions builder = new Actions(driver);
        builder.sendKeys(new CharSequence[]{Keys.END}).perform();
    }

    /**
     * Method is to hit the keys with keyboard mimic
     */
    public void hitKeys(String key) {
        Actions builder = new Actions(driver);
        if (key.equals("tab")) {
            builder.sendKeys(new CharSequence[]{Keys.TAB}).perform();
        } else if (key.equals("enter")) {
            builder.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        } else if (key.equals("down")) {
            builder.sendKeys(new CharSequence[]{Keys.DOWN}).perform();
        } else if (key.equals("up")) {
            builder.sendKeys(new CharSequence[]{Keys.UP}).perform();
        } else if (key.equals("left")) {
            builder.sendKeys(new CharSequence[]{Keys.LEFT}).perform();
        } else if (key.equals("right")) {
            builder.sendKeys(new CharSequence[]{Keys.RIGHT}).perform();
        } else if (key.equals("pagedown")) {
            builder.sendKeys(new CharSequence[]{Keys.PAGE_DOWN}).perform();
        }
    }

    /**
     * Method is to select the dropdown using value
     */
    public void selectValueFromDropDownByValue(By by, String value) {
        try {
            Select select = new Select(findObject(by));
            select.selectByValue(value);
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    /**
     * Method is to select the dropdown using text
     */
    public void selectValueFromDropDownByText(By by, String value) {
        try {
            Select select = new Select(findObject(by));
            select.selectByVisibleText(value);
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    /**
     * Method is to do wait using fluent wait
     */
    public void waitUsingPollingIntervals(By by, long pollingFrequency) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                //Wait for the condition
                .withTimeout(Duration.ofSeconds(5))
                //checking for its presenceonce every 5 seconds.
                .pollingEvery(Duration.ofSeconds(pollingFrequency))
                //Which will ignore the Exception
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(by);
            }
        });
    }

    /**
     * Method is to do double click on an element
     */
    public void doubleClick(By by) {
        Actions action = new Actions(driver);
        findObject(by);
        action.moveToElement(driver.findElement(by)).doubleClick().perform();
    }

    /**
     * Method is to move to specific element and click
     */
    public void moveToElementAndClick(By by) {
        Actions action = new Actions(driver);
        findObject(by);
        action.moveToElement(driver.findElement(by)).click().perform();
    }

    /**
     * Method is open url in a separate tab
     */
    public void openUrlInSeparateTab(String url) {
        String selectLinkOpenInNewTab = Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.RETURN});
        driver.findElement(By.linkText(url)).sendKeys(new CharSequence[]{selectLinkOpenInNewTab});
    }

    /**
     * Method is wait for element to get disappeared from page
     */
    public void waitTillElementDisappears(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    /**
     * Method is get text from specific element
     */
    public String getText(By by) {
        return findObject(by).getText();
    }

    /**
     * Method is check the frame and switch to it
     */
    public WebDriver frameToBeAvailableAndSwitchtoIt(String framelocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return (WebDriver) (wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator)));
    }

    /**
     * Method is check the frame and switch to it
     */
    public WebDriver frameToBeAvailableAndSwitchtoIt(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return (WebDriver) (wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by)));
    }

    /**
     * Method is wait for alert
     */
    public void waitForAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Method is to switch to window
     */
    public void switchToWindow() {
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator var1 = windowHandles.iterator();

        while (var1.hasNext()) {
            String window = (String) var1.next();
            if (!window.equals(parentWindowHandle)) {
                driver.switchTo().window(window);

            }
        }
    }

    /**
     * Method is to scroll the page to specific element
     */
    public void scrollIntoViewElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", new Object[]{findObject(by)});

    }
}
