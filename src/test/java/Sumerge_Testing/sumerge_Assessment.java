package Sumerge_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class sumerge_Assessment {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path for the ChromeDriver
        WebDriverManager.chromedriver().setup();

        //if it didn't work please use the following Code:
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        //driver = new ChromeDriver();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    public void test_Username_And_Password_Fields_Is_Present() throws InterruptedException {
        // Locate the username, password fields, and login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Assert that the username, password, and login button elements are present
        Assert.assertNotNull(usernameField, "Username field is not present.");
        Assert.assertNotNull(passwordField, "Password field is not present.");
        Assert.assertNotNull(loginButton, "Login button is not present.");
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void test_Entering_a_Valid_Credentials() throws InterruptedException {
        // Enter valid credentials and attempt to log in
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verify that the "Swag Labs" text is displayed after successful login
        WebElement swagLabsText = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
        Assert.assertTrue(swagLabsText.isDisplayed(), "Swag Labs text is not displayed.");

        // Pause for visibility and navigate back and refresh the page
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();    // Refresh the page for next test
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    public void test_Entering_An_Invalid_Credentials() throws InterruptedException {
        // Enter invalid credentials and attempt to log in
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("invalid_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("wrong_password");

        driver.findElement(By.id("login-button")).click();

        // Verify the error message displayed for invalid credentials
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service",
                "Error message for invalid credentials is not as expected.");


        // Pause for visibility and clear the input fields after the assertion
        Thread.sleep(2000);
        username.clear();
        password.clear();
        driver.navigate().refresh();    // Refresh the page for next test
        Thread.sleep(2000);
    }

    @Test (priority = 4)
    public void test_Entering_An_Empty_Username() throws InterruptedException {
        // Enter valid password but leave username empty
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // Verify the error message displayed for empty username
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username is required",
                "Error message for empty username is not as expected.");


        // Pause for visibility and clear the input fields after the assertion
        Thread.sleep(2000);
        password.clear();
        driver.navigate().refresh();    // Refresh the page for next test

        Thread.sleep(2000);
    }

    @Test (priority = 5)
    public void test_Entering_An_Empty_Password() throws InterruptedException {
        // Enter username but leave password empty
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();

        // Verify the error message displayed for empty password
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Password is required",
                "Error message for empty password is not as expected.");

        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }   // Close the browser and end the session
}