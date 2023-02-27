package com.JuaraCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumFrame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/frames");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println(title);

        WebElement frameSample = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameSample);

        String txtFrame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtFrame);

        //keluar dari frame
        driver.switchTo().defaultContent();
        String desFrame = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText();
        System.out.println(desFrame);


        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("(//li[@id='item-4'])[2]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Browser Quit");
    }
}
