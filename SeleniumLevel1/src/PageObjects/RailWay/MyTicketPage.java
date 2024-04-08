package PageObjects.RailWay;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{

    public String getURLMyTicket(){
        return Constant.WEBDRIVER.getCurrentUrl();
    }


    public Boolean cancel(String id) {

        WebElement footElement =Constant.WEBDRIVER.findElement(By.xpath("//div[@id='footer']"));
        ((JavascriptExecutor)  Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView();", footElement);

        String xpath = "//input[contains(@onclick, 'DeleteTicket("+id+");')]";
        WebElement cancelButton = Constant.WEBDRIVER.findElement(By.xpath(xpath));
        cancelButton.click();
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        boolean isCancelButtonExists = isElementPresent(By.xpath(xpath));

        return isCancelButtonExists;
    }

    private boolean isElementPresent(By locator) {
        try {
            Constant.WEBDRIVER.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }




    public boolean findById(String id, String expectedDepartFrom, String expectedArriveAt, String expectedSeatType, String expectedDatepart, String expectedTicketAmount) {
        final By departFromLocator = By.xpath("//tr[contains(td/input/@onclick, 'DeleteTicket(" + id + ")')]/td[2]");
        final By arriveAtLocator = By.xpath("//tr[contains(td/input/@onclick, 'DeleteTicket(" + id + ")')]/td[3]");
        final By seatTypeLocator = By.xpath("//tr[contains(td/input/@onclick, 'DeleteTicket(" + id + ")')]/td[4]");
        final By ticketAmountLocator = By.xpath("//tr[contains(td/input/@onclick, 'DeleteTicket(" + id + ")')]/td[9]");
        final By datepartLocator = By.xpath("//tr[contains(td/input/@onclick, 'DeleteTicket(" + id + ")')]/td[5]");


        String actualDepartFromText = Constant.WEBDRIVER.findElement(departFromLocator).getText();
        String actualArriveAtText = Constant.WEBDRIVER.findElement(arriveAtLocator).getText();
        String actualSeatTypeText = Constant.WEBDRIVER.findElement(seatTypeLocator).getText();
        String actualTicketAmountText = Constant.WEBDRIVER.findElement(ticketAmountLocator).getText();
        String actualDatepartText = Constant.WEBDRIVER.findElement(datepartLocator).getText();

        return expectedDepartFrom.equals(actualDepartFromText) &&
                expectedArriveAt.equals(actualArriveAtText) &&
                expectedSeatType.equals(actualSeatTypeText) &&
                expectedTicketAmount.equals(actualTicketAmountText) &&
                expectedDatepart.equals(actualDatepartText);

    }



}

