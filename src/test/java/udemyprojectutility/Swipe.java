package udemyprojectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe extends BaseTest_1{
  @Test
  public void SwipeFunction() throws InterruptedException {
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  Thread.sleep(1000);
	  driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	  Thread.sleep(1000);
	  driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	  Thread.sleep(1000);
	  WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
//	  Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
//	  ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture"
//		        , ImmutableMap.of("elementId", ((RemoteWebElement) firstImage).getId(), "direction", "left", "percent", 0.75));
//	  Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");

	  SwipeAction(firstImage, "left");
	  
  }


}

