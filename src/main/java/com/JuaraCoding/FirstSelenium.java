package com.JuaraCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/text-box");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //locator
        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println(title);
        driver.findElement(By.id("userName")).sendKeys("juaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("juaraCoding");
        driver.findElement(By.id("permanentAddress")).sendKeys("juaraCoding");
        //scroll
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("submit")).click();
        delay(2);
        delay(1);
        driver.quit();
        System.out.println("Browser Quit");
    }
     static void delay(long detik){
         try {
             Thread.sleep(detik*1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
}