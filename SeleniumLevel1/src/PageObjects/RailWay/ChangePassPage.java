package PageObjects.RailWay;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassPage extends GeneralPage{

  public String getURLChangePass(){
    return Constant.WEBDRIVER.getCurrentUrl();
  }

  private final By _currentPassword= By.xpath("//input[@id='currentPassword']");

  private final By _newPassword= By.xpath("//input[@id='newPassword']");
  private final By _confirmPassword= By.xpath("//input[@id='confirmPassword']");
  private final By _btnChangePassword= By.xpath("//input[@value='Change Password']");
  private final By inform_success = By.xpath("//p[@class='message success']");

  private final By changePass = By.xpath("//h1");

  protected WebElement getChangePass(){return Constant.WEBDRIVER.findElement(changePass);}
  public String txtChangePass(){return this.getChangePass().getText();}




  protected WebElement getInformSuccess(){return Constant.WEBDRIVER.findElement(inform_success);}
  public String getSuccessMessage(){return this.getInformSuccess().getText();}


  public WebElement getCurrentPass(){
    return Constant.WEBDRIVER.findElement(_currentPassword);
  }

  public WebElement getNewPassword(){
    return Constant.WEBDRIVER.findElement(_newPassword);
  }
  public WebElement getConfirmPassword(){
    return Constant.WEBDRIVER.findElement(_confirmPassword);
  }

  public WebElement getBtnChangePassword(){
    return Constant.WEBDRIVER.findElement(_btnChangePassword);
  }




  public ChangePassPage changePass(String currentPassword, String newPassword,String confirmPassword){
    this.getCurrentPass().sendKeys(currentPassword);
    this.getNewPassword().sendKeys(newPassword);
    this.getConfirmPassword().sendKeys(confirmPassword);
    this.getBtnChangePassword().click();
    return new ChangePassPage();
  }
}
