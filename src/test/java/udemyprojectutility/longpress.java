package udemyprojectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class longpress extends BaseTest_1{

	@Test
	public void longpressgesture() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		Thread.sleep(2000);
	WebElement ele = 	driver.findElement(By.xpath("//android.widget.TextView[@text ='People Names']"));
//	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
//	int xOffset = ele.getLocation().getX() + ele.getSize().getWidth() / 2;
//    int yOffset = ele.getLocation().getY() + ele.getSize().getHeight() / 2;
//
//    ImmutableMap<String, ? extends Object> longPressArgs = ImmutableMap.of(
//            "element", ((RemoteWebElement) ele).getId(),
//            "x", xOffset,
//            "y", yOffset,
//            "duration", 2000
//    );
//
//    driver.executeScript("mobile: longClickGesture", longPressArgs);
	longPressAction(ele);
	String menuText = driver.findElement(By.id("android:id/title")).getText();
	Assert.assertEquals(menuText, "Sample menu");
	Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}

}
