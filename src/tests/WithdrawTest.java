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
import actions.WithdrawActions;

public class WithdrawTest {
	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public static void verify_withdraw_successful() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"withdraw_cust1_fn", "withdraw_cust1_ln", "4321");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Rupee");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(100);
	}

	@Test
	public static void verify_multiple_withdraw_successful() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"withdraw_cust2_fn", "withdraw_cust2_ln", "4321");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Pound");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(1000);
		WithdrawActions.account_withdraw(400);
		WithdrawActions.account_withdraw(100);
		WithdrawActions.account_withdraw(50);
		WithdrawActions.account_withdraw(10);
	}

	@Test
	public static void verify_withdraw_error_message() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"withdraw_cust3_fn", "withdraw_cust3_ln", "4321");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Pound");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(120);
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
