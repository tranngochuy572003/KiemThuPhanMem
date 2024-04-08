package PageObjects.RailWay;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;



public class GeneralPage {
  private final By tabLogin= By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
  private final By tabLogout= By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
  private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
  private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
  private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
  private final By tabChangePass = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");

  private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");

  private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");




  public String getTxtTabChangePass(){
    return this.getTabChangePass().getText();

  }

  protected WebElement getTabChangePass(){
    return Constant.WEBDRIVER.findElement(tabChangePass);

  }

  public String getTxtTabMyTicket(){
    return this.getTabMyTicket().getText();

  }

  protected WebElement getTabMyTicket(){
    return Constant.WEBDRIVER.findElement(tabMyTicket);

  }

  public MyTicketPage goToMyTicket(){

    this.getTabMyTicket().click();
    return new MyTicketPage();

  }

  protected WebElement getTabTimeTable(){
    return Constant.WEBDRIVER.findElement(tabTimetable);

  }

  public TimeTablePage goToTabTimeTable(){

    this.getTabTimeTable().click();
    return new TimeTablePage();

  }
  protected WebElement getTabChange(){
    return Constant.WEBDRIVER.findElement(tabChangePass);

  }
  public ChangePassPage gotoChangePassWord(){
    this.getTabChange().click();
    return new ChangePassPage();
  }

  protected WebElement getTabLogin(){
    return Constant.WEBDRIVER.findElement(tabLogin);

  }
  protected WebElement getTabLogout(){
    return Constant.WEBDRIVER.findElement(tabLogout);

  }

  public String getTxtTabLogout(){
    return this.getTabLogout().getText();

  }


  protected WebElement getLblWelcomeMessage(){
    return Constant.WEBDRIVER.findElement(lblWelcomeMessage);

  }
  public String getWelcomeMessage(){
    return this.getLblWelcomeMessage().getText();
  }

  public LoginPage gotoLoginPage (){
    this.getTabLogin().click();
    return new LoginPage();
  }

  protected WebElement getTabBookTicket(){
    return Constant.WEBDRIVER.findElement(tabBookTicket);

  }
  public BookTicketPage gotoBookTicket (){
    this.getTabBookTicket().click();
    return new BookTicketPage();
  }

  protected WebElement getTabRegister(){
    return Constant.WEBDRIVER.findElement(tabRegister);

  }
  public RegisterPage gotoRegister(){
    this.getTabRegister().click();
    return new RegisterPage();
  }












}
