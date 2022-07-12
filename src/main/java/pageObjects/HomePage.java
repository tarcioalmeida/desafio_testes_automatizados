package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navegarParaHomePage() {
        driver.get("https://blogdoagi.com.br/");
    }

    @FindBy(how = How.ID, using = "search-open")
    WebElement lupa;

    @FindBy(how = How.CLASS_NAME, using = "search-field")
    WebElement campoBusca;

    @FindBy(how = How.CLASS_NAME, using = "search-submit")
    WebElement btPesquisar;

    public void clicarLupa(){
        lupa.click();
    }

    public void inserirCampoBusca(String termo){
        campoBusca.sendKeys(termo);
    }

    public void clicarBtPesquisar(){
        btPesquisar.click();
    }

    public boolean campoBuscaEstaVisivel(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return campoBusca.isDisplayed();
    }

}