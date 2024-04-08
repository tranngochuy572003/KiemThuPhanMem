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

public class ChangePassWordTest {

  @BeforeTest
  public void beforeMethod(){
    System.out.println("Pre-condition");
    System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\src\\Executables\\chromedriver.exe");
    Constant.WEBDRIVER=new ChromeDriver();
    Constant.WEBDRIVER.manage().window().maximize();


  }
  @Test
  public void TC09(){
    System.out.println("TC09 - User can change password ");
    HomePage homePage= new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    loginPage.login(Constant.USERNAME_NEW, Constant.PASSWORD_NEW);
    ChangePassPage changePassPage= homePage.gotoChangePassWord().changePass(Constant.PASSWORD_NEW, Constant.PASSWORD_CHANGE,Constant.PASSWORD_CHANGE);
    String actualMsg = changePassPage.getSuccessMessage();
    String expectedMsg= "Your password has been updated";
    Assert.assertEquals(actualMsg,expectedMsg,"message is not displayed as expected");
  }



  @Test
  public void afterMethod(){
    System.out.println("Post-condition");
    Constant.WEBDRIVER.quit();
  }
}
