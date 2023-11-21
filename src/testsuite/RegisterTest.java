package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    //for open the browser
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    //click on the ‘Register’ link
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //Verify the text ‘Register’
        String expectedMessage = "Register";
        //find the register text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath(")]"));
        String actualMessage = actualMessageElement.getText();
        //validating actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    //    @After
    //    public void tearDown(){
    //        closeBrowser();
    //  }
    @Test
    //userShouldRegisterAccountSuccessfully
    public void userShouldRegisterAccountSuccessfully() {

            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.id("gender-male")).click();
            driver.findElement(By.id("FirstName")).sendKeys("Steve");
            driver.findElement(By.name("LastName")).sendKeys("Harris");
            driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[11]")).click();
            driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[05]")).click();
            driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[78]")).click();
            driver.findElement(By.name("Email")).sendKeys("steve321@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("steve123");
            driver.findElement(By.id("ConfirmPassword")).sendKeys("steve123");
            driver.findElement(By.xpath("//button[@name='register-button']")).click();

            String expectedText = "Your registration completed";
            String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
            Assert.assertEquals(expectedText, actualText);
            System.out.println("The Text is : " + actualText);
        }


        @After
        public void tearDown(){

            closeBrowser();
        }

    }