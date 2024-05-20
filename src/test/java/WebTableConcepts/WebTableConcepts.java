package WebTableConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WebTableConcepts {

	@Test
	public void VerifyTable() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2021/08");
		
		List<WebElement> allHeaders=driver.findElements(By.xpath("//table[contains(@id,'cust')]//th"));
			
		 System.out.println("All Headers size " + allHeaders.size());
		 
		 Assert.assertEquals(allHeaders.size(),5, "Column count is not Correct");
		 
		 Boolean status = false;
		 
		 for(WebElement ele:allHeaders) {
			 String val = ele.getText();
			 System.out.println(val);
			 if (val.contains("Country")) {
				status = true;
				break;
			 }
		 }
		
		 Assert.assertTrue(status,"Header not present");
		 
		 System.out.println("********************");
		 //All  Rows within the table
		List <WebElement>allRows =driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr"));
		System.out.println("Total Rows in the Table "+ allRows.size());
		Assert.assertEquals(allRows.size(), 7, "Table rows do not match");
		 System.out.println("********************");
		 
		//All data 
		List <WebElement> allData= driver.findElements(By.xpath("//table[contains(@id,'cust')]//td"));
		
		Boolean Datastatus = false;
		 
		 for(WebElement ele:allHeaders) {
			 String val = ele.getText();
			 System.out.println(val);
			 if (val.contains("Ola")) {
				status = true;
				break;
			 }
		 }
		
		 //Assert.assertTrue(Datastatus,"Ola not present");
		 
		 
		 System.out.println("********************");
		 //All  Rows within the table
		List <WebElement>compRow =driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr"));
		System.out.println("Total Rows in the Table "+ compRow.size());
		Assert.assertEquals(compRow.size(), 7, "Table rows do not match");
		 System.out.println("********************");
		 
		//Only second company
		List <WebElement> compData= driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr//td[2]"));
		
		Boolean Companytatus = false;
		 
		 for(WebElement ele:compData) {
			 String val = ele.getText();
			 System.out.println(val);
			 if (val.contains("Java")) {
				 Companytatus = true;
				break;
			 }
		 }
		
		 Assert.assertTrue(Companytatus,"Java not present");
		 
		 //Click the preceding check box
		 driver.findElement(By.xpath("//td[text()='Selenium']//preceding-sibling::td//input")).click();
		 
		 Thread.sleep(5000);
		 
		 //Click on the following link
		 driver.findElement(By.xpath("//td[text()='Ola']//following-sibling::td[3]//a")).click();
				 
		 driver.quit();
		 
		

	}

}
