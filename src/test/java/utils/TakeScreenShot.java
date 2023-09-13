package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class TakeScreenShot {
    public static void takeSnapShot(WebDriver webdriver, String file) throws Exception{


        TakesScreenshot scrShot =((TakesScreenshot)webdriver);


        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        String localDir = System.getProperty("user.dir");
        File DestFile=new File(localDir+"/src/test/java/screenshots/"+file);


        FileUtils.copyFile(SrcFile, DestFile);

    }
}
