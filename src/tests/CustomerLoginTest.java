package tests;

import generic_lib.Ui_base;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.AddcustomerActions;
import actions.CustomerLoginactions;
import actions.CustomersListActions;
import actions.Homepageactions;
import actions.OpenAccountActions;

public class CustomerLoginTest {
	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public static void verify_customer_successful_login_message() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust_login1_fn", "cust_login1_ln", "4444");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Rupee");

		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
	}

	@Test
	public static void Verify_open_account_message_by_customer_login() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust_login2_fn", "open_login2_fn", "4444");
		CustomersListActions.vaidate_customer_details(cust_details.get(0),
				cust_details.get(1), cust_details.get(2));
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
	}

	@Test
	public void verify_acc_details() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust_login3_fn", "open_login3_fn", "4444");
		List<String> acc_details = OpenAccountActions.open_customer_account(
				cust_details.get(0) + " " + cust_details.get(1), "Rupee");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		CustomerLoginactions.validate_account_details(acc_details.get(0),
				acc_details.get(1));
	}

	@Test
	public void verify_same_currency_type_acc_details()
			throws InterruptedException {
		String currency_type = "Rupee";
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust_login11_fn", "cust_login11_ln", "4444");
		String cust_name = cust_details.get(0) + " " + cust_details.get(1);
		List<String> rupee_acc_details1 = OpenAccountActions
				.open_customer_account(cust_name, currency_type);
		List<String> rupee_acc_details2 = OpenAccountActions
				.open_customer_account(cust_name, currency_type);
		List<String> rupee_acc_details3 = OpenAccountActions
				.open_customer_account(cust_name, currency_type);
		CustomerLoginactions.customer_login(cust_name);
		CustomerLoginactions
				.select_customer_perticuar_accont_number(rupee_acc_details1
						.get(0));
		CustomerLoginactions.validate_account_details(
				rupee_acc_details1.get(0), currency_type);
		CustomerLoginactions
				.select_customer_perticuar_accont_number(rupee_acc_details2
						.get(0));
		CustomerLoginactions.validate_account_details(
				rupee_acc_details2.get(0), currency_type);
		CustomerLoginactions
				.select_customer_perticuar_accont_number(rupee_acc_details3
						.get(0));
		CustomerLoginactions.validate_account_details(
				rupee_acc_details3.get(0), currency_type);
	}

	@Test
	public void verify_diff_currency_type_acc_details() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust_login10_fn", "cust_login10_ln", "4444");
		String cust_name = cust_details.get(0) + " " + cust_details.get(1);
		List<String> dollar_acc_details = OpenAccountActions
				.open_customer_account(cust_name, "Dollar");
		CustomersListActions
				.vaidate_customer_details_with_account_no(dollar_acc_details
						.get(0));
		List<String> rupee_acc_details = OpenAccountActions
				.open_customer_account(cust_name, "Rupee");
		CustomersListActions
				.vaidate_customer_details_with_account_no(rupee_acc_details
						.get(0));
		List<String> pound_acc_details = OpenAccountActions
				.open_customer_account(cust_name, "Pound");
		CustomersListActions
				.vaidate_customer_details_with_account_no(pound_acc_details
						.get(0));
		CustomerLoginactions.customer_login(cust_name);
		CustomerLoginactions
				.select_customer_perticuar_accont_number(dollar_acc_details
						.get(0));
		CustomerLoginactions.validate_account_details(
				dollar_acc_details.get(0), dollar_acc_details.get(1));
		CustomerLoginactions
				.select_customer_perticuar_accont_number(rupee_acc_details
						.get(0));
		CustomerLoginactions.validate_account_details(rupee_acc_details.get(0),
				rupee_acc_details.get(1));
		CustomerLoginactions
				.select_customer_perticuar_accont_number(pound_acc_details
						.get(0));
		CustomerLoginactions.validate_account_details(pound_acc_details.get(0),
				pound_acc_details.get(1));
	}

	@AfterMethod
	public static void navigate_home_page() {
		CustomerLoginactions.customer_logout();
	}

	@AfterClass
	public static void quit_driver() {
		Ui_base.quit_driver();
	}

}
