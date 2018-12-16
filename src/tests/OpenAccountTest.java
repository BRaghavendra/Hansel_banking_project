package tests;

import generic_lib.Ui_base;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.AddcustomerActions;
import actions.Homepageactions;
import actions.OpenAccountActions;

public class OpenAccountTest {
	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public void open_customer_account() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"open_cust_acc1_fn", "open_cust_acc1_ln", "5555");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Rupee");
	}

	@Test
	public void verify_diff_currency_type_acc_details()
			throws InterruptedException {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"open_cust_acc4_fn", "open_cust_acc4_ln", "5555");
		String cust_name = cust_details.get(0) + " " + cust_details.get(1);
		OpenAccountActions.open_customer_account(cust_name, "Dollar");
		OpenAccountActions.open_customer_account(cust_name, "Rupee");
		OpenAccountActions.open_customer_account(cust_name, "Pound");
	}

	@AfterMethod
	public static void navigate_home_page() {
		Homepageactions.click_home_button();
	}

	@AfterClass
	public static void quit_driver() {
		Ui_base.quit_driver();
	}

}
