package generic_lib;

import java.util.concurrent.TimeUnit;

public class Ui_base {

	public static void get_url(String browser_name) {
		Driver.getBrowser(browser_name);
		System.out.println("Maximize window");
		Driver.driver.manage().window().maximize();
		System.out.println("Navigate to url: "+Get_Env_Prop.ui_url);
		Driver.driver.get(Get_Env_Prop.ui_url);
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void quit_driver() {
		Driver.driver.quit();
	}

	public static void close_browser() {
		Driver.driver.close();
	}
}