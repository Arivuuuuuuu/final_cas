package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class baseClass {
    
	protected WebDriver driver;
	
	public Logger logger;
	
	public Properties p;
	
	public static TakesScreenshot ts;
	
	@Parameters({"browser"})
	@BeforeClass
	
	public void setup(String n) throws IOException {
		
		logger=LogManager.getLogger(this.getClass());
		
		FileInputStream file=new FileInputStream(".//src/test/resources/configg.properties");
		p=new Properties();
		p.load(file);
		
		
		if(n.toLowerCase().equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(n.toLowerCase().equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		
		
	    
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("appURL"));
		
		ts=(TakesScreenshot)driver;
		
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	

	
	public static String captureScreen(String name) {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//TakesScreenshot tc= (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String targetPath=System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timeStamp+".png";
		
		File target=new File(targetPath);
		
		src.renameTo(target);
		
		return targetPath;
	}
	
	
}
