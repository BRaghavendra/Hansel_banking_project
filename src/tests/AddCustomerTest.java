package tests;

import generic_lib.Ui_base;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import actions.AddcustomerActions;
import actions.CustomersListActions;
import actions.Homepageactions;

public class AddCustomerTest {

	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public void add_customer(){
		AddcustomerActions.add_new_customer("cust1_fn", "cust1_ln", "1111");
	}

	@Test
	public static void duplicate_customer_error_validation() {
		AddcustomerActions.add_new_customer("cust2_fn", "cust2_ln", "1111");
		AddcustomerActions.add_new_customer("cust2_fn", "cust2_ln", "1111");
	}

	@Test
	public static void create_same_customer_with_diff_pincode() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"cust3_fn", "cust3_ln", "1111");
		List<String> cust4_details = AddcustomerActions.add_new_customer(
				cust_details.get(0), cust_details.get(1), "2222");
		CustomersListActions.search_customer(cust4_details.get(0));
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
