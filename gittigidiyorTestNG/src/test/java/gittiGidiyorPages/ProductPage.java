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
public class ProductPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private BaseFunctions bf;
	Logger log = LogManager.getLogger(ProductPage.class);

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 90);
		bf = new BaseFunctions(driver);
	}

	@FindBy(xpath = "//*[text()='BUL']/preceding::input[1]")
	private WebElement productSearch;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "(//*[text()='Çerez Politikası']/following::span[1])[1]")
	private WebElement closePrivacy;

	@FindBy(xpath = "//*[text()='2']")
	private WebElement secondPage;

	@FindBy(xpath = "(//ul[@class='clearfix'])[2]//following::li[2]")
	private WebElement secondPageClick;

	@FindBy(xpath = "//*[text()='Akıllı Sıralama']/following::li[1]")
	private WebElement firstProduct;

	@FindBy(xpath = "//button[contains(text(),'Sepete Ekle')]")
	private WebElement addChart;

	@FindBy(xpath = "//span[text()='Öne Çıkan Taksitler']/preceding::span[6]")
	private WebElement prodPrice;

	public String urunArama(String searchValue) throws InterruptedException {
		bf.write(productSearch, searchValue);
		bf.clicke(searchButton);
		bf.clicke(closePrivacy);
		bf.moveToElement(secondPage, driver);
		bf.clicke(secondPage);
		String currentStatus = secondPage.getAttribute("class");
		assertEquals("2. Sayfa Acilamadi", currentStatus, "current");
		System.out.println(currentStatus);
		bf.clicke(firstProduct);
		String prodPriceValue = prodPrice.getText().replaceAll(" TL", "");
		System.out.println("Urunlerim Sayfa Fiyati=" + prodPriceValue);
		bf.clicke(addChart);
		log.info("Product Process is Done");
		return prodPriceValue;

	}
}