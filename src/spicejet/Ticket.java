package spicejet;

import java.util.concurrent.TimeUnit;

import org.jboss.netty.channel.DefaultExceptionEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ticket {

	public static void main(String[] args) throws InterruptedException {
		
	
	System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.spicejet.com/");
    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Bangkok (BKK)')]")).click();
	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'Goa (GOI)')]")).click();
	driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'12')]")).click();
	//driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'20')]")).click();
	
	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
	{
		
		
		System.out.println("is enabled");
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		Assert.assertTrue(true);	
		
	}
	else
	{
		Assert.assertTrue(false);
		
	}	
	Actions acts=new Actions(driver);
	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'27')]"))));
	acts.moveToElement(driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'27')]"))).click().build().perform();
	//driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table//tr[3]//td[3]//a")).click();
	
	
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//div[@id='divpaxinfo']"))).click().build().perform();
	WebElement Passenger=driver.findElement(By.xpath("//div[@id='divpaxOptions']//div[2]//p//select[@id='ctl00_mainContent_ddl_Adult']"));
	Select sel=new Select(Passenger);
	sel.selectByValue("5");
	
	WebElement currancy=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select se=new Select (currancy);
	se.selectByValue("INR");
	
	driver.findElement(By.xpath("//span//input[@type='submit']")).click();
	WebElement result=driver.findElement(By.id("selectMainBody"));
	System.out.println(result.getText());
	Assert.assertTrue(true, result.getText());
	}
	
}
