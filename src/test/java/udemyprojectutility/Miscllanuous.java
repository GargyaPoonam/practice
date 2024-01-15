package udemyprojectutility;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Miscllanuous  {
	AndroidDriver driver;
@Test
	public void WifiSetting() throws MalformedURLException, InterruptedException {
//  ConfigiureAppium(); //if we use testng class no need to call method on beforeclass 
//	List<WebElement> elements = driver.findElements(AppiumBy.accessibilityId("preference"));
//	if (!elements.isEmpty()) {
//	    elements.get(0).click(); // Click the first element if present
//	} else {
//	    System.out.println("Element with accessibility id 'preference' not found.");
//	}
	UiAutomator2Options option = new UiAutomator2Options();
	option.setDeviceName("Pixel_4_API_31");
	option.setApp("/Users/poonamsharma/Documents/Udemy /resources/ApiDemos-debug.apk");
    driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), option);
	Thread.sleep(3000);
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	Thread.sleep(1000);
	driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("android:id/checkbox")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	Thread.sleep(1000);
	String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
    Assert.assertEquals(alertTitle,"WiFi settings");
    Thread.sleep(1000);
    driver.setClipboardText("Poonam Wifi"); //for copy
    Thread.sleep(1000);
    driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText()); // for paste
    Thread.sleep(1000);

    driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // for enter click
    Thread.sleep(1000);

 driver.pressKey(new KeyEvent(AndroidKey.BACK)); // for back button
 Thread.sleep(1000);

    driver.pressKey(new KeyEvent(AndroidKey.HOME)); // for minimize
//   driver.pressKey(new KeyEvent(AndroidKey.BACK));
   // driver.pressKey(new KeyEvent(AndroidKey.));



    Thread.sleep(1000);
//	DeviceRotation landscape = new DeviceRotation(0,0,90);
//	driver.rotate(landscape);
//	teardown();
	}

}
