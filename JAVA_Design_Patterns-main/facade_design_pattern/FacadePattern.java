package facade_design_pattern;

import java.sql.Driver;

//creation of class Firefox
class Firefox {

    //getter getFirefoxDriver()
    public static Driver getFirefoxDriver() {
        return null;
    }

    //method to generate HTML report
    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    //method to generate Junit report
    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

class Chrome {

    //getter to get Chrome Driver
    public static Driver getChromeDriver() {
        return null;
    }

    //method to generate HTML report
    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    //method to generate Junit report
    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

class WebExplorerHelperFacade {
    public static void generateReports(String explorer, String report, String test) {
        // Declare a variable to hold the driver
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                //if Firefox requested get Firefox driver
                driver = Firefox.getFirefoxDriver();
                switch (report) {
                    case "html":
                        //if html requested generate HTML report
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        //if junit requested generate Junit report
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                //if Chrome requested get Chrome driver
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        //if html requested generate HTML report
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        //if junit requested generate Junit report
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        String test = "CheckElementPresent";

        //generate reports
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }

}