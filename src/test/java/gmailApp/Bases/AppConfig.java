/**
 * 
 */
package gmailApp.Bases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author anjan.k.dey
 *
 */
public class AppConfig {

	/**
	 * 
	 */
	public AppConfig() {
		// TODO Auto-generated constructor stub
		Properties prop = new Properties();
	    InputStream input = null;

	    try {

	        input = new FileInputStream("config.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        System.out.println(prop.getProperty("database"));
	        System.out.println(prop.getProperty("dbuser"));
	        System.out.println(prop.getProperty("dbpassword"));
	        System.out.println(prop.getProperty("DebugMode"));

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	}

}
