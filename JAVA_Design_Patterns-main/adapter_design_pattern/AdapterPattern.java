package adapter_design_pattern;

//interface for a web driver.
interface WebDriver {
    public void getElement();

    public void selectElement();
}

//implementation of the WebDriver interface for Chrome.
class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from ChromeDriver");

    }

}


//class of IEDriver
class IEDriver {
    public void findElement() {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement() {
        System.out.println("Click element from IEDriver");
    }

}

//Adapter pattern works as a bridge between two incompatible interfaces.
class WebDriverAdapter implements WebDriver {
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();

    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }

}

public class AdapterPattern {
    public static void main(String[] args)  //main method
    {
        ChromeDriver a = new ChromeDriver(); //creating new object ChromeDriver()
        a.getElement();    //method calling
        a.selectElement();

        IEDriver e = new IEDriver();     //creating new object IEDriver()
        e.findElement();        //method calling
        e.clickElement();

        WebDriver wID = new WebDriverAdapter(e);     //creating new object WebDriverAdapter()
        wID.getElement();            //method calling
        wID.selectElement();

    }
}