package generic_lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_common_lib {
	public static WebDriverWait wait = new WebDriverWait(Driver.driver, 20);

	public static void waitForXpathPresent(String wbXpath) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(wbXpath)));
	}

	public static void waitForIdPresent(String wbId) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(wbId)));
	}

	public static void waitForNamePresent(String wbName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(wbName)));
	}

	public static boolean verifyText(WebElement wb, String exp_str) {
		boolean flag = false;
		String actval = wb.getText();
		if (exp_str.equals(actval)) {
			flag = true;
			System.out.println(exp_str + "data verified==pass");
		} else {
			System.out.println(exp_str + "data  not verified==fail");
		}
		return flag;
	}

	public static void webelement_select(WebElement wb, String text) {
		Select sel = new Select(wb);
		sel.selectByVisibleText(text);
	}

	public static String alert_getText() {
		Driver.driver.switchTo().alert();
		String alert_text = Driver.driver.switchTo().alert().getText();
		return alert_text;
	}

	public static void dismiss_alert() {
		Driver.driver.switchTo().alert();
		Driver.driver.switchTo().alert().dismiss();
	}

	public static void accept_alert() {
		Driver.driver.switchTo().alert();
		Driver.driver.switchTo().alert().accept();
	}
}
