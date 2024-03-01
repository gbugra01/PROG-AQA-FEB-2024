package org.prog.web.Homeworks;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Amazon {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            //TODO:GO TO GOOGLE
            driver.get("https:www.google.com");
            //TODO:REJECT COOKIES
            driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[1]")).click();
            //TODO:SEARCH AMAZON
            WebElement googleSearchBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
            googleSearchBox.sendKeys("Amazon"+ Keys.ENTER);
            //TODO:CLICK "www.amazon.com"
            WebElement amazonSite=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='LC20lb MBeuO DKV0Md'])[1]")));
            amazonSite.click();
            //TODO:PRINT ON CONSOLE SITE TITLE AND CURRENT URL
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            //TODO CHECK SITE TITLE  CONTAINS "Amazon"
            if (driver.getTitle().contains("Amazon")){
                System.out.println("TEST PASSED!!!");
            }else {
                System.out.println("TEST FAILED!!!");
            }
            //TODO:PRINT ON CONSOLE SITE WINDOW HANDLE CODE
            String amazonHandle= driver.getWindowHandle();
            System.out.println("Amazon Handle Code : " + amazonHandle);
            //TODO:SEARCH "NUTELLA"
            WebElement searchBoxAmazon= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
            searchBoxAmazon.sendKeys("Nutella"+Keys.ENTER);
            //TODO:CONFIRM SEARCH RESULT CONTAIN "Nutella"
            WebElement nutellaSearch=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")));
            if(nutellaSearch.getText().contains("Nutella")){
                System.out.println("TEST PASSED SUCCESFULL SEARCH");
            }else {
                System.out.println("TEST FAILED!!!");
            }
            //TODO:PRINT FIRST SEARCH RESULT
            WebElement firstElementNutella=driver.findElement(By.xpath("//*[text()='Nutella B-ready Wafer filled with Nutella 32 pieces (T2 x 16)']"));
            System.out.println(firstElementNutella.getText());
            //TODO:GO AGAIN MAIN PAGE AMAZON
            WebElement amazonLogo=driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
            amazonLogo.click();
        }finally {
           driver.quit();
        }
    }
}