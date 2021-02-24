package com.myPayCenter.qa.testcases;

import com.myPayCenter.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchPageTest extends BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();
        driver.get(prop.getProperty("url"));
    }
/*  Steps to handle Dynamic Search for Dynamic Xpath

1. Search auto–expand- pick a value from suggestions
2. Search using Xpath
3. Get total number of suggested records displayed
4. Use if condition to match the value
5. Click on matched value

 */

@Test
public void verifySearch_autoexpand() throws InterruptedException {
    //Here I am pretending that I have an access to actual UI scripts and creating the dynamic xpath
    //locating the Search box By.id
    driver.findElement(By.id("searchBox id")).sendKeys("Tip");

    // creating parent child relationship xpath and store in List
    List<WebElement> list = driver.findElements(By.xpath("//ul-is a parent //li-is child /descendant it will give us opportunity to access child of li ::div[@class='tippedbydefault']"));

    // print total number of suggestions in search box
    System.out.println("total number of suggested records displayed :::===>" + list.size());

    for(int i=0; i<list.size(); i++) {
        System.out.println(list.get(i).getText());
        if (list.get(i).getText().equalsIgnoreCase("Tip")) {
            list.get(i).click();
            break;
        }

    }
    }


//Check for the hidden attributes (subcategory of employee f.ex: )for "employee expand"
//getAttribute()
//AssertTrue()
// is displayed
    @Test
    public void verifyEmployeeExpandTest() throws Exception{
    driver.findElement(By.xpath("employee path")).click();
    String className = driver.findElement(By.xpath("employee path")).getAttribute("class");
    System.out.println(className);
    if (className.contains("value of the employee expand class")){
        Assert.assertTrue(true, "Test verifyEmployeeExpandTest is Pass");
    }else{
        Assert.assertTrue(false, "Test verifyEmployeeExpandTest is Pass");

    }

    }

    @Test
    public void validateCheckboxIsEmpty(){
    /*

List<WebElement> checkboxes= _driver.findElements(By.xpath("//input[@type='checkbox]"))
SoftAssert softAssert = new SoftAssert();
for(int i =0; i<checkbox.size(); i++){
// we are checking the attribute of the checkboxes(i) it is a boolean attribute
//if it isDisplayed = true,
//if it is not Displayed = false
//"Check" + String.valueOf(i) + "was not displayed"
    softAssert.assertTrue(checkboxes.get(i).isDisplayed(), "Check" + String.valueOf(i) + "was not displayed")
}
softAssert.assertAll();

// checking the checkbox isEmpty
    List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
WebElement checkBox = checkBoxes.get(count);
if (checkBox.getAttribute("class").contains("ng-empty")) {
    // checkbox not checked
}
     */
    }



    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
