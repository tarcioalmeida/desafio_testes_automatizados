package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultadoDaBuscaPage {

    WebDriver driver;

    public ResultadoDaBuscaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "search-open")
    WebElement lupa;

    @FindAll(@FindBy(how = How.XPATH, using = "//article"))
    List<WebElement> resultadosBusca;

    public boolean encontrouArtigo (String termo){
        for (int i = 0; i < resultadosBusca.size(); i++){
            if (resultadosBusca.get(i).getText().contains(termo)){
                try { Thread.sleep(2000);}
                catch (InterruptedException e) {}
                return true;
            }
        }
        return false;
    }

}