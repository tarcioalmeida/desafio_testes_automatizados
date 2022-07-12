package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.ResultadoDaBuscaPage;
import managers.PageObjectManager;

import java.time.Duration;

public class BuscaPorPalavraDeArtigoExistenteStep {

    WebDriver driver;
    HomePage homePage;
    ResultadoDaBuscaPage resultadoDaBuscaPage;
    PageObjectManager pageObjectManager;

    @Given("que o usuário esteja na homepage do blog do agi")
    public void que_o_usuario_esteja_na_homepage_do_blog_do_agi() {

        System.setProperty("webdriver.chrome.driver","A:\\\\code\\\\testes_automatizados\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navegarParaHomePage();
    }

    @When("ele clicar na lupa")
    public void ele_clicar_na_lupa() {
        homePage.clicarLupa();
    }

    @When("inserir o termo de busca {string}")
    public void inserir_o_termo_de_busca(String string) {
        homePage.inserirCampoBusca(string);
    }
    @When("clicar em Pesquisar")
    public void clicar_em_pesquisar() {
        homePage.clicarBtPesquisar();
    }
    @Then("será redirecionado para tela de resultado da busca")
    public void será_redirecionado_para_tela_de_resultado_da_busca() {
        resultadoDaBuscaPage = pageObjectManager.getResultadoDaBuscaPage();

    }
    @Then("será exibido o artigo {string}")
    public void será_exibido_o_artigo(String string) {
        Assert.assertEquals(true,resultadoDaBuscaPage.encontrouArtigo(string));
        driver.quit();
    }
}
