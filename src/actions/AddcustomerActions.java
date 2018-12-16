package actions;

import static org.testng.Assert.assertTrue;
import generic_lib.Driver;
import generic_lib.Webdriver_common_lib;

import java.util.Arrays;
import java.util.List;

import locators.AddCustomer;

import org.openqa.selenium.By;

public class AddcustomerActions {

	public static List<String> add_new_customer(String firstname,
			String lastname, String postcode) {
		ManagerLoginActions.click_add_customer();
		System.out.println("Enter customer firstname: "+firstname);
		Driver.driver.findElement(By.xpath(AddCustomer.firstname)).clear();
		Driver.driver.findElement(By.xpath(AddCustomer.firstname)).sendKeys(
				firstname);
		System.out.println("Enter customer lastname: "+lastname);
		Driver.driver.findElement(By.xpath(AddCustomer.lastname)).clear();
		Driver.driver.findElement(By.xpath(AddCustomer.lastname)).sendKeys(
				lastname);
		System.out.println("Enter customer postcode: "+postcode);
		Driver.driver.findElement(By.xpath(AddCustomer.postcode)).clear();
		Driver.driver.findElement(By.xpath(AddCustomer.postcode)).sendKeys(
				postcode);
		System.out.println("Click add customer button");
		Driver.driver.findElement(By.xpath(AddCustomer.add_customer_button))
				.click();
		String add_customer_message = Webdriver_common_lib.alert_getText();
		if (add_customer_message.contains("duplicate")) {
			assertTrue(
					add_customer_message
							.equals(AddCustomer.duplicate_customer_error_msg),
					"Failed to validate Actual message " + add_customer_message
							+ " and Expected message "
							+ AddCustomer.duplicate_customer_error_msg + " ");
			System.out.println("Actual message " + add_customer_message
					+ " and Expected message "
					+ AddCustomer.duplicate_customer_error_msg
					+ " validated as same");
		} else {
			assertTrue(
					add_customer_message
							.contains(AddCustomer.customer_added_success_msg),
					"Failed to validate Actual message " + add_customer_message
							+ " and Expected message "
							+ AddCustomer.customer_added_success_msg + " ");
			System.out.println("Expected message "
					+ AddCustomer.customer_added_success_msg
					+ " found in Actual message" + add_customer_message);
		}
		Webdriver_common_lib.accept_alert();
		System.out.println("New customer successfully created with firstname: "
				+ firstname + " lastname: " + lastname + " with postcode: "
				+ postcode + "");
		CustomersListActions.vaidate_customer_details(firstname, lastname,
				postcode);
		return Arrays.asList(firstname, lastname, postcode);

	}
}
