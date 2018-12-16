package tests;

import java.util.List;

import generic_lib.Ui_base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import actions.AddcustomerActions;
import actions.CustomersListActions;
import actions.Homepageactions;
import actions.OpenAccountActions;

public class CustomerListTest {
	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public void Create_customer() {
		AddcustomerActions.add_new_customer("cust1_fn", "cust1_ln", "1111");
	}

	@Test
	public static void validate_customer_details_using_account_number() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust16_fn", "cust16_ln", "7777");
		OpenAccountActions.open_customer_account(cust_details.get(0) + " "
				+ cust_details.get(1), "Rupee");
	}

	@Test
	public static void verify_customer_count_with_same_firstname() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust5_fn", "cust5_ln", "9999");
		AddcustomerActions.add_new_customer(cust_details.get(0), "abc", "9999");
		AddcustomerActions.add_new_customer(cust_details.get(0), "xxx", "9999");
		AddcustomerActions.add_new_customer(cust_details.get(0), "yyy", "9999");
		CustomersListActions.search_customer(cust_details.get(0));
	}

	@Test
	public static void verify_customer_count_with_same_lastname() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust6_fn", "cust6_ln", "9999");
		AddcustomerActions.add_new_customer("cust7_fn", cust_details.get(1),
				"9999");
		AddcustomerActions.add_new_customer("cust8_fn", cust_details.get(1),
				"9999");
		AddcustomerActions.add_new_customer("cust9_fn", cust_details.get(1),
				"9999");
		CustomersListActions.search_customer(cust_details.get(1));
	}

	@Test
	public static void verify_customer_count_with_same_postcode() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust10_fn", "cust10_ln", "8888");
		AddcustomerActions.add_new_customer("cust11_fn", "cust11_ln",
				cust_details.get(2));
		AddcustomerActions.add_new_customer("cust12_fn", "cust12_ln",
				cust_details.get(2));
		AddcustomerActions.add_new_customer("cust13_fn", "cust13_ln",
				cust_details.get(2));
		CustomersListActions.search_customer(cust_details.get(2));
	}

	@Test
	public static void delete_customer() {
		AddcustomerActions.add_new_customer("cust16_fn", "cust16_ln", "7777");
		CustomersListActions.delete_customer("cust16_fn", "cust16_ln", "7777");
	}

	@Test
	public static void delete_bulk_customer() {
		for (int i = 0; i < 4; i++) {
			AddcustomerActions.add_new_customer("bulk_cust_fn", "cust2" + i
					+ "_ln", "4444");
		}
		for (int i = 0; i < 4; i++) {
			CustomersListActions.delete_customer("bulk_cust_fn", "cust2" + i
					+ "_ln", "4444");
		}
	}

	@Test
	public static void delete_customer_using_account_number() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust16_fn", "cust16_ln", "7777");
		List<String> acc_details = OpenAccountActions.open_customer_account(
				cust_details.get(0) + " " + cust_details.get(1), "Rupee");
		CustomersListActions.delete_customer_using_accout_number(acc_details
				.get(0));
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
