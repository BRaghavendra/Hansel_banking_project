package actions;

import static org.testng.Assert.assertTrue;
import generic_lib.Driver;
import generic_lib.Webdriver_common_lib;

import java.util.Arrays;
import java.util.List;

import locators.OpenAccount;

import org.openqa.selenium.By;

public class OpenAccountActions {
	public static List<String> open_customer_account(String customer_name,
			String currency_type) {
		System.out.println("Opening new account for customer with: "
				+ customer_name + " with currency type: " + currency_type + "");
		ManagerLoginActions.click_open_account();
		Webdriver_common_lib
				.webelement_select(Driver.driver.findElement(By
						.name(OpenAccount.customer_select)), customer_name);
		Webdriver_common_lib
				.webelement_select(Driver.driver.findElement(By
						.name(OpenAccount.currency_select)), currency_type);
		Driver.driver.findElement(By.xpath(OpenAccount.process_button)).click();
		String open_account_success_message = Webdriver_common_lib
				.alert_getText();
		String[] msg_arr = open_account_success_message.split(":");
		String acc_no = msg_arr[1];
		System.out.println("Customer Account Number is : " + acc_no);
		assertTrue(
				open_account_success_message
						.contains(OpenAccount.open_account_msg),
				"Failed to validate Actual message "
						+ open_account_success_message + " and Actual message "
						+ OpenAccount.open_account_msg + " ");
		System.out.println("Actual message " + open_account_success_message
				+ " and Actualt message " + OpenAccount.open_account_msg
				+ " validated as same");
		Webdriver_common_lib.accept_alert();
		System.out.println("New account successfully created for customer: "
				+ customer_name + " with currency type: " + currency_type + "");
		CustomersListActions
				.vaidate_customer_details_with_account_no(acc_no);
		return Arrays.asList(acc_no, currency_type);
	}
}
