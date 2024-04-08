package PageObjects.RailWay;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
  private final By _linkBookTicket= By.xpath("//tr[td[1]=17]/td[7]/a");


  protected WebElement getLinkBookTicket(){

    return Constant.WEBDRIVER.findElement(_linkBookTicket);
  }

  public BookTicketPage BookTicketFromTimeTable(){
    WebElement footElement =Constant.WEBDRIVER.findElement(By.xpath("//div[@id='footer']"));
    ((JavascriptExecutor)  Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView();", footElement);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    this.getLinkBookTicket().click();
    return new BookTicketPage();
  }


}
