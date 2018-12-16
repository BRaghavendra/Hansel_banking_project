package actions;

import static org.testng.Assert.assertTrue;
import generic_lib.Driver;
import generic_lib.Webdriver_common_lib;
import locators.CustomerLogin;
import locators.OpenAccount;
import org.openqa.selenium.By;

public class CustomerLoginactions {
	public static void customer_login(String customer_name) {
		Homepageactions.click_customer_login();
		System.out.println("select customer name: "+customer_name);
		Webdriver_common_lib.webelement_select(Driver.driver.findElement(By
				.xpath(CustomerLogin.customer_select)), customer_name);
		Driver.driver.findElement(By.xpath(CustomerLogin.login_button)).click();
		if (Driver.driver.findElement(
				By.xpath(CustomerLogin.open_account_validator)).isDisplayed() == true) {
			System.out.println(Driver.driver.findElement(
					By.xpath(CustomerLogin.wecome_message)).getText()
					+ " "
					+ Driver.driver.findElement(
							By.xpath(CustomerLogin.open_account_validator))
							.getText());
		} else {
			System.out.println(Driver.driver.findElement(
					By.xpath(CustomerLogin.wecome_message)).getText());
			System.out.println("Customer: "+customer_name+" login successful");
		}
	}

	public static void customer_logout() {
		Driver.driver.findElement(By.xpath(CustomerLogin.logout_button))
				.click();
		assertTrue(
				Driver.driver.findElement(By.id(OpenAccount.customer_select))
						.isDisplayed() == true,
				"Falied to verify customer logout");
		System.out.println("Customer logout successful");
		Homepageactions.click_home_button();
	}

	public static void select_customer_perticuar_accont_number(String acc_no) {
		Webdriver_common_lib.webelement_select(
				Driver.driver.findElement(By.id(CustomerLogin.account_select)),
				acc_no);
		System.out.println("Account number: "+acc_no+" selected from dropdown");
	}

	public static void click_Withdrawl() throws InterruptedException {
		Driver.driver.findElement(By.xpath(CustomerLogin.withdrawl)).click();
		Thread.sleep(1000);
		System.out.println("Withdraw button clicked");
	}

	public static void click_deposit() {
		Driver.driver.findElement(By.xpath(CustomerLogin.depost)).click();
		System.out.println("Deposit button clicked");
	}

	public static void click_transactions() {
		Driver.driver.findElement(By.xpath(CustomerLogin.transactions)).click();
		System.out.println("Transaction button clicked");
	}

	public static void validate_account_details(String acc_no,
			String currency_type) {
		assertTrue(
				Driver.driver
						.findElement(By.xpath(CustomerLogin.account_number))
						.getText().contains(acc_no),
				"Failed to validate account number: " + acc_no + "");
		System.out.println("Account number: " + acc_no
				+ " validation successful.");
		assertTrue(
				Driver.driver
						.findElement(By.xpath(CustomerLogin.currency_type))
						.getText().equals(currency_type),
				"Failed to validate currency type: " + currency_type + "");
		System.out.println("Account number: " + acc_no + " Currency type: "
				+ currency_type + " validation successful.");
	}
}
