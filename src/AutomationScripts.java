import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AutomationScripts extends ReUsableMethods {
	static Properties prop;
	public static void logDetails(){
		File file = new File("/Users/mounikapolisetti/Documents/SeleniumExam/login.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void NavigateToXERO() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.xero.com/");
		logDetails();
		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, prop.getProperty("username"), "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, prop.getProperty("password"), "password");
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(login, "Login");
		
	
	}
	
	public static void IncorrectPassword() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.xero.com/");
		logDetails();
		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, prop.getProperty("username"), "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, prop.getProperty("errorPassword"), "password");
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj1(login, "Login");
		
		
		
	}
	
	public static void IncorrectEmail() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.xero.com/");
		logDetails();

		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, prop.getProperty("errorUsername"), "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, prop.getProperty("password"), "password");
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj1(login, "Login");
		
		
		
	}
	public static void NavigatetoXEROD() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.xero.com/");
		logDetails();
		WebElement forgotPassword = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a"));
		clickObj(forgotPassword, "Forgot your password?");
		Thread.sleep(2000);
		
		WebElement verifyEmail = driver.findElement(By.xpath(".//*[@id='UserName']"));
		enterText(verifyEmail, prop.getProperty("username"), "UserName");
		
		WebElement sendLink = driver.findElement(By.xpath(".//*[@id='submitButton']/a/span"));
		clickObj(sendLink, "Send link");
		
	}
	public static void SignUpToXDCA() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");

		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		clickObj(freeTrial, "Free trial");
		
		WebElement firstName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input"));
		enterText(firstName, "mouni", "FirstName");
		
		WebElement lastName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input"));
		enterText(lastName, "si", "LastName");
		
		WebElement emailAddr = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		enterText(emailAddr, "abc@gmail.com", "EmailAddress");
		
		WebElement phoneNum = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input"));
		enterText(phoneNum, "4564563456", "PhoneNumber");
		
		WebElement country = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select"));
		Select customApp=new Select(country);
		customApp.selectByValue("AW");
		Thread.sleep(8000);
		
		WebElement terms = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input"));
		clickObj(terms, "Terms");
		
		WebElement getStarted = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
		clickObj(getStarted, "getStarted");
		
		
	}

	public static void SignUpToXDCB() throws IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();

	WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
	clickObj(freeTrial, "Free trial");
	Thread.sleep(8000);
	try{
	WebElement getStarted = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
	clickObj(getStarted, "getStarted");
	}catch (Exception e){
		System.out.println(e);
	}
	WebElement incorrectEmail = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
	enterText(incorrectEmail, "abc@gmail.com", "incorrectEmail");
	Thread.sleep(7000);
	try{
	WebElement getStarted = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
	clickObj(getStarted, "getStarted");
	}catch (Exception e){
		System.out.println(e);
	}
	
	
}
	
	
		public static void SignUpToXDCC() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();

		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		clickObj(freeTrial, "Free trial");
		
		WebElement termsOfUse = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[1]"));
		clickObj(termsOfUse, "terms of use");
		Thread.sleep(2000);
		
		WebElement privacyPolicy = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[2]"));
		clickObj(privacyPolicy, "privacyPolicy");
		Thread.sleep(2000);
		
}
		public static void SignUpToXDCD() throws IOException, InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.xero.com/us/");
			driver.manage().window().maximize();

			WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(freeTrial, "Free trial");
			
			WebElement offerDetails = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[3]"));
			clickObj(offerDetails, "offerDetails");
			Thread.sleep(3000);
	}
		public static void SignUpToXDCE() throws IOException, InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.xero.com/us/");
			driver.manage().window().maximize();

			WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(freeTrial, "Free trial");
			
			WebElement accOrBookKeep = driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a"));
			clickObj(accOrBookKeep, "accOrBookKeep");
			Thread.sleep(3000);
	}
		public static void TestAllTabsPage() throws IOException, InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.xero.com/us/");
			driver.manage().window().maximize();
			
			WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
			clickObj(login, "Login");
			
			WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
			enterText(email, "mounika25.p@gmail.com", "userName");
			
			WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
			enterText(password, "mounika93", "password");
			
			WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
			clickObj(flogin, "Login");
			
			WebElement dashboard = driver.findElement(By.xpath(".//*[@id='Dashboard']"));
			clickObj(dashboard, "dashboard");
			Thread.sleep(2000);
			
			WebElement accounts = driver.findElement(By.xpath(".//*[@id='Accounts']"));
			clickObj(accounts, "accounts");
			Thread.sleep(2000);
			
			WebElement reports = driver.findElement(By.xpath(".//*[@id='Reports']"));
			clickObj(reports, "reports");
			Thread.sleep(2000);
			
			WebElement contacts = driver.findElement(By.xpath(".//*[@id='Contacts']"));
			clickObj(contacts, "contacts");
			Thread.sleep(2000);
			
			WebElement settings = driver.findElement(By.xpath(".//*[@id='Settings']"));
			clickObj(settings, "settings");
			Thread.sleep(2000);
			
			WebElement plusSymbol = driver.findElement(By.xpath(".//*[@id='quicklaunchTab']"));
			clickObj(plusSymbol, "plusSymbol");
			Thread.sleep(2000);
			
			WebElement files = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a"));
			clickObj(files, "files");
			Thread.sleep(2000);
			
			WebElement notification = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a"));
			clickObj(notification, "notification");
			Thread.sleep(2000);
			
			WebElement searchTab = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a"));
			clickObj(searchTab, "searchTab");
			Thread.sleep(2000);
			
			WebElement help = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a"));
			clickObj(help, "help");
			Thread.sleep(2000);
			
		
	}
		
	public static void TestLogoutFunctionality() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.xero.com/");

		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, "mounika25.p@gmail.com", "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, "mounika93", "password");
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(login, "Login");
		
		WebElement logoutDropdown = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
		clickObj(logoutDropdown, "logoutDropdown");
		Thread.sleep(1500);
		
		WebElement logout = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a"));
		clickObj(logout, "logout");
		Thread.sleep(2000);
		
		
	}
	public static void TestUploadProfileImage() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.xero.com/");

		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, "mounika25.p@gmail.com", "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, "mounika93", "password");
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(login, "Login");
		
		WebElement logoutDropdown = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
		clickObj(logoutDropdown, "logoutDropdown");
		Thread.sleep(1500);
		
		WebElement profile = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[1]/a"));
		clickObj(profile, "profile");
		Thread.sleep(2000);
		
		WebElement uploadImage = driver.findElement(By.xpath(".//*[@id='button-1041-btnInnerEl']"));
		clickObj(uploadImage, "uploadImage");
		
		driver.findElement(By.xpath(".//*[@id='filefield-1174-button-fileInputEl']")).sendKeys("/Users/mounikapolisetti/Desktop/1.jpeg");
		Thread.sleep(2500);
		
		WebElement uploadButton = driver.findElement(By.xpath(".//*[@id='button-1178']"));
		clickObj(uploadButton, "uploadButton");
		Thread.sleep(2500);
		
		
		
		
	}
	
public static void AddAnotherOrganizationTrailVersion() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login, "Login");
		
		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, "mounika25.p@gmail.com", "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, "mounika93", "password");
		
		WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(flogin, "Login");
		
		WebElement myxero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"));
		clickObj(myxero, "myxero");
		Thread.sleep(2500);
		
		WebElement orgDetails = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div/a"));
		clickObj(orgDetails, "orgDetails");
		Thread.sleep(2500);
		
		WebElement addorgDetails = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
		clickObj(addorgDetails, "addorgDetails");
		Thread.sleep(2000);
		
		WebElement orgName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
		enterText(orgName, "self", "orgName");
		Thread.sleep(1500);
		
		WebElement taxDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1096']"));
		clickObj(taxDropdown, "taxDropdown");
		Thread.sleep(1500);
		
		WebElement countryDropdown = driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]"));
		clickObj(countryDropdown, "countryDropdown");
		Thread.sleep(1500);
		
		WebElement timezoneDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1100']"));
		clickObj(timezoneDropdown, "timezoneDropdown");
		Thread.sleep(1500);
		
		WebElement timezone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[128]"));
		clickObj(timezone, "timezone");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");;
		Thread.sleep(2000);
		
		WebElement org = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-boundlist-listEl']/div/ul/li[5]"));
		clickObj(org, "org");
		Thread.sleep(2000);
		
		
		WebElement starttrial = driver.findElement(By.xpath(".//*[@id='simplebutton-1035']"));
		clickObj(starttrial, "starttrial");
		Thread.sleep(8000);
		
		
		
}
	
public static void AddAnotherOrganizationPaidVersion() throws IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
	clickObj(login, "Login");
	
	WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
	enterText(email, "mounika25.p@gmail.com", "userName");
	
	WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
	enterText(password, "mounika93", "password");
	
	WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
	clickObj(flogin, "Login");
	
	WebElement myxero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"));
	clickObj(myxero, "myxero");
	Thread.sleep(2500);
	
	WebElement orgDetails = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div/a"));
	clickObj(orgDetails, "orgDetails");
	Thread.sleep(2500);
	
	WebElement addorgDetails = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
	clickObj(addorgDetails, "addorgDetails");
	Thread.sleep(2000);
	
	WebElement orgName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
	enterText(orgName, "self", "orgName");
	Thread.sleep(1500);
	
	WebElement taxDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1096']"));
	clickObj(taxDropdown, "taxDropdown");
	Thread.sleep(1500);
	
	WebElement countryDropdown = driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]"));
	clickObj(countryDropdown, "countryDropdown");
	Thread.sleep(1500);
	
	WebElement timezoneDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1100']"));
	clickObj(timezoneDropdown, "timezoneDropdown");
	Thread.sleep(1500);
	
	WebElement timezone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[128]"));
	clickObj(timezone, "timezone");
	Thread.sleep(1500);
	
	driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");;
	Thread.sleep(2000);
	
	WebElement org = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-boundlist-listEl']/div/ul/li[5]"));
	clickObj(org, "org");
	Thread.sleep(2000);
	
	
	WebElement buynow = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
	clickObj(buynow, "buynow");
	
	
	
}

public static void AddAnotherOrganizationStarterPlan() throws IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
	clickObj(login, "Login");
	
	WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
	enterText(email, "mounika25.p@gmail.com", "userName");
	
	WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
	enterText(password, "mounika93", "password");
	
	WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
	clickObj(flogin, "Login");
	
	WebElement myxero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"));
	clickObj(myxero, "myxero");
	Thread.sleep(2500);
	
	WebElement orgDetails = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div/a"));
	clickObj(orgDetails, "orgDetails");
	Thread.sleep(2500);
	
	WebElement addorgDetails = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
	clickObj(addorgDetails, "addorgDetails");
	Thread.sleep(2000);
	
	WebElement orgName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
	enterText(orgName, "self", "orgName");
	Thread.sleep(1500);
	
	WebElement taxDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1096']"));
	clickObj(taxDropdown, "taxDropdown");
	Thread.sleep(1500);
	
	WebElement countryDropdown = driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]"));
	clickObj(countryDropdown, "countryDropdown");
	Thread.sleep(1500);
	
	WebElement timezoneDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1100']"));
	clickObj(timezoneDropdown, "timezoneDropdown");
	Thread.sleep(1500);
	
	WebElement timezone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[128]"));
	clickObj(timezone, "timezone");
	Thread.sleep(1500);
	
	driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");;
	Thread.sleep(2000);
	
	WebElement software = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-boundlist-listEl']/div/ul/li[3]/p"));
	clickObj(software, "software");
	Thread.sleep(2000);
	
	WebElement buynow = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
	clickObj(buynow, "buynow");
	Thread.sleep(3500);
	
	WebElement starterPlan = driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/SOLO']/div[1]/label"));
	clickObj(starterPlan, "starterPlan");
	Thread.sleep(3000);
	
	WebElement continueToBilling = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"));
	clickObj(continueToBilling, "continueToBilling");
	Thread.sleep(3500);
	
	WebElement streetAddr = driver.findElement(By.xpath(".//*[@id='POAddress']"));
	enterText(streetAddr, "3450 granada ave", "streetAddr");
	Thread.sleep(1500);
	
	WebElement city = driver.findElement(By.xpath(".//*[@id='POCity']"));
	enterText(city, "santa clara", "city");
	Thread.sleep(1500);
	
	WebElement state = driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
	Select dropState=new Select(state);
	dropState.selectByValue("STATE/CA");
	Thread.sleep(1500);
	
	
	WebElement zipcode = driver.findElement(By.xpath(".//*[@id='POPostalCode']"));
	enterText(zipcode, "95051", "zipcode");
	Thread.sleep(1500);
	
	WebElement continueToReview = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"));
	clickObj(continueToReview, "continueToReview");
	Thread.sleep(1500);
	
	WebElement cardNumber = driver.findElement(By.xpath(".//*[@id='card-element']"));
	enterText(cardNumber, "5634 3452 3213 6789", "cardNumber");
	Thread.sleep(1500);
	
	WebElement expiryDate = driver.findElement(By.xpath(".//*[@id='card-expiry']"));
	enterText(expiryDate, "05/19", "expiryDate");
	Thread.sleep(1500);
	
	WebElement securityCode = driver.findElement(By.xpath(".//*[@id='card-cvc']"));
	enterText(securityCode, "555", "securityCode");
	Thread.sleep(1500);
	
	WebElement nameOnCard = driver.findElement(By.xpath(".//*[@id='cardholder-name']"));
	enterText(nameOnCard, "Mounika", "nameOnCard");
	Thread.sleep(1500);
	
	WebElement confirm = driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']"));
	clickObj(confirm, "confirm");
	Thread.sleep(1500);
	
	
	
	
}

public static void AddAnotherOrganizationStandardPlan() throws IOException, InterruptedException {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
	clickObj(login, "Login");
	
	WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
	enterText(email, "mounika25.p@gmail.com", "userName");
	
	WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
	enterText(password, "mounika93", "password");
	
	WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
	clickObj(flogin, "Login");
	
	WebElement myxero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"));
	clickObj(myxero, "myxero");
	Thread.sleep(2500);
	
	WebElement orgDetails = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div/a"));
	clickObj(orgDetails, "orgDetails");
	Thread.sleep(2500);
	
	WebElement addorgDetails = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
	clickObj(addorgDetails, "addorgDetails");
	Thread.sleep(2000);
	
	WebElement orgName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
	enterText(orgName, "self", "orgName");
	Thread.sleep(1500);
	
	WebElement taxDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1096']"));
	clickObj(taxDropdown, "taxDropdown");
	Thread.sleep(1500);
	
	WebElement countryDropdown = driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]"));
	clickObj(countryDropdown, "countryDropdown");
	Thread.sleep(1500);
	
	WebElement timezoneDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1100']"));
	clickObj(timezoneDropdown, "timezoneDropdown");
	Thread.sleep(1500);
	
	WebElement timezone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[128]"));
	clickObj(timezone, "timezone");
	Thread.sleep(1500);
	
	driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");;
	Thread.sleep(2000);
	
	WebElement software = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-boundlist-listEl']/div/ul/li[3]/p"));
	clickObj(software, "software");
	Thread.sleep(2000);
	
	WebElement buynow = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
	clickObj(buynow, "buynow");
	Thread.sleep(3500);
	
	WebElement standardPlan = driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/STANDARD']/div[1]/label"));
	clickObj(standardPlan, "standardPlan");
	Thread.sleep(3000);
	
	WebElement continueToBilling = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"));
	clickObj(continueToBilling, "continueToBilling");
	Thread.sleep(3500);
	
	WebElement streetAddr = driver.findElement(By.xpath(".//*[@id='POAddress']"));
	enterText(streetAddr, "3450 granada ave", "streetAddr");
	Thread.sleep(1500);
	
	WebElement city = driver.findElement(By.xpath(".//*[@id='POCity']"));
	enterText(city, "santa clara", "city");
	Thread.sleep(1500);
	
	WebElement state = driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
	Select dropState=new Select(state);
	dropState.selectByValue("STATE/CA");
	Thread.sleep(1500);
	
	
	WebElement zipcode = driver.findElement(By.xpath(".//*[@id='POPostalCode']"));
	enterText(zipcode, "95051", "zipcode");
	Thread.sleep(1500);
	
	WebElement continueToReview = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"));
	clickObj(continueToReview, "continueToReview");
	Thread.sleep(1500);
	
	WebElement cardNumber = driver.findElement(By.xpath(".//*[@id='card-element']"));
	enterText(cardNumber, "5634 3452 3213 6789", "cardNumber");
	Thread.sleep(1500);
	
	WebElement expiryDate = driver.findElement(By.xpath(".//*[@id='card-expiry']"));
	enterText(expiryDate, "05/19", "expiryDate");
	Thread.sleep(1500);
	
	WebElement securityCode = driver.findElement(By.xpath(".//*[@id='card-cvc']"));
	enterText(securityCode, "555", "securityCode");
	Thread.sleep(1500);
	
	WebElement nameOnCard = driver.findElement(By.xpath(".//*[@id='cardholder-name']"));
	enterText(nameOnCard, "Mounika", "nameOnCard");
	Thread.sleep(1500);
	
	WebElement confirm = driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']"));
	clickObj(confirm, "confirm");
	Thread.sleep(1500);

}
public static void AddAnotherOrganizationPremiumPlan() throws IOException, InterruptedException {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
	clickObj(login, "Login");
	
	WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
	enterText(email, "mounika25.p@gmail.com", "userName");
	
	WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
	enterText(password, "mounika93", "password");
	
	WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
	clickObj(flogin, "Login");
	
	WebElement myxero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"));
	clickObj(myxero, "myxero");
	Thread.sleep(2500);
	
	WebElement orgDetails = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div/a"));
	clickObj(orgDetails, "orgDetails");
	Thread.sleep(2500);
	
	WebElement addorgDetails = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
	clickObj(addorgDetails, "addorgDetails");
	Thread.sleep(2000);
	
	WebElement orgName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
	enterText(orgName, "self", "orgName");
	Thread.sleep(1500);
	
	WebElement taxDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1096']"));
	clickObj(taxDropdown, "taxDropdown");
	Thread.sleep(1500);
	
	WebElement countryDropdown = driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]"));
	clickObj(countryDropdown, "countryDropdown");
	Thread.sleep(1500);
	
	WebElement timezoneDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1100']"));
	clickObj(timezoneDropdown, "timezoneDropdown");
	Thread.sleep(1500);
	
	WebElement timezone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[128]"));
	clickObj(timezone, "timezone");
	Thread.sleep(1500);
	
	driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");;
	Thread.sleep(2000);
	
	WebElement software = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-boundlist-listEl']/div/ul/li[3]/p"));
	clickObj(software, "software");
	Thread.sleep(2000);
	
	WebElement buynow = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
	clickObj(buynow, "buynow");
	Thread.sleep(3500);
	
	WebElement premiumPlan = driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/PRO']/div[1]/label/span"));
	clickObj(premiumPlan, "premiumPlan");
	Thread.sleep(3000);
	
	WebElement continueToBilling = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"));
	clickObj(continueToBilling, "continueToBilling");
	Thread.sleep(3500);
	
	WebElement streetAddr = driver.findElement(By.xpath(".//*[@id='POAddress']"));
	enterText(streetAddr, "3450 granada ave", "streetAddr");
	Thread.sleep(1500);
	
	WebElement city = driver.findElement(By.xpath(".//*[@id='POCity']"));
	enterText(city, "santa clara", "city");
	Thread.sleep(1500);
	
	WebElement state = driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
	Select dropState=new Select(state);
	dropState.selectByValue("STATE/CA");
	Thread.sleep(1500);
	
	
	WebElement zipcode = driver.findElement(By.xpath(".//*[@id='POPostalCode']"));
	enterText(zipcode, "95051", "zipcode");
	Thread.sleep(1500);
	
	WebElement continueToReview = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"));
	clickObj(continueToReview, "continueToReview");
	Thread.sleep(1500);
	
	WebElement cardNumber = driver.findElement(By.xpath(".//*[@id='card-element']"));
	enterText(cardNumber, "5634 3452 3213 6789", "cardNumber");
	Thread.sleep(1500);
	
	WebElement expiryDate = driver.findElement(By.xpath(".//*[@id='card-expiry']"));
	enterText(expiryDate, "05/19", "expiryDate");
	Thread.sleep(1500);
	
	WebElement securityCode = driver.findElement(By.xpath(".//*[@id='card-cvc']"));
	enterText(securityCode, "555", "securityCode");
	Thread.sleep(1500);
	
	WebElement nameOnCard = driver.findElement(By.xpath(".//*[@id='cardholder-name']"));
	enterText(nameOnCard, "Mounika", "nameOnCard");
	Thread.sleep(1500);
	
	WebElement confirm = driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']"));
	clickObj(confirm, "confirm");
	Thread.sleep(1500);

}

public static void AddOrganizationCurrentQuickbooksUser() throws IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
	clickObj(login, "Login");
	
	WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
	enterText(email, "mounika25.p@gmail.com", "userName");
	
	WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
	enterText(password, "mounika93", "password");
	
	WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
	clickObj(flogin, "Login");
	
	WebElement myxero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
	clickObj(myxero, "myxero");
	Thread.sleep(2500);
	
	WebElement orgDetails = driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div/a"));
	clickObj(orgDetails, "orgDetails");
	Thread.sleep(2500);
	
	WebElement addorgDetails = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
	clickObj(addorgDetails, "addorgDetails");
	Thread.sleep(2000);
	
	WebElement orgName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
	enterText(orgName, "self", "orgName");
	Thread.sleep(1500);
	
	WebElement taxDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1096']"));
	clickObj(taxDropdown, "taxDropdown");
	Thread.sleep(1500);
	
	WebElement countryDropdown = driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]"));
	clickObj(countryDropdown, "countryDropdown");
	Thread.sleep(1500);
	
	WebElement timezoneDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1100']"));
	clickObj(timezoneDropdown, "timezoneDropdown");
	Thread.sleep(1500);
	
	WebElement timezone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[128]"));
	clickObj(timezone, "timezone");
	Thread.sleep(1500);
	
	driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");;
	Thread.sleep(2000);
	
	WebElement software = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-boundlist-listEl']/div/ul/li[3]/p"));
	clickObj(software, "software");
	Thread.sleep(2000);
	
	WebElement aacDropdown = driver.findElement(By.xpath(".//*[@id='ext-gen1119']"));
	clickObj(aacDropdown, "aacDropdown");
	Thread.sleep(1500);
	
	WebElement aacSoftware = driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[3]"));
	clickObj(aacSoftware, "aacSoftware");
	Thread.sleep(1500);
	
	WebElement quickbooks = driver.findElement(By.xpath(".//*[@id='conversionLink']"));
	clickObj(quickbooks, "quickbooks");
	Thread.sleep(1500);
	
	WebElement checkbox = driver.findElement(By.xpath(".//*[@id='conversionCheckbox-inputEl']"));
	clickObj(checkbox, "checkbox");
	Thread.sleep(1500);
	
	
	WebElement buynow = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
	clickObj(buynow, "buynow");
	
	
	
}	
	public static void CheckUsersSubscription() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login, "Login");
		
		WebElement email = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(email, "mounika25.p@gmail.com", "userName");
		
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(password, "mounika93", "password");
		
		WebElement flogin = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(flogin, "Login");
		
		WebElement accounts = driver.findElement(By.xpath(".//*[@id='Accounts']"));
		clickObj(accounts, "accounts");
		
		WebElement purchase = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[3]/a"));
		clickObj(purchase, "purchase");
		Thread.sleep(2500);
		
	
}

}