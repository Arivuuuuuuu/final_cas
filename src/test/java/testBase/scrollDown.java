package testBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scrollDown {
	
	WebDriver driver;
	
	public scrollDown(WebDriver driver){
		this.driver=driver;
	}
	
	public void Scrol(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",e);
	}

	public void executeScript(String string) {
		// TODO Auto-generated method stub
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("windows.open()");
		
	}

}
