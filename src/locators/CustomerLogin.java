package locators;

public class CustomerLogin {
	public static String customer_select = "//select[@class='form-control ng-pristine ng-untouched ng-valid']";
	public static String login_button = "//button[text()='Login']";
	public static String logout_button = "//button[@ng-show='logout']";
	public static String depost = "//button[contains(text(),'Deposit') and @ng-click='deposit()']";
	public static String withdrawl = "//button[contains(text(),'Withdrawl') and @ng-click='withdrawl()']";
	public static String transactions = "//button[@ng-click='transactions()']";
	public static String account_number = "//strong[@class='ng-binding'][1]";
	public static String balance_amount = "//strong[@class='ng-binding'][2]";
	public static String currency_type = "//strong[@class='ng-binding'][3]";
	public static String open_account_validator = "//span[@ng-show='noAccount']";
	public static String account_select = "accountSelect";
	public static String wecome_message="//strong[contains(text(),'Welcome')]";
}