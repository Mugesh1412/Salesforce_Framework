package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseClass {                      

	public static WebDriver driver=null;
	public static FileInputStream file;
	public static Properties data;
	public  JavascriptExecutor js = (JavascriptExecutor) driver;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	

	@BeforeSuite
	public void setup() {
		Extent_Report ExReport = new Extent_Report();
		extent=ExReport.Get_Reports();
	}
	@BeforeClass
	public void openBroswer() throws IOException {
		String broswerName = getValues().getProperty("Broswer");

		if (broswerName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions CO = new ChromeOptions();
			CO.addArguments("--disable-notifications");
			driver=new ChromeDriver(CO);
		}

		else if (broswerName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions EO = new EdgeOptions();
			EO.addArguments("--disable-notifications");
			driver=new EdgeDriver(EO);
		}

		else {
			System.out.println("we do not support this broswer");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.get(getValues().getProperty("URL"));

	}

	@AfterClass
	public void closeBroswer() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}


	public  Properties getValues() throws IOException {



		file = new FileInputStream("./src/test/resources/resources/globalData.txt");
		data = new Properties();
		data.load(file);
		return data;



	}
	
	
	public String takeScreenShot(String name) throws IOException {

		TakesScreenshot tss = (TakesScreenshot)driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshoot/" + name + ".png");
		FileUtils.copyFile(source, target); 
		return System.getProperty("user.dir")+ "//Screenshoot//" + name + ".png";

       
	}      
                     

}