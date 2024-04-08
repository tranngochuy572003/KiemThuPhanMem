package TestCases.RailWay;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.RailWay.BookTicketPage;
import PageObjects.RailWay.HomePage;
import PageObjects.RailWay.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {

  @BeforeTest
  public void beforeMethod(){
    System.out.println("Pre-condition");
    System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\src\\Executables\\chromedriver.exe");
    Constant.WEBDRIVER=new ChromeDriver();
    Constant.WEBDRIVER.manage().window().maximize();


  }

  @Test
  public void TC07() {
    System.out.println("TC07 - User can create new account");
    HomePage homePage = new HomePage();
    homePage.open();
    RegisterPage registerPage= homePage.gotoRegister();
    String actualMsg = registerPage.register(Constant.USERNAME_NEW, Constant.PASSWORD_NEW,Constant.CONFIRM_PASSWORD, Constant.PID).getConfirmMessage();
    String expectedMsg = "Thank you for registering your account";
    Assert.assertEquals(actualMsg, expectedMsg, "message is not displayed as expected");
  }

  @Test
  public void TC010() {
    System.out.println("TC01 - Confirm password is not the same with Password");
    HomePage homePage = new HomePage();
    homePage.open();
    RegisterPage registerPage = homePage.gotoRegister();
    registerPage.register("Nhom10XinhDep@gmail.com", "031220003", "03122003", "0868846729");
    String actualMsg = registerPage.getErrorMesstMessage();
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
  }

  @Test
  public void TC011() {
    System.out.println("TC011 - User can't create account while password and PID fields are empty\n");
    HomePage homePage = new HomePage();
    homePage.open();
    RegisterPage registerPage = homePage.gotoRegister();
    registerPage.register(Constant.USERNAME,"","","");

    String actualMsg = registerPage.getErrorMesstMessage();
    String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
    Assert.assertEquals(actualMsg, expectedMsg, "message is not displayed as expected");

    String actual = registerPage.getErrorPassMessage();
    String expect = "Invalid password length.";
    Assert.assertEquals(actual, expect, "message is not displayed as expected");

    String actualPID = registerPage.getErrorPIDMessage();
    String expectPID = "Invalid ID length.";
    Assert.assertEquals(actualPID, expectPID, "message is not displayed as expected");
  }



  @Test
  public void afterMethod(){
    System.out.println("Post-condition");
    Constant.WEBDRIVER.quit();
  }
}
