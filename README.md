
# Sumerge Assessment - Automated Login Form Testing

This project is a Selenium-based automation suite developed with Java, TestNG, and WebDriverManager.
It validates the login functionality of the demo application at [https://www.saucedemo.com](https://www.saucedemo.com).

## Project Structure
- **sumerge_Assessment.java**: Contains all test cases for login form validation.
- **WebDriverManager**: Manages the ChromeDriver installation for streamlined testing.
- **TestNG Annotations**: For easy test configuration and ordering.

## Requirements
The automation suite tests the following requirements:

1. **Presence of Username and Password Fields**: Checks if the login page has:
    - Username input field with id: `user-name`
    - Password input field with id: `password`
    - Login button with id: `login-button`

2. **Valid Login**: Tests successful login using valid credentials:
    - Username: `standard_user`
    - Password: `secret_sauce`
    - After logging in, checks for a div containing the text "Swag Labs".

3. **Invalid Login**: Tests login attempt with incorrect credentials:
    - Enters invalid username and password, then verifies error message:
      - "Epic sadface: Username and password do not match any user in this service".

4. **Empty Credentials**:
    - Attempts login with empty username while providing password and checks for error:
      - "Epic sadface: Username is required".
    - Attempts login with empty password while providing username and checks for error:
      - "Epic sadface: Password is required".

## Getting Started

### Prerequisites
- Java JDK 8 or higher
- Maven
- Chrome browser

### Installing and Running Tests
1. Clone the repository.
2. Install dependencies using Maven: `mvn clean install`.
3. Run the test suite with TestNG: `mvn test`.

### Notes
- **Driver Setup**: The test suite uses WebDriverManager for ChromeDriver setup. If WebDriverManager does not work, manually set the driver path by uncommenting:
    ```java
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    ```

## Test Cases

1. **test_Username_And_Password_Fields_Is_Present**: Verifies the presence of username, password, and login button on the main screen.
2. **test_Entering_a_Valid_Credentials**: Validates that the user can log in with correct credentials.
3. **test_Entering_An_Invalid_Credentials**: Validates the error message shown for invalid credentials.
4. **test_Entering_An_Empty_Username**: Checks for error message when the username field is left empty.
5. **test_Entering_An_Empty_Password**: Checks for error message when the password field is left empty.

## Teardown
The `@AfterClass` annotated method ensures that the browser is closed after all tests.

## Dependencies
- **Selenium WebDriver**
- **TestNG**
- **WebDriverManager**

## Author
Mostafa Soliman
