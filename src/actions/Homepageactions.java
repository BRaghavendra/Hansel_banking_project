package actions;

import generic_lib.Driver;
import locators.HomePage;

import org.openqa.selenium.By;

public class Homepageactions {
	public static void click_home_button() {
		Driver.driver.findElement(By.xpath(HomePage.home_button)).click();
		System.out.println("Homepage button clicked");
	}

	public static void click_manager_login() {
		Homepageactions.click_home_button();
		Driver.driver.findElement(By.xpath(HomePage.manager_login)).click();
		System.out.println("Manager login button clicked ");
	}

	public static void click_customer_login() {
		Homepageactions.click_home_button();
		Driver.driver.findElement(By.xpath(HomePage.customer_login)).click();
		System.out.println("Customer login button clicked");
	}
}
