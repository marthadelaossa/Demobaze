package com.demoblaze.driver;



import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(String url,String browser ){
        switch (browser){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options());
                break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options());
                break;
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }


    public static ChromeOptions options(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        return (options);
    }
}
