package PageObjects.RailWay;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
  private final By _txtUsername= By.xpath("//input[@id='username']");
  private final By _txtPassword= By.xpath("//input[@id='password']");
  private final By _btnLogin= By.xpath("//input[@value='login']");
  private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");


  private final By _linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
  public WebElement getLinkForgotPassword(){
    return Constant.WEBDRIVER.findElement(_linkForgotPassword);
  }

  public ForgotPassWordPage goToForgotPassWordPage(){
    this.getLinkForgotPassword().click();
    return new ForgotPassWordPage();
  }



  public WebElement getTxtUsername(){
    return Constant.WEBDRIVER.findElement(_txtUsername);
  }
  public WebElement getTxtPassword(){
    return Constant.WEBDRIVER.findElement(_txtPassword);
  }

  public WebElement getBtnLogin (){
    return Constant.WEBDRIVER.findElement(_btnLogin);
  }
  protected WebElement getLblErrorMessage(){return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);}
  public String getErrorMessage(){return this.getLblErrorMessage().getText();}



  public HomePage login(String username, String password){
    this.getTxtUsername().sendKeys(username);
    this.getTxtPassword().sendKeys(password);
    this.getBtnLogin().click();
    return new HomePage();
  }



}
