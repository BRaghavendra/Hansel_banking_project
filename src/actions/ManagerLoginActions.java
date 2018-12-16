package actions;

import generic_lib.Driver;
import locators.ManagerLogin;

import org.openqa.selenium.By;

public class ManagerLoginActions {

	public static void click_add_customer() {
		Driver.driver.findElement(By.xpath(ManagerLogin.add_customer)).click();
		System.out.println("Add customer button clicked");
	}

	public static void click_open_account() {
		Driver.driver.findElement(By.xpath(ManagerLogin.open_account)).click();
		System.out.println("Open account button clicked");
	}

	public static void click_customers_button() {
		Driver.driver.findElement(By.xpath(ManagerLogin.customer_list)).click();
		System.out.println("Customes list button clicked");
	}
}
