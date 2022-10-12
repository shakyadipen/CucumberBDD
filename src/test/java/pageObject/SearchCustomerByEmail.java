package pageObject;

import Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerByEmail {
    public WebDriver ldriver;
    //public WaitHelper helper;
    public SearchCustomerByEmail(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
       // helper = new WaitHelper(rdriver);

    }
    @FindBy(id="SearchEmail")
    @CacheLookup
    WebElement searchEmail;
    @FindBy(id="SearchFirstName")
    @CacheLookup
    WebElement fName;
    @FindBy(id="SearchLastName")
    @CacheLookup
    WebElement lName;
    @FindBy(xpath = "//table[@id=\'customers-grid\']")
    @CacheLookup
    WebElement table;
    @FindBy(xpath = "//table[@id=\'customers-grid\']/tbody/tr")
    @CacheLookup
    List<WebElement> tableRow;
    @FindBy(xpath = "//table[@id=\'customers-grid\']/tbody/tr/td")
    @CacheLookup
    List<WebElement> tableCol;

    @FindBy(id="search-customers")
    @CacheLookup
    WebElement SearchButton;
    public void SearchEmail(String mail){
        //helper.WaitForElement(searchEmail,30);
        searchEmail.clear();
        searchEmail.sendKeys(mail);
    }
    public void SearchButton(){
        SearchButton.click();
    }
    public void setFirstName(String firstName){
        //helper.WaitForElement(fName,20);
        fName.clear();
        fName.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        //helper.WaitForElement(lName,20);
        lName.clear();
        lName.sendKeys(lastName);
    }
    public int getNumRows(){
        System.out.println(tableRow.size());
        return (tableRow.size());
    }
    public int getNumCol(){
        return (tableCol.size());
    }
    public boolean searchCustomerByEmails(String emails){
        boolean flag =false;
        //for(int i=0;i<getNumRows();i++){
          //  String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
        String emailId = ldriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]")).getText();
        System.out.println(emailId);
            if(emailId.equalsIgnoreCase(emails)){
                flag = true;

         //   }
        }

        return flag;
    }
}

