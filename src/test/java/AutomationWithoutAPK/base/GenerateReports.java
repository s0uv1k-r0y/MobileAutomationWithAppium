package AutomationWithoutAPK.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReports {

    static ExtentReports extentReports;

    public static ExtentReports generateReporterObject() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//ExtentReport.html");
        reporter.config().setReportName("Appium Test Results");
        reporter.config().setDocumentTitle("TEST RESULTS");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);

        extentReports.setSystemInfo("Tester", "v1nz");
        extentReports.setSystemInfo("OS", "Android");
        return extentReports;
    }
}
