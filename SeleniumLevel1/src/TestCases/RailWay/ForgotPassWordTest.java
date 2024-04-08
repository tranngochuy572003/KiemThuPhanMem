package TestCases.RailWay;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.RailWay.ChangePassPage;
import PageObjects.RailWay.ForgotPassWordPage;
import PageObjects.RailWay.HomePage;
import PageObjects.RailWay.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgotPassWordTest {

  @BeforeTest
  public void beforeMethod(){
    System.out.println("Pre-condition");
    System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\src\\Executables\\chromedriver.exe");
    Constant.WEBDRIVER=new ChromeDriver();
    Constant.WEBDRIVER.manage().window().maximize();


  }

  @Test
  public void afterMethod(){
    System.out.println("Post-condition");
    Constant.WEBDRIVER.quit();
  }


  @Test
  public void TC12() {
 try {
   System.out.println("Errors display when password reset token is blank");
   HomePage homePage = new HomePage();
   homePage.open();
   LoginPage loginPage = homePage.gotoLoginPage();
   ForgotPassWordPage forgotPassWordPage = loginPage.goToForgotPassWordPage();
   ChangePassPage changePassPage = forgotPassWordPage.send("nguyenphuongnga203@gmail.com");

   String actualMsg = changePassPage.getSuccessMessage();
   String expectedMsg = "You have changed your password successfully!";
   Assert.assertEquals(actualMsg, expectedMsg, "message is not displayed as expected");

 }catch (Exception e) {
      e.printStackTrace();
      Assert.fail("An exception occurred: " + e.getMessage());
    }



  }

  @Test
  public void TC013(){
    try {
      System.out.println("TC013 - Errors display if password and confirm password don't match when resetting password");
      HomePage homePage = new HomePage();
      homePage.open();
      LoginPage loginPage = homePage.gotoLoginPage();
      ForgotPassWordPage forgotPassWordPage = loginPage.goToForgotPassWordPage();
      ChangePassPage changePassPage = forgotPassWordPage.send(Constant.USERNAME_NEW);
      String actualMsg = changePassPage.txtChangePass();
      String expectedMsg = "Change password";
      Assert.assertEquals(actualMsg, expectedMsg, "Change password message is not displayed as expected");
    }catch (Exception e){
      e.printStackTrace();
      Assert.fail("An exception occurred: " + e.getMessage());

    }
  }

}
