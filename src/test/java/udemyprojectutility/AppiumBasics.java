package udemyprojectutility;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumBasics  extends BaseTest_1{
	
@Test
	public void WifiSetting() throws MalformedURLException, InterruptedException {
		//ConfigiureAppium(); //if we use testng class no need to call method on beforeclass 
//	List<WebElement> elements = driver.findElements(AppiumBy.accessibilityId("preference"));
//	if (!elements.isEmpty()) {
//	    elements.get(0).click(); // Click the first element if present
//	} else {
//	    System.out.println("Element with accessibility id 'preference' not found.");
//	}
	Thread.sleep(3000);
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		//teardown();
	}

}
