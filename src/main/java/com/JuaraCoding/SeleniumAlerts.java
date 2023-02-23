package com.JuaraCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumAlerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/alerts");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println(title);
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("timerAlertButton")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("admin");
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Browser Quit");
    }
}
