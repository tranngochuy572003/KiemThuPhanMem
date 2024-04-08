package PageObjects.RailWay;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage{
  private final By lblBookTicketErrorMsg = By.xpath("//h1[@align='center']");
  private final By btnBooking = By.xpath("//input[@value='Book ticket']");
  private final By departFrom = By.xpath("//select[@name='DepartStation']");

  private final By departFromHue = By.xpath("//select[@name='DepartStation']/option[@selected]");

  private final By ArriveAt = By.xpath("//select[@name='ArriveStation']");

  private final By ArriveAtSG = By.xpath("//select[@name='ArriveStation']/option[@selected]");

  private final By SeatType = By.xpath("//select[@name='SeatType']");
  private final By TicketAmount = By.xpath("//select[@name='TicketAmount']");
  private final By Date = By.xpath("//select[@name='Date']");



  protected WebElement getBtnBooking(){return Constant.WEBDRIVER.findElement(btnBooking);}
  protected Select getDate(){return new Select(Constant.WEBDRIVER.findElement(Date)) ;}


  protected Select getTicketAmount(){return  new Select(Constant.WEBDRIVER.findElement(TicketAmount));}
  protected Select getSeatType(){return new  Select(Constant.WEBDRIVER.findElement(SeatType));}
  protected Select getDepartFrom(){return new Select(Constant.WEBDRIVER.findElement(departFrom));}

  public String getTxtDepartFromHue(){return Constant.WEBDRIVER.findElement(departFromHue).getText();}

  protected Select getArriveAt(){return new Select (Constant.WEBDRIVER.findElement(ArriveAt));}

  public String getTxtArriveAtSG(){return Constant.WEBDRIVER.findElement(ArriveAtSG).getText();}

  protected WebElement getBookTicketErrorMessage(){return  Constant.WEBDRIVER.findElement(lblBookTicketErrorMsg);}
  public String getErrorBookTicketMessage(){return this.getBookTicketErrorMessage().getText();}


  public String bookTicket(){

    WebElement footElement =Constant.WEBDRIVER.findElement(By.xpath("//div[@id='footer']"));
    ((JavascriptExecutor)  Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView();", footElement);

    this.getDate().selectByIndex(0);
    this.getDepartFrom().selectByVisibleText("Huế");

    try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
    }

    this.getArriveAt().selectByVisibleText("Nha Trang");
    this.getSeatType().selectByVisibleText("Soft bed with air conditioner");
    this.getTicketAmount().selectByValue("1");


    this.getBtnBooking().click();
    return Constant.WEBDRIVER.getCurrentUrl().split("id=")[1];

  }
}
