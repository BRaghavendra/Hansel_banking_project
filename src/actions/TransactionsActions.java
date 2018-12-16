package actions;

import static org.testng.Assert.assertTrue;
import generic_lib.Driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import locators.Transactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransactionsActions {
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static void select_start_date(int days) {
		// if days=0 today,if >0 next dates,if <0 previous dates
		CustomerLoginactions.click_transactions();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		String time_stamp = Driver.driver.findElement(
				By.id(Transactions.start_date_picker)).getAttribute("min");
		String[] time_stamp_arr = time_stamp.split("T");
		String input_time = dateFormat.format(cal.getTime()) + "T"
				+ time_stamp_arr[1] + ".000";
		System.out.println("Start date selected as:" + input_time);
		Driver.driver.findElement(By.id(Transactions.start_date_picker))
				.clear();
		Driver.driver.findElement(By.id(Transactions.start_date_picker))
				.sendKeys(input_time);
	}

	public static void select_end_date(int days) {
		// if days=0 today,if >0 next dates,if <0 previous dates
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		String time_stamp = Driver.driver.findElement(
				By.id(Transactions.start_date_picker)).getAttribute("max");
		String[] time_stamp_arr = time_stamp.split("T");
		String input_time = dateFormat.format(cal.getTime()) + "T"
				+ time_stamp_arr[1] + ".000";
		System.out.println("End date selected as:" + input_time);
		Driver.driver.findElement(By.id(Transactions.end_date_picker)).clear();
		Driver.driver.findElement(By.id(Transactions.end_date_picker))
				.sendKeys(input_time);
	}

	public static void get_credit_debit_transaction_count() {
		List<WebElement> debit_trans_count = Driver.driver.findElements(By
				.xpath("//td[text()='Debit']"));
		System.out.println("Debit transaction for perticular date interval is:"
				+ debit_trans_count.size());
		List<WebElement> credit_trans_count = Driver.driver.findElements(By
				.xpath("//td[text()='Credit']"));
		System.out
				.println("Credit transaction for perticular date interval is:"
						+ credit_trans_count.size());
	}

	public static void click_reset_button() {
		Driver.driver.findElement(By.xpath(Transactions.reset_button)).click();
		List<WebElement> credit_trans_count = Driver.driver.findElements(By
				.xpath("//td[text()='Credit']"));
		List<WebElement> debit_trans_count = Driver.driver.findElements(By
				.xpath("//td[text()='Debit']"));
		assertTrue(debit_trans_count.size() == 0,
				"Found debit transaction for this account after reset");
		System.out.println("NO debit transaction for this account after reset");
		assertTrue(credit_trans_count.size() == 0,
				"Found debit transaction for this account after reset");
		System.out
				.println("NO credit/debit transactions found for this account after reset");
	}

	public static void click_back_button() {
		Driver.driver.findElement(By.xpath(Transactions.back_button)).click();
		System.out.println("Back button clicked");
	}
}
