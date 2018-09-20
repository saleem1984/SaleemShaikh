package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
public class testSteps {

	Logger log;
	public static WebDriver driver;
	
	@Given("^User has opened the url$")
	public void user_has_opened_the_url() throws Throwable 
	{
		try
		{
			log = Logger.getLogger(testSteps.class);
			log.info("*****************New Test Run Started*************************");
			// Write code here that turns the phrase above into concrete actions
			//Please enter the path for chrome webdriver below
			System.setProperty("webdriver.chrome.driver","C:\\AutomationRunnerTool\\AutomationScriptAssemblyFIles\\DLL\\chromedriver.exe");
			
			driver = new ChromeDriver();	
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://e.ggtimer.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//img[@src='/images/eggtimer.gif']")).isDisplayed();
									
			log = Logger.getLogger(testSteps.class);
			log.info("Home page loaded successfully");
		}
		
		catch (Exception e)
		{
			log = Logger.getLogger(testSteps.class);
	        log.info("Test case Failed : Home page not loaded Exception" + e);
	        driver.quit();
	        throw new Error("Home page not loaded Exception" + e);
		}		
			
				
				
				
	}

	@When("^User enter the time in seconds into text box$")
	public void user_enter_the_time_in_seconds_into_text_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
		driver.findElement(By.id("start_a_timer")).clear();
		driver.findElement(By.id("start_a_timer")).sendKeys("25");
	    //throw new PendingException();
		
		log = Logger.getLogger(testSteps.class);
		log.info("User enter the time in seconds into text box successfully");
	}
	
	catch (Exception e)
	{
		log = Logger.getLogger(testSteps.class);
        log.info("Test case Failed :User enter the time in seconds into text box Exception" + e);
        driver.quit();
        throw new Error("User enter the time in seconds into text box Exception" + e);
	}		
	}

	@When("^Click on Go button$")
	public void click_on_Go_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
		driver.findElement(By.id("timergo")).click();
		
		log = Logger.getLogger(testSteps.class);
		log.info("Click on Go button successfully");
	}
	
	catch (Exception e)
	{
		log = Logger.getLogger(testSteps.class);
        log.info("Test case Failed : Click on Go button Exception" + e);
        driver.quit();
        throw new Error("Click on Go button Exception" + e);
	}		
	}

	@SuppressWarnings("deprecation")
	@Then("^User should be directed to new page$")
	public void user_should_be_directed_to_new_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Store the current window handle
		try{
			
			String winHandleBefore = driver.getWindowHandle();


		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		
		driver.findElement(By.id("progressText")).isDisplayed();
				
		log = Logger.getLogger(testSteps.class);
		log.info("User should be directed to new page");
	}
	
	catch (Exception e)
	{
		log = Logger.getLogger(testSteps.class);
        log.info("Test case Failed : User should be directed to new page" + e);
        driver.quit();
        throw new Error("User should be directed to new page Exception" + e);
	}		
	}


	@SuppressWarnings("deprecation")
	@Then("^Time should decrement per second$")
	public void time_should_decrement_per_second() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try{
			int Flag = 0;
			//String Time1 = driver.findElement(By.id("progressText")).getText();
		//Assert.assertEquals(Time1,"25 seconds");
		String Timer [] = null;
		
		for (int i=0 ; i<25 ; i++)
			{
				Thread.sleep(1000);
				Timer [i] = driver.findElement(By.id("progressText")).getText();
				//Assert.assertEquals(Time1,i+" seconds");
			
			}
		
		for (int j = 24; j > 0; j--)
		{
			String ExpTime = j+" seconds";
			if (ExpTime == Timer [j])
			{
				System.out.println("Actual: "+ Timer [j] +"Expected"+ ExpTime);
			}
			else {Flag = 1;}
			
		}
		if (Flag == 1)
		{log = Logger.getLogger(testSteps.class);
		log.info("Time decrement failed ");}
		else
		{
		log = Logger.getLogger(testSteps.class);
		log.info("Time should decrement per second successfully");
		driver.quit();
		}
	}
	
	catch (Exception e)
	{
		log = Logger.getLogger(testSteps.class);
        log.info("Test case Failed : Time should decrement per second Exception" + e);
        driver.quit();
        throw new Error("Time should decrement per second Exception" + e);
	}		
	}


	
	

}


