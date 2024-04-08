package TestCases.RailWay;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.RailWay.ChangePassPage;
import PageObjects.RailWay.HomePage;
import PageObjects.RailWay.LoginPage;

import PageObjects.RailWay.MyTicketPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
  @BeforeTest
  public void beforeMethod(){
    System.out.println("Pre-condition");
    System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\src\\Executables\\chromedriver.exe");
    Constant.WEBDRIVER=new ChromeDriver();
    Constant.WEBDRIVER.manage().window().maximize();


  }

  @Test
  public void TC01(){
    System.out.println("TC01 - User can log into Railway with valid username and password");
    HomePage homePage= new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
    String expectedMsg= "Welcome "+ Constant.USERNAME;
    Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");

  }

  @Test
  public void TC02(){
    System.out.println("TC02 - User can't login with blank Username textbox");
    HomePage homePage= new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    loginPage.login("", Constant.PASSWORD);
    String actualMsg = loginPage.getErrorMessage();
    String expectedMsg= "There was a problem with your login and/or errors exist in your form.";
    Assert.assertEquals(actualMsg,expectedMsg,"Message is not displayed as expected");
  }

  @Test
  public void TC03(){
    System.out.println("TC03 - User cannot log into Railway with invalid password ");
    HomePage homePage= new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
    String actualMsg = loginPage.getErrorMessage();
    String expectedMsg= "There was a problem with your login and/or errors exist in your form.";
    Assert.assertEquals(actualMsg,expectedMsg,"Message is not displayed as expected");
  }

  @Test
  public void TC05() {
    System.out.println("TC05 - System shows message when user enters wrong password several times");
    HomePage homePage = new HomePage();
    homePage.open();
    for (int i = 0; i < 5; i++) {
      LoginPage loginPage = homePage.gotoLoginPage();
      loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
      Constant.WEBDRIVER.navigate().refresh();
      if (i == 4) {
        String actualMessage = loginPage.getErrorMessage();
        String expectedMessage = "You have used 1 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message is not displayed as expected");
      }

    }
  }

  @Test
  public void TC08(){
    System.out.println("TC03 - User can't login with an account hasn't been activated");
    HomePage homePage = new HomePage();
    homePage.open();
    LoginPage loginPage = homePage.gotoLoginPage();
    loginPage.login("taikhoanchuakichhoat", "matkhauchuakichhoat");
    String actualErrorMsg = loginPage.getErrorMessage();
    String expectedErrorMsg = "Invalid username or password. Please try again.";
    Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is displayed as expected");
  }

  @Test
  public void TC06(){
    System.out.println("TC06 - Additional pages display once user logged in");
    HomePage homePage= new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    MyTicketPage myTicket = homePage.goToMyTicket();
    String urlMyTicket = myTicket.getURLMyTicket();
    ChangePassPage changePassword = homePage.gotoChangePassWord();
    String urlChangePassWord = changePassword.getURLChangePass();

    String actualMsg1 =  urlMyTicket+urlChangePassWord;
    String expectedMsg1 = "http://railwayb1.somee.com/Page/ManageTicket.cshtml" + "http://railwayb1.somee.com/Account/ChangePassword.cshtml";

    String actualMsg2 = homePage.getTxtTabMyTicket()+ homePage.getTxtTabLogout()+homePage.getTxtTabChangePass();
    String expectedMsg2 = "My ticket" + "Log out" +"Change password";

    Assert.assertEquals(actualMsg1, expectedMsg1, "Check url fail");
    Assert.assertEquals(actualMsg2, expectedMsg2, "Check message fail");



  }



  @AfterTest
  public void afterMethod(){
    System.out.println("Post-condition");
//    Constant.WEBDRIVER.quit();
  }




}
