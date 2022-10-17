package com.agileCrmAutomation;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinks2 extends BaseClass {

	//public static void main(String[] args) {
	@Test
	public void main() {
		BrokenLinks2 LV = new BrokenLinks2();
		LV.launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> elements = driver.findElements(By.tagName("a"));

		for (WebElement e : elements) {
			String link = e.getAttribute("href");
			if (link != null && link.startsWith("http"))
				try {
			 		URL url = new URL(link);

					URLConnection urlconnection = url.openConnection();
					HttpsURLConnection connection = (HttpsURLConnection) urlconnection;
					connection.connect();

					int statuscode = connection.getResponseCode();
					if (statuscode != 200) {
						System.out.println(statuscode + " URL" + link);
					}

					connection.disconnect();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

		}
	}
}
