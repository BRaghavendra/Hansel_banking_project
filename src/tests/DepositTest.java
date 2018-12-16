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
import actions.DepositActions;
import actions.Homepageactions;
import actions.OpenAccountActions;

public class DepositTest {
	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public static void verify_deposit_successful() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"deposit_cust1_fn", "deposit_cust1_ln", "1234");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Rupee");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
	}

	@Test
	public static void verify_multiple_deposit_successful() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"deposit_cust2_fn", "deposit_cust2_ln", "1234");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Dollar");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
		DepositActions.account_deposit(50);
		DepositActions.account_deposit(25);
		DepositActions.account_deposit(10);
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
