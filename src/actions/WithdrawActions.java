package actions;

import static org.testng.Assert.assertEquals;
import generic_lib.Driver;
import locators.CustomerLogin;
import locators.Withdrawl;

import org.openqa.selenium.By;

public class WithdrawActions {
	public static int account_withdraw(int amount) {
		try {
			CustomerLoginactions.click_Withdrawl();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Enter amount to withdraw: " +amount);
		String balance_before = Driver.driver.findElement(
				By.xpath(CustomerLogin.balance_amount)).getText();
		int balance_before_withdraw = Integer.parseInt(balance_before);
		Driver.driver.findElement(By.xpath(Withdrawl.withdraw_amount_input))
				.clear();
		Driver.driver.findElement(By.xpath(Withdrawl.withdraw_amount_input))
				.sendKeys(String.valueOf(amount));
		Driver.driver.findElement(By.xpath(Withdrawl.withdraw_button)).click();
		if (Driver.driver.findElement(By.xpath(Withdrawl.withdraw_msg))
				.getText()
				.equalsIgnoreCase(Withdrawl.withdraw_success_msg_text)) {
			System.out.println(Withdrawl.withdraw_success_msg_text);
			String balance_after = Driver.driver.findElement(
					By.xpath(CustomerLogin.balance_amount)).getText();
			int balance_after_withdraw = Integer.parseInt(balance_after);
			if (amount<=1000000000){
			assertEquals(balance_before_withdraw - amount,
					balance_after_withdraw,
					"Failed to withdraw deposit balance");}
			System.out.println("Balance amount validated successfully");
			System.out.println("Balance amount after deposit is:"
					+ balance_after_withdraw + "");
		} else {
			assertEquals(
					Driver.driver.findElement(By.xpath(Withdrawl.withdraw_msg))
							.getText(), Withdrawl.withdraw_error_msg_text);
			System.out.println(Withdrawl.withdraw_error_msg_text);
		}
		return amount;
	}
}
