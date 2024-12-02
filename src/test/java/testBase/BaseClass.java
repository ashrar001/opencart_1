package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Logger logger;
	public static WebDriver driver;
	public Properties p;
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","br"})
	public void setup(String os,String br) throws IOException {
		p=new Properties(); //we will create object of properies class
		FileInputStream fis=new FileInputStream("./src//test//resources//config.properties");
		p.load(fis);
		
		logger=LogManager.getLogger(this.getClass());
		
		//grid 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("android")) {
				cap.setPlatform(Platform.ANDROID);
			}
			else {
				System.out.println("No matching operating system...");
				return;
			}
			//
			switch(br.toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome");break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			case "firefox": cap.setBrowserName("Firefox");break;
			default: System.out.println("No matching browser");return;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.1.7:4444"),cap);
		}
		//local
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			case "edge" : driver=new EdgeDriver();break;
			default: System.out.println("invalid browser");return;
			}
		}
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String randomalphabet = RandomStringUtils.randomAlphabetic(5);
		return randomalphabet;
	}

	public String randomNumeric() {
		String randomnumeric = RandomStringUtils.randomNumeric(10);
		return randomnumeric;
	}

	public String randomAlphaNumeric() {
		String randomalpha = RandomStringUtils.randomAlphabetic(5);
		String randomnumeric = RandomStringUtils.randomNumeric(5);
		return randomalpha +"*"+ randomnumeric;

	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
