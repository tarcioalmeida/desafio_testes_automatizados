package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ResultadoDaBuscaPage;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private ResultadoDaBuscaPage resultadoDaBuscaPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ResultadoDaBuscaPage getResultadoDaBuscaPage(){
        return (resultadoDaBuscaPage == null) ? resultadoDaBuscaPage = new ResultadoDaBuscaPage(driver) : resultadoDaBuscaPage;
    }

}
