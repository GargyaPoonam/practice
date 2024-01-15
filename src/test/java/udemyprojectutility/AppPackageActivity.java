package udemyprojectutility;


import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;

import java.net.URL;

import org.testng.annotations.Test;public class AppPackageActivity  {
//	//AndroidDriver driver;
//    AppiumDriver driver;
//
//@Test
//	public void WifiSetting() throws MalformedURLException, InterruptedException {
////  ConfigiureAppium(); //if we use testng class no need to call method on beforeclass 
////	List<WebElement> elements = driver.findElements(AppiumBy.accessibilityId("preference"));
////	if (!elements.isEmpty()) {
////	    elements.get(0).click(); // Click the first element if present
////	} else {
////	    System.out.println("Element with accessibility id 'preference' not found.");
////	}
//	UiAutomator2Options option = new UiAutomator2Options();
//	option.setDeviceName("Pixel_4_API_31");
//	option.setApp("/Users/poonamsharma/Documents/Udemy /resources/ApiDemos-debug.apk");
//    driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), option);
//    Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
//   driver.startActivity(activity);
//	
	AppiumDriver driver;

    @Test
    public void WifiSetting() throws MalformedURLException, InterruptedException {
        UiAutomator2Options option = new UiAutomator2Options();
        option.setDeviceName("Pixel_4_API_31");
        option.setApp("/Users/poonamsharma/Documents/Udemy/resources/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), option);
        // Use the AppiumDriver class for the startActivity method
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
      //  ((StartsActivity) driver).startActivity(activity);
//  
	}

}
