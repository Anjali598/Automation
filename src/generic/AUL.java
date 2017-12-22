package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//Automation utility Library
public class AUL {

	public static String getProperty(String path,String key) {
		String v=" ";
		try {
			Properties p =new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}catch(Exception e) {
			
		}
		return v;
	}
public static void takePhoto(String folder, String TestName,WebDriver driver) {
	String dataTime=new Date().toString().replaceAll(":", "_");
	
	TakesScreenshot t= (TakesScreenshot)driver;
	File srcfile = t.getScreenshotAs(OutputType.FILE);
	String despath = folder+TestName+dataTime+".png";
	try {
		FileUtils.copyFile(srcfile, new File(despath)); 
	}catch(Exception e) {
}

}

}
