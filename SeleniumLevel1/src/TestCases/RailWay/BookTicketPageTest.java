package TestCases.RailWay;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.RailWay.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookTicketPageTest {

  @BeforeTest
  public void beforeMethod(){
    System.out.println("Pre-condition");
    System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\src\\Executables\\chromedriver.exe");
    Constant.WEBDRIVER=new ChromeDriver();
    Constant.WEBDRIVER.manage().window().maximize();


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
    Assert.assertEquals(check,true,"Message Ticket booked successfully! displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount) ");
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
    Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
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
    Assert.assertEquals(checkDeleteExist, false, "Welcome message is not displayed as expected");
  }




  @Test
  public void afterMethod(){
    System.out.println("Post-condition");
    Constant.WEBDRIVER.quit();
  }
}
