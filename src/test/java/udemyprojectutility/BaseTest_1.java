package udemyprojectutility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest_1 {
	AndroidDriver driver;
	AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigiureAppium() throws MalformedURLException {
//		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("0.0.0.0").usingPort(4723).build();
//			service.start();
////			
//			UiAutomator2Options option = new UiAutomator2Options();
//			option.setApp("/Users/poonamsharma/Documents/Udemy/resources/ApiDemos-debug.apk");
//			option.setDeviceName("Pixel_7_Pro_API_34");
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_7_Pro_API_34");
        caps.setCapability("app", "/Users/poonamsharma/Documents/resources/ApiDemos-debug.apk");

       driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        
  }
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

	}
	public void scollEndAction() {
		boolean canScrollMore;
		do {
	canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile:scrollGesture",ImmutableMap.of("left", 100,"top", 100,"width", 200,"height",200,"direction", "down","percent",3.0));

		} while(canScrollMore);
	}
	public void SwipeAction(WebElement firstImage, String direction) {
		  ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture"
			        , ImmutableMap.of("elementId", ((RemoteWebElement) firstImage).getId(), "direction", direction, "percent", 0.75));

	}
	public void DragAction(WebElement source) {
		 ((JavascriptExecutor)driver).executeScript("mobile: dragGesture",
				  ImmutableMap.of("elementId",((RemoteWebElement)source).getId(),"endX" ,619, "endY",560));
	}
	
	@AfterClass
	public void teardown() {
	//	driver.quit();
		
		
	}

}
