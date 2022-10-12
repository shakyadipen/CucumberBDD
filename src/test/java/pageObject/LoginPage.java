package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
        public WebDriver ldriver;
         public LoginPage(WebDriver rdriver){
            ldriver=rdriver;
            PageFactory.initElements(rdriver,this);
         }
    @FindBy(id="Email")
    @CacheLookup
    WebElement txtMail;
    @FindBy(id="Password")
    @CacheLookup
    WebElement password;
    @FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
    @CacheLookup
    WebElement LoginBtn;
    @FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
    // @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement logoutBtn;
    public void setEmail(String email) throws InterruptedException {
        txtMail.clear();
        Thread.sleep(2000);
        txtMail.sendKeys(email);
        //System.out.println("the email is"+email);
    }
    public void setPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);

    }
    public void loginButton()
    {
        LoginBtn.click();

    }
    public void logoutButton(){
        logoutBtn.click();
    }


}
