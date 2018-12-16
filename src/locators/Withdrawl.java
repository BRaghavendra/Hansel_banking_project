package locators;

public class Withdrawl {
	public static String withdraw_amount_input = "//input[@placeholder='amount']";
	public static String withdraw_button = "//button[@type='submit']";
	public static String withdraw_msg = "//span[@class='error ng-binding']";
	public static String withdraw_error_msg_text = "Transaction Failed. You can not withdraw amount more than the balance.";
	public static String withdraw_success_msg_text = "Transaction successful";
}
