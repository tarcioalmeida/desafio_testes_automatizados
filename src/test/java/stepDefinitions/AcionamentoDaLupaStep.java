package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.ResultadoDaBuscaPage;
import managers.PageObjectManager;

import java.time.Duration;

public class AcionamentoDaLupaStep {

    WebDriver driver;
    HomePage homePage;
    ResultadoDaBuscaPage resultadoDaBuscaPage;
    PageObjectManager pageObjectManager;

    @Given("que o usuário esteja na Homepage do Blog do Agi")
    public void que_o_usuario_esteja_na_homepage_do_blog_do_agi() {

        System.setProperty("webdriver.chrome.driver","A:\\\\code\\\\testes_automatizados\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navegarParaHomePage();
    }

    @When("ele clicar na Lupa")
    public void ele_clicar_na_lupa() {
        homePage.clicarLupa();
    }

    @Then("será exibida a Ferramenta de Busca")
    public void sera_exibida_a_ferramenta_de_busca() {
        Assert.assertEquals(true, homePage.campoBuscaEstaVisivel());
        driver.quit();
    }
}
