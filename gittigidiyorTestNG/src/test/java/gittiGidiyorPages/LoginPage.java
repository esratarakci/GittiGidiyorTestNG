/**
 * 
 */
package gittiGidiyorPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author esra.tarakci
 *
 */
public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private BaseFunctions bf;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 90);
		bf = new BaseFunctions(driver);
	}

	@FindBy(xpath = "//*[text()='Giriş Yap']")
	private WebElement loginButtonHover;

	@FindBy(xpath = "//*[text()='ile giriş yapın']/following::input[2]")
	private WebElement usernameInput;

	@FindAll({ @FindBy(xpath = "//*[text()='Göster']/following::input[1]"),
			@FindBy(xpath = "//*[text()='ile giriş yapın']/following::input[3]") })
	private WebElement passwordInput;

	@FindBy(xpath = "//*[text()='Sms ile Giriş Yap']/preceding::input[1]")
	private WebElement loginButton;

	@FindBy(xpath = "(//a[@type=\"button\"]/span)[1]")
	private WebElement loginButtonScreen;
//------------------------------------------methods----------------------------------------------------------------

	public void login(String username, String password, String environment) throws InterruptedException {

		driver.navigate().to(environment);
		bf.hoverElement(loginButtonHover, driver);
		bf.clicke(loginButtonScreen);
		Thread.sleep(2000);
		bf.write(usernameInput, username);
		bf.write(passwordInput, password);
		bf.clicke(loginButton);
	}

}
