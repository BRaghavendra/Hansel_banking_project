package generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public static WebDriver driver = null;

	public static WebDriver getBrowser(String browser_name) {
		if (browser_name.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\Browser_drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\Browser_drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\Browser_drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		System.out.println(""+browser_name+" selected");
		return driver;
	}
}
