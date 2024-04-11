package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class secondPage extends basePage{
    
	WebDriver driver;
	public secondPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath="//a[@id='news_text_title']")
	public
	List<WebElement>second_news;
	
	
	
    public List<String>printTwoNews(){
		
		List<String>ell=new ArrayList<String>();
		for(WebElement i:second_news) {
			ell.add(i.getText());
		
		}
		return ell;
		
	}
}
