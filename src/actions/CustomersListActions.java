package actions;

import static org.testng.Assert.assertEquals;
import generic_lib.Driver;

import java.util.List;

import locators.CustomersList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomersListActions {
	public static void search_customer(String search_string) {
		ManagerLoginActions.click_customers_button();
		System.out.println("Search Customers with search string: "
				+ search_string);
		Driver.driver.findElement(By.xpath(CustomersList.customer_searchbox))
				.clear();
		Driver.driver.findElement(By.xpath(CustomersList.customer_searchbox))
				.sendKeys(search_string);
		List<WebElement> customer_list = Driver.driver.findElements(By
				.xpath("//td[text()='" + search_string + "']"));
		System.out.println("Customers found with Search string "
				+ search_string + " is: " + customer_list.size());
	}

	public static void delete_customer(String first_name, String last_name,
			String postcode) {
		search_customer(first_name);
		System.out.println("Search Customer : " + first_name + "" + " "
				+ last_name + " with postcode " + postcode + " to delete");
		System.out.println();
		Driver.driver.findElement(
				By.xpath("//td[text()='" + first_name
						+ "']/following-sibling::td[text()='" + last_name
						+ "']/following-sibling::td[text()='" + postcode + "']"
						+ "/following-sibling::td/button[text()='Delete']"))
				.click();
		List<WebElement> customer_list = Driver.driver.findElements(By
				.xpath("//td[text()='" + first_name
						+ "']/following-sibling::td[text()='" + last_name
						+ "']" + "/following-sibling::td[text()='" + postcode
						+ "']"));
		assertEquals(customer_list.size(), 0,
				"Failed to validate customer account entries");
		System.out.println("Customer : " + first_name + "" + " " + last_name
				+ " with postcode " + postcode + " deleted successfully");
	}

	public static void delete_customer_using_accout_number(String cust_acc_no) {
		search_customer(cust_acc_no);
		System.out.println("Find Customer account number: " + cust_acc_no
				+ " to delete");
		Driver.driver.findElement(
				By.xpath("//td[span[contains(text(),'" + cust_acc_no
						+ "')]]/following-sibling::td/button")).click();
		List<WebElement> customer_list = Driver.driver.findElements(By
				.xpath("//td[span[contains(text(),'" + cust_acc_no + "')]]"));
		assertEquals(customer_list.size(), 0,
				"Failed to validate customer account:" + cust_acc_no
						+ " entries");
		System.out.println("Customer account: " + cust_acc_no
				+ " deleted successfully");
	}

	public static void vaidate_customer_details(String first_name,
			String last_name, String postcode) {
		search_customer(first_name);
		System.out.println("Search for Customer details with: " + first_name + "" + " " + last_name
				+ " with postcode " + postcode + "");
		List<WebElement> customer_list = Driver.driver.findElements(By
				.xpath("//td[text()='" + first_name
						+ "']/following-sibling::td[text()='" + last_name
						+ "']" + "/following-sibling::td[text()='" + postcode
						+ "']"));
		assertEquals(customer_list.size(), 1,
				"Failed to validate customer account details");
		System.out
				.println("Customer account details verified successfully firstname: "
						+ first_name
						+ " lastname: "
						+ last_name
						+ " and postcode: " + postcode + "");
	}

	public static void vaidate_customer_details_with_account_no(
			String account_no) {
		System.out.println("Search Customer account number: " + account_no + "");
		ManagerLoginActions.click_customers_button();
		Driver.driver.findElement(By.xpath(CustomersList.customer_searchbox))
				.clear();
		Driver.driver.findElement(By.xpath(CustomersList.customer_searchbox))
				.sendKeys(account_no);
		List<WebElement> customer_list = Driver.driver.findElements(By
				.xpath("//td[span[contains(text(),'" + account_no + "')]]"));
		assertEquals(customer_list.size(), 1,
				"Failed to validate customer account details");
		System.out
				.println("Customer account details verified with account number: "
						+ account_no + " successfully");
	}

}
