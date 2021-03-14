package com.glb.us.login;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest 
{

	public WebDriver d;
    public WebElement search;
    public WebElement searchIcon;
    public WebElement Product;
    public WebElement cart;
    public WebElement Uid;
    public WebElement Con;
    public WebElement Pass;
    public WebElement signin;

    @AfterMethod
	public void titlecatch()
	{
    	String tit = d.getTitle();
    	System.out.println("The title is: " +tit);
	}
    
    @BeforeMethod
    public void m1()
    {
    	System.out.println("Next test case executed.....");
    }
    
    @Test (priority =11)
    public void Search() throws InterruptedException
    
    {
    	search = d.findElement(By.id("twotabsearchtextbox"));
    	search.sendKeys("New Apple iPhone 11 (128GB) - Black");
    	searchIcon = d.findElement(By.id("nav-search-submit-button"));
    	search.submit();
    	Thread.sleep(6000);
    	
    }
    
    @Test (priority = 10)
    public void launchsite()
    {
    d.get("https://www.amazon.in");	
    }
    
    @BeforeTest
    public void setup()
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
    	d = new ChromeDriver();
    	d.manage().window().maximize();
    	d.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }
    
    
    
    
    @Test(priority= 12)
    public void addcart()
    {
    	Product = d.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[2]/div[1]/span[3]/div[2]/div[3]/div[1]/span[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]"));
    	Product.click();
    	
    	ArrayList<String> wh = new ArrayList<String>(d.getWindowHandles());
    	String mainWinHandId = wh.get(0);
    	for (int i=1; i<=wh.size()-1;i++)
    	{
    		String s = wh.get(1);
    		d.switchTo().window(s);
    		
    	}
    	
    	
    	cart = d.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[7]/div[8]/div/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[33]/div/div/span/span/input"));
    	cart.click();
    	
    	
    }
    
    @Test(priority = 13)
	public void login()
	{
		Uid = d.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[1]/input[1]"));
		Uid.sendKeys("dhanashreegaikwad11@gmail.com");
		Con = d.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[2]/span/span/input"));
		Con.click();
		Pass = d.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/div/form/div/div[1]/input"));
		Pass.sendKeys("Dhana@123");
		signin = d.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/div/form/div/div[2]/span/span/input"));
		signin.click();
	}
    
    
}
    




















