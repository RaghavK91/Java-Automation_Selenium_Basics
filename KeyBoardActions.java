package day23;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://news.google.com/topstories?hl=en-IN&gl=IN&ceid=IN:en");
		driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div[2]/div/main/c-wiz/div[1]/div[1]/div[3]/div/div/article/a")).click();
		Thread.sleep(5000);
		
		Set<String>windowIDs=driver.getWindowHandles();
		
		List<String> windowIDsList=new ArrayList(windowIDs);
		String childWindowID=windowIDsList.get(1);
		
		driver.switchTo().window(childWindowID);
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		
		//Select all using CTRL+a
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//Copy using CTRL+c
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//Open a new tab
		act.keyDown(Keys.CONTROL);
		act.sendKeys("t");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		driver.get("https://www.rapidtables.com/tools/notepad.html");
		
		//Paste news in note
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		
	}

}
