/**
 * 
 */
package gittiGidiyorPages;

import static org.testng.AssertJUnit.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author esra.tarakci
 *
 */
public class ChartPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private BaseFunctions bf;
	ProductPage pp;
	Logger log = LogManager.getLogger(ChartPage.class);

	public ChartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 90);
		bf = new BaseFunctions(driver);
		this.pp = new ProductPage(driver);
	}

	@FindBy(xpath = "//*[text()='Sepete Git']")
	private WebElement chartButton;

	@FindBy(xpath = "//*[@class='total-price']")
	private WebElement chartPrice;

	@FindBy(xpath = "//*[@class='total-price']/preceding::span[2]")
	private WebElement plusButton;

	@FindBy(xpath = "//*[@class='total-price']/preceding::input[1]")
	private WebElement quantityValue;

	@FindBy(xpath = "(//*[text()='Sil'])[1]")
	private WebElement deleteButton;

	@FindBy(xpath = "//h2[text()='Sepetinizde ürün bulunmamaktadır.']")
	private WebElement chartIsEmpty;

	public void chartProcess(String prodPriceValue) throws InterruptedException {
		bf.clicke(chartButton);
		String chartPriceValue = chartPrice.getText().replaceAll(" TL", "");
		System.out.println("Sepet Sayfa Fiyati=" + chartPriceValue);
		assertEquals("Fiyatlar esit degil", prodPriceValue, chartPriceValue);
		bf.clicke(plusButton);
		String quantity = quantityValue.getAttribute("value");
		System.out.println("Urun adedi=" + quantity);
		assertEquals("2 adet Urun Bulunmamaktadir", quantity, "2");
		bf.clicke(deleteButton);
		Thread.sleep(1000);
		String chartIsEmptyLabel = chartIsEmpty.getText();
		System.out.println(chartIsEmptyLabel);
		assertEquals("Sepetteki urun silinemedi", chartIsEmptyLabel, "Sepetinizde ürün bulunmamaktadır.");
		log.info("Chart Process is Done");
	}
}