package StepDefinitions;

import io.cucumber.java.en.*;//if you put * instead of Given alll the terms like Then and When will import automatically
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AddCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomerByEmail;

import java.util.concurrent.TimeUnit;

public class Steps extends BaseClass{

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        // Write code here that turns the phrase above into concrete actions

        String chromeLocation=System.getProperty("user.dir");
        System.out.println("the path is"+chromeLocation);

        System.setProperty("webdriver.chrome.driver",chromeLocation+"/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        lp=new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println("Inside launch");

        //throw new io.cucumber.java.PendingException();
    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        // Write code here that turns the phrase above into concrete actions

         driver.get(url);
        System.out.println("The URL is clicked");

       // throw new io.cucumber.java.PendingException();
    }
    @When("User Enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        lp.setEmail(email);
       // System.out.println("the users set email as"+lp.setEmail(email));
        Thread.sleep(3000);
        lp.setPassword(password);
        Thread.sleep(4000);

        //throw new io.cucumber.java.PendingException();
    }
    @When("Click on Login")
    public void click_on_login() {
        // Write code here that turns the phrase above into concrete actions

        lp.loginButton();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String pageTitle) {
        // Write code here that turns the phrase above into concrete actions
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.assertTrue(false);
        }else{
            Assert.assertEquals(pageTitle,driver.getTitle());
        }
        //throw new io.cucumber.java.PendingException();
    }
    @When("User CLik on Logout Link")
    public void user_c_lik_on_logout_link() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(4000);
        lp.logoutButton();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("Close Browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.close();
        //throw new io.cucumber.java.PendingException();
    }
    //Add Customer Feature
    @Then("User Can view the Dashboard")
    public void user_can_view_the_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        //String secondTitle=driver.getTitle();
        //if(secondTitle.equalsIgnoreCase("Dashboard")){
          //  Assert.assertTrue(true);
        //}
        addCustomer=new AddCustomer(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addCustomer.getPageTitle());
        //throw new io.cucumber.java.PendingException();
    }
    @When("User clicks the Customer's Menu")
    public void user_clicks_the_customer_s_menu() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        addCustomer.customerLink();
        Thread.sleep(3000);
        //throw new io.cucumber.java.PendingException();
    }
    @When("Clicks on Customer's Menu Item")
    public void clicks_on_customer_s_menu_item() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        addCustomer.customerButton();
    }
    @When("Click on Add New Button")
    public void click_on_add_new_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        addCustomer.addCustomer();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User can view Add New Customer Page")
    public void user_can_view_add_new_customer_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCustomer.getPageTitle());


        //throw new io.cucumber.java.PendingException();
    }
    @When("User enter the customer info")
    public void user_enter_the_customer_info() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        addCustomer.setMail(randomGen()+"@gmail.com");
        Thread.sleep(1000);
        addCustomer.setPassword("password1234");
        Thread.sleep(1000);
        addCustomer.setFirstName("dipen");
        Thread.sleep(1000);
        addCustomer.setLastName("shakya");
        Thread.sleep(1000);
        addCustomer.setGender();
        Thread.sleep(1000);
        addCustomer.setDate("09/21/2022");
        Thread.sleep(1000);
        addCustomer.setCompany("iDeliver");
        Thread.sleep(1000);
        addCustomer.setChecker();
        Thread.sleep(1000);
        addCustomer.setText();
        Thread.sleep(2000);
        addCustomer.manageVendor();

        //throw new io.cucumber.java.PendingException();
    }
    @When("Click on save button")
    public void click_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        addCustomer.saveButon();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(addCustomer.confirmMessage().contains("The new customer has been added successfully."));
       // throw new io.cucumber.java.PendingException();
    }
    //Steps for search customer by emailid
    @When("Enter the Customer Email")
    public void enter_the_customer_email() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        searchByEmail=new SearchCustomerByEmail(driver);
        searchByEmail.SearchEmail("victoria_victoria@nopCommerce.com");
        Thread.sleep(10);
        //throw new io.cucumber.java.PendingException();
    }
    @When("Click on the Search Button")
    public void click_on_the_search_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        searchByEmail.SearchButton();
        Thread.sleep(5);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User should found Email in the Search Table")
    public void user_should_found_email_in_the_search_table() {
        // Write code here that turns the phrase above into concrete actions
        boolean status = searchByEmail.searchCustomerByEmails("victoria_victoria@nopCommerce.com");
        //throw new io.cucumber.java.PendingException();
        Assert.assertEquals(false,status);
    }
}
