package TestCases.RailWay;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.RailWay.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTest extends LoginPage {

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
    String expectedMsg= "Invalid username or password. Please try again.";
    Assert.assertEquals(actualMsg,expectedMsg,"message is not displayed as expected");
  }

  @Test
  public void TC04() {
    System.out.println("TC04 - Login page displays when un-logged User clicks on Book ticket tab");
    HomePage homePage = new HomePage();
    homePage.open();
    BookTicketPage bookTicket= homePage.gotoBookTicket();
    String actualMsg = bookTicket.getErrorBookTicketMessage();
    String expectedMsg = "Login page";
    Assert.assertEquals(actualMsg, expectedMsg, "Message is not displayed as expected");
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
  public void TC010() {
    System.out.println("TC010 - User can't create account with Confirm password is not the same with Password");
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


  @Test
  public void TC014() {
    System.out.println("TC014 - User can book 1 ticket at a time");
    HomePage homePage = new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    loginPage.login("tranngochuy1234a@gmail.com", Constant.PASSWORD);
    BookTicketPage bookTicket= homePage.gotoBookTicket();
    String id = bookTicket.bookTicket();
    MyTicketPage myTicketPage= homePage.goToMyTicket();
    String date =Utilities.getDate();
    boolean check= myTicketPage.findById(id,"Huế", "Nha Trang","Soft bed with air conditioner",date,"1");
    Assert.assertEquals(check,true,"Ticket booked fail! / Ticket information display error ");
  }

  @Test
  public void TC015() {
    System.out.println("TC015 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");
    HomePage homePage = new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    HomePage homePage2 = loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    TimeTablePage timeTablePage= homePage2.goToTabTimeTable();
    BookTicketPage bookTicketPage = timeTablePage.BookTicketFromTimeTable();
    String actualMsg =bookTicketPage.getTxtDepartFromHue()+" to "+bookTicketPage.getTxtArriveAtSG();
    String expectedMsg = "Huế to Sài Gòn";
    Assert.assertEquals(actualMsg, expectedMsg, " message is not displayed as expected");
  }

  @Test
  public void TC016() {
    System.out.println("TC016 - User can cancel a ticket");
    HomePage homePage = new HomePage();
    homePage.open();
    LoginPage loginPage= homePage.gotoLoginPage();
    loginPage.login("tranngochuy1234a@gmail.com", Constant.PASSWORD);
    BookTicketPage bookTicket= homePage.gotoBookTicket();
    String id = bookTicket.bookTicket();
    MyTicketPage myTicketPage= homePage.goToMyTicket();
    Boolean checkDeleteExist= myTicketPage.cancel(id);
    Assert.assertEquals(checkDeleteExist, false, "The canceled ticket is appeared.");
  }







}