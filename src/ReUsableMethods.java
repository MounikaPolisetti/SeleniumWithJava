import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ReUsableMethods extends Driver {
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException {
		if (obj.isDisplayed()) {
			//obj.clear();
			obj.sendKeys(textVal);
			Update_Report("Pass", "enterText", textVal+ " is entered in " + objName + " field");
			System.out.println("Pass: " + textVal + " is entered in " + objName + " field");
			
		} else {
			Update_Report("Fail", "enterText", objName + " field is not displayed, please check your application.");
			System.out.println("Fail: " + objName + " field is not displayed, please check your application.");
		}
	}
		
		

	public static void clickObj(WebElement obj, String objName) {
		if (obj.isDisplayed()) {
			obj.click();
			System.out.println("Pass: " + objName + " is clicked");
		} else {
			System.out.println("Fail: " + objName + " field is not displayed, please check your application.");
		}
	}
	

	public static void clickLogout(WebElement obj, String objName) {
			obj.click();
			System.out.println("Pass: " + objName + " is clicked");
		
	}
      
	public static void enterText1(WebElement obj, String textVal, String objName) {
		if (obj.isDisplayed()) {
		obj.sendKeys(textVal);
		obj.clear();
		
	}
	}

	public static void clickObj1(WebElement obj, String objName) {
		if (obj.isDisplayed()) {
			obj.click();
			{
				System.out.println("Error:Your Email or Password is incorrect");
			}
		}
	}
	
	public static void LoginFailed(WebElement obj, String objName) {
		if (obj.isDisplayed()) {
			obj.click();
			{
				System.out.println("Error:Please check your username and password."
						+ " If you still can't log in, contact your Salesforce administrator.");
			}
		}
	}
	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#CB4335 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	public static String[][] readExcel(String dtpath, String sheetName)
			throws IOException {

		/* Step 1 : Get the XL path */
		File xlFile = new File(dtpath);

		/* Step 2 : Access the XL File */

		FileInputStream xlDoc = new FileInputStream(xlFile);
		/* Step 3 : Access the workbook */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		/* Step 4 : Access the sheet */
		HSSFSheet sheet = wb.getSheet("Sheet1");

		String value;

		// total number of rows
		int iRowCount = sheet.getLastRowNum() + 1;

		// total number of columns 

		int iColCount = sheet.getRow(0).getLastCellNum();
		// for all rows and columns
		String[][] xlData = new String[iRowCount][iColCount];
		for (int i = 0; i < iRowCount; i++) {
			for (int j = 0; j < iColCount; j++) {
				value = sheet.getRow(i).getCell(j).getStringCellValue();
				xlData[i][j] = value;
			}
			System.out.println();
		}
		return xlData;
	}
}
