package generic_lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Get_Env_Prop {
	String system_path = System.getProperty("user.dir");
	static Properties prop = null;
	static String ENV_File_path = System.getProperty("user.dir")
			+ "\\EVN_Properties_file";

	static String ui_url;

	static {

		prop = new Properties();
		try {
			prop.load(new FileInputStream(ENV_File_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ui_url = prop.getProperty("ui_url");
	}

}
