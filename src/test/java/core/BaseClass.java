package core;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/** @class: BaseClass
@desc: class for to add generic functions
 */

public class BaseClass{
	final static int DEFAULTWAITSECONDS = 10;
	final static int MINWAITSECONDS = 1;
	final static int MAXWAITSECONDS = 30;
	protected final static String CSS = "CSS";
	protected static String XPATH = "XPATH";

	public static WebDriver driver;
	public static Properties properties;
	public static String currentReportDirectroy;
	public static String currentImage;
	public static File DestFile;
	public static String  projectName;


	/**
	@function: readProperty
	@desc: to read property file
	@param: password - user password
	@return: void 
	@throws IOException
	 */
	public static void readProperty() throws IOException {
		String sConfig = System.getProperty("user.dir");
		sConfig = sConfig + "/src/test/resources/configuration/configuration.properties";
		FileReader reader=new FileReader(sConfig); 
		properties =new Properties();
		properties.load(reader);
	}

	/**
	@function: takeSnapShot
	@desc: this function used to take screen shoot of current browser window and copy in to current report folder
	@param: 
	@return: void 
	@throws IOException 
	 */
	public static void takeSnapShot() throws IOException{
		DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		currentImage=sdf.format(date)+".png";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		DestFile=new File(currentReportDirectroy+"//"+currentImage);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	/**
	@function: reportDirectory
	@desc: this function used to create report directory path
	@param: String-projectName
	@return: String-reportPath 
	 */
	public static String reportDirectory() {
		DateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		currentReportDirectroy=System.getProperty("user.dir")+"//output//"+sdf.format(date);
		return currentReportDirectroy;
	}
	public static String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
