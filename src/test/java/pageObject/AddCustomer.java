package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {
    public WebDriver ldriver;
    public AddCustomer(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);

    }
    //Actions
    @FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
    @CacheLookup
    WebElement customerlink;
    @FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
    @CacheLookup
    WebElement customerButton;
    @FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a")
    @CacheLookup
    WebElement addButton;
    @FindBy(id="Email")
    @CacheLookup
    WebElement setEmail;
    @FindBy(id="Password")
    @CacheLookup
    WebElement password;
    @FindBy(id="FirstName")
    @CacheLookup
    WebElement firstName;
    @FindBy(id="LastName")
    @CacheLookup
    WebElement lastName;
    @FindBy(id="Gender_Male")
    @CacheLookup
    WebElement radioButton;
    @FindBy(id="DateOfBirth")
    @CacheLookup
    WebElement dob;
    @FindBy(id="Company")
    @CacheLookup
    WebElement companyName;
    @FindBy(id="IsTaxExempt")
    @CacheLookup
    WebElement checker;
    @FindBy(xpath="//div[@class=\"k-widget k-multiselect k-multiselect-clearable\"]")
    @CacheLookup
    WebElement customerRole;
    @FindBy(id="VendorId")
    @CacheLookup
    WebElement managerVendor;
    @FindBy(id="AdminComment")
    @CacheLookup
    WebElement textArea;
    @FindBy(name="save")
    @CacheLookup
    WebElement saveButton;
    @FindBy(xpath="/html/body/div[3]/div[1]/div")
    @CacheLookup
    WebElement confirmMsg;
    public String getPageTitle(){
        return ldriver.getTitle();
    }
    public void customerLink(){
        customerlink.click();
    }
    public void customerButton(){
        customerButton.click();
    }
    public void addCustomer(){
        addButton.click();
    }
    public void setMail(String email){
        setEmail.sendKeys(email);
    }
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void setFirstName(String fname){
        firstName.sendKeys(fname);
    }
    public void setLastName(String lname){
        lastName.sendKeys(lname);
    }
    public void setGender(){
        radioButton.click();
    }
    public void setDate(String DOB)
    {
        dob.sendKeys(DOB);
    }
    public void setCompany(String cName){
        companyName.sendKeys(cName);
    }
    public void setChecker(){
        checker.click();
    }
    public void setCustomer(){
        Select role=new Select(customerRole);
        role.selectByIndex(1);
    }
    public void manageVendor(){
        Select vendor=new Select(managerVendor);
        vendor.selectByIndex(1);
    }
    public void setText(){
        textArea.sendKeys("Hello Testers...................");
    }
    public void saveButon(){
        saveButton.click();
    }
    public String confirmMessage(){
        return confirmMsg.getText();

    }

}

