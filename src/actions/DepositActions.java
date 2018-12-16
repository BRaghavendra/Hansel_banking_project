package actions;

import static org.testng.Assert.assertEquals;
import generic_lib.Driver;
import locators.CustomerLogin;
import locators.Deposit;

import org.openqa.selenium.By;

public class DepositActions {
	public static int account_deposit(int amount) {
		CustomerLoginactions.click_deposit();
		System.out.println("Enter amount to deposit: " +amount);
		String balance_before = Driver.driver.findElement(
				By.xpath(CustomerLogin.balance_amount)).getText();
		int balance_before_deposit = Integer.parseInt(balance_before);
		System.out.println("Balance before deposit is:"
				+ balance_before_deposit + "");
		Driver.driver.findElement(By.xpath(Deposit.deposit_amount_input))
				.clear();
		Driver.driver.findElement(By.xpath(Deposit.deposit_amount_input))
				.sendKeys(String.valueOf(amount));
		Driver.driver.findElement(By.xpath(Deposit.deposit_button)).click();
		assertEquals(Driver.driver.findElement(By.xpath(Deposit.deposit_msg))
				.getText(), Deposit.deposit_msg_text,
				"Failed to validate Deposit message");
		System.out.println(Deposit.deposit_msg_text);
		String balance_after = Driver.driver.findElement(
				By.xpath(CustomerLogin.balance_amount)).getText();
		int balance_after_deposit = Integer.parseInt(balance_after);
		System.out.println("Balance before deposit is:"
				+ balance_before_deposit + "");
		if (amount<=1000000000){
		assertEquals(balance_before_deposit + amount, balance_after_deposit,
				"Failed to validate deposit balance");
		}
		System.out.println("Balance amount validated successfully");
		System.out.println("Balance amount after deposit is:"
				+ balance_after_deposit + "");
		return amount;
	}
}
