package tests;

import java.util.List;

import generic_lib.Ui_base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import actions.AddcustomerActions;
import actions.CustomerLoginactions;
import actions.CustomersListActions;
import actions.DepositActions;
import actions.Homepageactions;
import actions.OpenAccountActions;
import actions.TransactionsActions;
import actions.WithdrawActions;

public class TransactionsTest {
	@BeforeClass
	public static void open_browser() {
		Ui_base.get_url("firefox");
	}

	@BeforeMethod
	public static void manager_login() {
		Homepageactions.click_manager_login();
	}

	@Test
	public static void verify_customer_account_transactions() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"transaction_acc1_fn", "transaction_acc1_ln", "5566");
		List<String> acc_details = OpenAccountActions.open_customer_account(
				cust_details.get(0) + " " + cust_details.get(1), "Pound");
		CustomersListActions
				.vaidate_customer_details_with_account_no(acc_details.get(0));
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(90);
		DepositActions.account_deposit(50);
		WithdrawActions.account_withdraw(70);
		WithdrawActions.account_withdraw(60);
		DepositActions.account_deposit(20);
		WithdrawActions.account_withdraw(20);
		TransactionsActions.select_start_date(0);
		TransactionsActions.select_end_date(0);
		TransactionsActions.get_credit_debit_transaction_count();
	}

	@Test
	public void verify_deposit_withdraw_diff_currency_type_acc_details() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"transaction_acc2_fn", "transaction_acc2_ln", "5566");
		String cust_name = cust_details.get(0) + " " + cust_details.get(1);
		List<String> dollar_acc_details = OpenAccountActions
				.open_customer_account(cust_name, "Dollar");
		List<String> rupee_acc_details = OpenAccountActions
				.open_customer_account(cust_name, "Rupee");
		List<String> pound_acc_details = OpenAccountActions
				.open_customer_account(cust_name, "Pound");
		CustomerLoginactions.customer_login(cust_name);
		CustomerLoginactions
				.select_customer_perticuar_accont_number(dollar_acc_details
						.get(0));
		CustomerLoginactions.validate_account_details(
				dollar_acc_details.get(0), dollar_acc_details.get(1));
		DepositActions.account_deposit(50);
		WithdrawActions.account_withdraw(30);
		DepositActions.account_deposit(5);
		WithdrawActions.account_withdraw(3);
		TransactionsActions.select_start_date(0);
		TransactionsActions.select_end_date(0);
		TransactionsActions.get_credit_debit_transaction_count();
		TransactionsActions.click_back_button();
		CustomerLoginactions
				.select_customer_perticuar_accont_number(rupee_acc_details
						.get(0));
		CustomerLoginactions.validate_account_details(rupee_acc_details.get(0),
				rupee_acc_details.get(1));
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(50);
		DepositActions.account_deposit(20);
		WithdrawActions.account_withdraw(100);
		TransactionsActions.select_start_date(0);
		TransactionsActions.select_end_date(0);
		TransactionsActions.get_credit_debit_transaction_count();
		TransactionsActions.click_back_button();
		CustomerLoginactions
				.select_customer_perticuar_accont_number(pound_acc_details
						.get(0));
		CustomerLoginactions.validate_account_details(pound_acc_details.get(0),
				pound_acc_details.get(1));
		DepositActions.account_deposit(20);
		WithdrawActions.account_withdraw(20);
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(50);
		DepositActions.account_deposit(50);
		WithdrawActions.account_withdraw(25);
		TransactionsActions.select_start_date(0);
		TransactionsActions.select_end_date(0);
		TransactionsActions.get_credit_debit_transaction_count();
		TransactionsActions.click_back_button();
	}

	@Test
	public static void verify_reset_transactions() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"transaction_acc3_fn", "transaction_acc3_ln", "5566");
		OpenAccountActions.open_customer_account(
				cust_details.get(0) + " " + cust_details.get(1), "Pound");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(90);
		DepositActions.account_deposit(50);
		WithdrawActions.account_withdraw(70);
		WithdrawActions.account_withdraw(60);
		DepositActions.account_deposit(20);
		WithdrawActions.account_withdraw(20);
		TransactionsActions.select_start_date(0);
		TransactionsActions.select_end_date(0);
		TransactionsActions.get_credit_debit_transaction_count();
		TransactionsActions.click_reset_button();
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		CustomerLoginactions.click_transactions();
		TransactionsActions.get_credit_debit_transaction_count();
	}

	@Test
	public static void verify_transactions_from_last_10_days() {
		List<String> cust_details = AddcustomerActions.add_new_customer(
				"transaction_acc4_fn", "transaction_acc4_ln", "5566");
		OpenAccountActions.open_customer_account(
				cust_details.get(0) + " " + cust_details.get(1), "Pound");
		CustomerLoginactions.customer_login(cust_details.get(0) + " "
				+ cust_details.get(1));
		DepositActions.account_deposit(100);
		WithdrawActions.account_withdraw(90);
		DepositActions.account_deposit(50);
		WithdrawActions.account_withdraw(70);
		WithdrawActions.account_withdraw(60);
		DepositActions.account_deposit(20);
		WithdrawActions.account_withdraw(20);
		TransactionsActions.select_start_date(-10);
		TransactionsActions.select_end_date(0);
		TransactionsActions.get_credit_debit_transaction_count();
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
