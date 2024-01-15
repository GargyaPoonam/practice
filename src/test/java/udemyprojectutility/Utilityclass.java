package udemyprojectutility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Utilityclass {
	static AppiumDriverLocalService service ;
	AppiumServiceBuilder service1;
 
	public static AndroidDriver getdriver() throws MalformedURLException {
		
//	  DesiredCapabilities caps = new DesiredCapabilities();
 UiAutomator2Options  option = new UiAutomator2Options();
	  service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
			service.start();
				
// caps.setCapability("deviceName", "Pixel_4_API_31");
// caps.setCapability("app", "/Users/poonamsharma/Downloads/resources/ApiDemos-debug.apk");
// 
	  option.setDeviceName("Pixel_4_API_31");
	  option.setApp("/Users/poonamsharma/Downloads/General-Store.apk");
	  
// AndroidDriver driver  = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);


	 AndroidDriver driver  = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),option);	
	 return driver;	
  }
}
