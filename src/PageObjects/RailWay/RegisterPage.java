package PageObjects.RailWay;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
  private final By _txtEmail= By.xpath("//input[@id='email']");
  private final By _txtPassword= By.xpath("//input[@id='password']");
  private final By _txtConfirmPassword= By.xpath("//input[@id='confirmPassword']");
  private final By _pid= By.xpath("//input[@id='pid']");
  private final By _btnRegister= By.xpath("//input[@value='Register']");

  private final By lblMessErrorMsg = By.xpath("//p[@class='message error']");
  private final By lblPassErrorMsg = By.xpath("//label[@for=\"password\" and contains(@class, \"validation-error\")]");

  private final By lblPIDErrorMsg = By.xpath("//label[@for=\"pid\" and contains(@class, \"validation-error\")]");

  protected WebElement getPIDErrorMessage(){
    return Constant.WEBDRIVER.findElement(lblPIDErrorMsg);

  }

  public String getErrorPIDMessage(){
    return this.getPIDErrorMessage().getText();
  }



  protected WebElement getPassErrorMessage(){
    return Constant.WEBDRIVER.findElement(lblPassErrorMsg);

  }

  public String getErrorPassMessage(){
    return this.getPassErrorMessage().getText();
  }


  protected WebElement getMessErrorMessage(){
    return Constant.WEBDRIVER.findElement(lblMessErrorMsg);

  }

  public String getErrorMesstMessage(){
    return this.getMessErrorMessage().getText();
  }





  private final By _txtRegisterConfirm = By.xpath("//div[@id='content']/p");
  protected WebElement getRegisTerConfirm(){return Constant.WEBDRIVER.findElement(_txtRegisterConfirm);}
  public String getConfirmMessage(){return this.getRegisTerConfirm().getText();}


  public WebElement getBtnLogin (){
    return Constant.WEBDRIVER.findElement(_btnRegister);
  }


  public WebElement getTxtEmail(){
    return Constant.WEBDRIVER.findElement(_txtEmail);
  }
  public WebElement getTxtPassword(){return Constant.WEBDRIVER.findElement(_txtPassword);}
  public WebElement getConfirmPassword (){return Constant.WEBDRIVER.findElement(_txtConfirmPassword);}
  public WebElement getPid(){
    return Constant.WEBDRIVER.findElement(_pid);
  }




  public RegisterPage register(String username, String password,String confirmPass,String pid ){
    this.getTxtEmail().sendKeys(username);
    this.getTxtPassword().sendKeys(password);
    this.getConfirmPassword().sendKeys(confirmPass);
    this.getPid().sendKeys(pid);
    this.getBtnLogin().click();

    return new RegisterPage();
  }



}
