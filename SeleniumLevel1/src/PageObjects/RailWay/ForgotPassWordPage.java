package PageObjects.RailWay;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPassWordPage extends GeneralPage{
  private final By _email= By.xpath("//input[@id='email']");
  private final By _btnSendInstructions= By.xpath("//input[@value='Send Instructions']");

  public WebElement getEmail(){
    return Constant.WEBDRIVER.findElement(_email);
  }

  public WebElement getBtnSendInstructions(){
    return Constant.WEBDRIVER.findElement(_btnSendInstructions);
  }


  public ChangePassPage send(String email){
    this.getEmail().sendKeys(email);
    this.getBtnSendInstructions().click();
    return new ChangePassPage();


  }







}
