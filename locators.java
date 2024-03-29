package tricentis;

import org.openqa.selenium.By;

public class Locators {
	public static By Loginid = By.xpath("//a[@class='ico-login']");
	public static By WelcomeMessage = By.xpath("//h1");
	public static By Emailid_personal = By.xpath("//input[@id='Email']");
	public static By Password = By.xpath("//input[@id='Password']");
	public static By Loginbutton = By.xpath("//input[@type='submit' and @value='Log in']");
	public static By UseraccountID = By.xpath("(//a[@class='account' ])[1]");
	public static By Shoppingcart_link = By.xpath("(//a[@class='ico-cart' ])[1]");
	public static By Remove_From_cart_checkbox = By.xpath("//input[@type='checkbox' and @name='removefromcart']");
	public static By UpdateShoppingCart_button = By.xpath("//input[@type='submit' and @name='updatecart']");
	public static By Books_Topmenu = By.xpath("//ul[@class='top-menu']/li/a[contains(text(),'Books')]");
	public static By Books_categories = By.xpath(
			"(//div[@class='title']/strong[contains(text(),'Categories')]//following::div/ul/li/a[contains(text(),'Books')])");
	public static By Book_selection = By.xpath(
			"((((//input/parent::div[@class='buttons'])/parent::div[@class='add-info'])/parent::div[@class='details'])/preceding-sibling::div)[1]");
	public static By Book_price = By.xpath("//div[@class='product-price']/span");
	public static By Book_AddtoCart_button = By.xpath("//input[@type='button' and @id='add-to-cart-button-13']");
	public static By Book_quantity = By.xpath("//input[@class='qty-input']");
	public static By AddtoCart_button = By.xpath("(//div[@class='add-info']/div[@class='buttons']/input)[1]");
	public static By Price = By
			.xpath("(//div[@class='add-info']/div[@class='prices']/span[@class='price actual-price'])[1]");
	public static By bar_notification = By.xpath("//p[@class='content']");

	public static By I_Agree_checkbox = By.xpath("//input[@id='termsofservice']");
	public static By Checkout_button = By.xpath("//button[@id='checkout']");

	/* Billing Address */

	public static By Billing_Address = By.xpath("//select[@name='billing_address_id']");
	public static By FirstName = By.xpath("//input[@id='BillingNewAddress_FirstName']");
	public static By LastName = By.xpath("//input[@name='BillingNewAddress.LastName']");
	public static By Email = By.xpath("//input[@id='BillingNewAddress_Email']");
	public static By Company = By.xpath("//input[@id='BillingNewAddress_Company']");
	public static By Country = By.xpath("//select[@id='BillingNewAddress_CountryId']");

	public static By State = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']");
	public static By City = By.xpath("//input[@id='BillingNewAddress_City']");

	public static By Address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
	public static By Address2 = By.xpath("//input[@id='BillingNewAddress_Address2']");
	public static By ZIP = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	public static By Phonenumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	public static By FaxNumber = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
	public static By Continuebutton_BillingAddress = By
			.xpath("//div[@id='billing-buttons-container']/input[@type='button' and @title='Continue']");

	/* Shipping Address */
	public static By Shipping_Address = By.xpath("//select[@name='shipping_address_id']");
	public static By Continuebutton_ShippingAddress = By
			.xpath("//div[@id='shipping-buttons-container']/input[@type='button']");
	/* Shipping Methods */
	public static By Next_Day_Air = By.xpath("//input[@id='shippingoption_1']");
	public static By Continue_ShippingMethod = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");

	/* Payment methods */
	public static By COD = By.xpath("//input[@id='paymentmethod_0' and @value='Payments.CashOnDelivery']");
	public static By Continue_Paymentmethod = By.xpath("//input[@class='button-1 payment-method-next-step-button']");

	/* Payment Information */
	public static By Validate_COD_Msg = By.xpath("//td/p");
	public static By Continue_PaymentInformation = By.xpath("//input[@class='button-1 payment-info-next-step-button']");

	/* Confirm Button */
	public static By Confirm_button = By
			.xpath("//input[@type='button' and @class='button-1 confirm-order-next-step-button']");

	/* Confirmation Message */
	public static By Confirmation_Message = By.xpath("//div[@class='title']");
	public static By OrderNumber = By.xpath("//ul[@class='details']/li[1]");
	public static By ContinueOrderConfirmation = By.xpath("//input[@class='button-2 order-completed-continue-button']");

	/* Logout */
	public static By LogoutButton = By.xpath("//a[@class='ico-logout']");


}
