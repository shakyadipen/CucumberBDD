package StepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObject.AddCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomerByEmail;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomer addCustomer;
    public SearchCustomerByEmail searchByEmail;
    public static String randomGen(){
        String randValue= RandomStringUtils.randomAlphanumeric(7);
        return (randValue);
    }
}
