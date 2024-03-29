package tricentis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Repository {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", Testdata.ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(Testdata.Website_path);
	}

	@Test(priority = 0)
	public void Login_link() {
		driver.findElement(Locators.Login).click();
	}

	@Test(priority = 1)
	public void validate_LoginMessage() {

		String WelcomeMessage = driver.findElement(Locators.WelcomeMessage).getText();
		Assert.assertEquals(WelcomeMessage, Testdata.Welcome_Message);
	}

	@Test(priority = 2)
	public void Login() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Emailid)).isDisplayed();
		driver.findElement(Locators.Emailid).sendKeys(Testdata.Email_id);
		driver.findElement(Locators.Password).sendKeys(Testdata.Password);
		driver.findElement(Locators.Loginbutton).click();
	}

	@Test(priority = 3)
	public void UserAccountID_Validation() {

		String UserAccountID = driver.findElement(Locators.UseraccountID).getText();
		Assert.assertEquals(UserAccountID, Testdata.Email_id);
	}

	@Test(priority = 4)
	public void Clearing_ShoppingCart() {
		driver.findElement(Locators.Shoppingcart_link).click();
		
		driver.findElement(Locators.Remove_From_cart_checkbox).click();
		driver.findElement(Locators.UpdateShoppingCart_button).click();
	}

	@Test(priority = 5)
	public void Selection_Books() {
		driver.findElement(Locators.Books_Topmenu).click();
		driver.findElement(Locators.Books_categories).click();
		driver.findElement(Locators.Book_selection).click();
	}

	@Test(priority = 6)
	public void Validation_Books() {
		wait = new WebDriverWait(driver, 30);

		String Price = driver.findElement(Locators.Book_price).getText();
		System.out.println("Price:" + Price);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Book_quantity));
		driver.findElement(Locators.Book_quantity).clear();
		driver.findElement(Locators.Book_quantity).sendKeys(Testdata.quantity);
		driver.findElement(Locators.Book_AddtoCart_button).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.bar_notification));
		String bartext = driver.findElement(Locators.bar_notification).getText();
		System.out.println("Bar-text:" + bartext);
		Assert.assertEquals(bartext, Testdata.Bartext);
		driver.findElement(Locators.Shoppingcart_link).click();
		By subtotal = By.xpath("(((//span[contains(text(),'" + Price
				+ "') and @class='product-unit-price']/parent::td)/following::td/input[@value='" + Testdata.quantity
				+ "'])/parent::td)/following-sibling::td/span[@class='product-subtotal']");

		String Sub_total_Actual = driver.findElement(subtotal).getText();

		int price = Integer.parseInt(Price);
		System.out.println("Price after splitting:" + price);

		int quantity = Integer.parseInt(Testdata.quantity);
		int Sub_total_actual = Integer.parseInt(Sub_total_Actual);
		int Sub_total_Expected = price * quantity;
		Assert.assertEquals(Sub_total_actual, Sub_total_Expected);

	}

	@Test(priority = 7)
	public void Checkout() {
		driver.findElement(Locators.I_Agree_checkbox).click();
		driver.findElement(Locators.Checkout_button).click();
	}

	@Test(priority = 8)
	public void Billing_Address() {
		new Select(driver.findElement(Locators.Billing_Address)).selectByVisibleText("New Address");
		driver.findElement(Locators.FirstName).clear();
		driver.findElement(Locators.FirstName).sendKeys(Testdata.FirstName);
		driver.findElement(Locators.LastName).clear();
		driver.findElement(Locators.LastName).sendKeys(Testdata.LastName);
		driver.findElement(Locators.Email).clear();
		driver.findElement(Locators.Email).sendKeys(Testdata.email);
		new Select(driver.findElement(Locators.Country)).selectByVisibleText("India");
		driver.findElement(Locators.City).sendKeys(Testdata.City);
		driver.findElement(Locators.Address1).sendKeys(Testdata.address1);
		driver.findElement(Locators.Address2).sendKeys(Testdata.address2);
		driver.findElement(Locators.ZIP).sendKeys(Testdata.ZIP);
		driver.findElement(Locators.Phonenumber).sendKeys(Testdata.phoneno);
		driver.findElement(Locators.Continuebutton_BillingAddress).click();

	}

	@Test(priority = 9)
	public void Shipping_Address() {
		System.out.println("Shipping Address:" + Testdata.Shipping_Address);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Shipping_Address));
		new Select(driver.findElement(Locators.Shipping_Address)).selectByVisibleText(Testdata.Shipping_Address);
		driver.findElement(Locators.Continuebutton_ShippingAddress).click();
	}

	@Test(priority = 10)
	public void Shipping_Method() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Next_Day_Air));
		driver.findElement(Locators.Next_Day_Air).click();
		driver.findElement(Locators.Continue_ShippingMethod).click();

	}

	@Test(priority = 11)
	public void Payment_Method() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.COD));
		driver.findElement(Locators.COD).click();
		driver.findElement(Locators.Continue_Paymentmethod).click();

	}

	@Test(priority = 12)
	public void Payment_Information_Validation() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Validate_COD_Msg));
		String COD_Msg = driver.findElement(Locators.Validate_COD_Msg).getText();
		Assert.assertEquals(COD_Msg, Testdata.COD_Msg);
		driver.findElement(Locators.Continue_PaymentInformation).click();
	}

	@Test(priority = 13)
	public void Confirm_Order() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Locators.Confirm_button));
		driver.findElement(Locators.Confirm_button).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Confirmation_Message));
		String ConfirmationMessage = driver.findElement(Locators.Confirmation_Message).getText();
		Assert.assertEquals(ConfirmationMessage, Testdata.ConfirmationMessage);
		String Orderno = driver.findElement(Locators.OrderNumber).getText();
		System.out.println("Orderno:" + Orderno);
		driver.findElement(Locators.ContinueOrderConfirmation).click();
	}

	@Test(priority = 14)
	public void Logout() {
		driver.findElement(Locators.LogoutButton).click();
	}

	@AfterTest
	public void Teardown() {
		driver.quit();
	}

}
