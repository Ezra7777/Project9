package Project9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyProject9 {
    @Test
    public void test(){
   //
        System.setProperty("webdriver.chrome.driver", "/Users/EsraOzturk/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https:////test-basqar.mersys.io/");
        driver.manage().window().maximize();

        driver.findElement( By.cssSelector( "[formcontrolname=\"username\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"password\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "button[aria-label=\"LOGIN\"]" ) ).click();

        WebDriverWait wait = new WebDriverWait( driver, 5 );
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );


        // to select "Setup", the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(6)" ) ).click();
        // to select "Parameters", the first child of  the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(6) > .children > :nth-child(1)" ) ).click();
        // to select "Nationalities", the forth child of the first child of  the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(6) > .children > :nth-child(1) > .children > :nth-child(1)" ) ).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();
        // driver.findElement(By.xpath("//*[@class='mat-mini-fab mat-button-base mat-accent']")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("Mygroupp");
        driver.findElement(By.cssSelector("#mat-select-2")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("01/06/2020");
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("01/07/2020");
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("Comment");
        driver.findElement(By.xpath("//div[@class='mat-tab-label mat-ripple ng-star-inserted']")).click();
        driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']")).sendKeys("3");

        driver.findElement(By.xpath("//ms-decimal-field//input")).sendKeys("22115");
        driver.findElement(By.xpath("//button[@class='mat-raised-button mat-button-base mat-basic ng-star-inserted']")).click();
        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        saveIcon.click();
        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Budget Group successfully created']" ) ) );
            System.out.println("Creation success!");
        } catch( Exception e) {
            System.out.println("Creation failure!");
        }




    }
}