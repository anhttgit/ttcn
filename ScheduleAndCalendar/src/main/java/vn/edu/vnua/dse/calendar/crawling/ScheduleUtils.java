package vn.edu.vnua.dse.calendar.crawling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import vn.edu.vnua.dse.calendar.common.AppConstant;
import vn.edu.vnua.dse.calendar.common.AppUtils;

@Service
public class ScheduleUtils {

//	public static WebDriver openChrome() {
//		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWebdriver\\chromedriver.exe");
//		return new ChromeDriver();
//	}

	public static WebDriver openChrome() throws IOException {
		Properties prop = AppUtils.MyProperties(AppConstant.CALENDAR_APP_PRO);
		String driverName = prop.getProperty("crawling.driverName");
		String driverPath = prop.getProperty("crawling.driverPath", null);
		
		System.setProperty(driverName, driverPath);
		return new ChromeDriver();
	}

	public static String readFile(String file) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(file);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}

	public static void injectJQuery(WebDriver driver, String jQueryStr) throws IOException {
		String jQueryLoader = ScheduleUtils.readFile(jQueryStr);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(jQueryLoader);
	}

	public static int getDay(String day) {
		int result = -1;
		String[] daysOfWeek = new String[] { "Hai", "Ba", "Tư", "Năm", "Sáu", "Bảy", "CN" };
		for (int i = 0; i < daysOfWeek.length; i++) {
			if (day.equals(daysOfWeek[i])) {
				result = i;
			}
		}
		return result;
	}

	public static ArrayList<Integer> getWeek(String week) {
		ArrayList<Integer> weeks = new ArrayList<>();

		for (int i = 0; i < week.toCharArray().length; i++) {
			if ('-' != week.toCharArray()[i]) {
				weeks.add(i + 1);
			}
		}
		return weeks;
	}

	public static String joinIntArray(String delimiter, ArrayList<Integer> numbers) {
		StringBuilder builder = new StringBuilder();
		// Append all Integers in StringBuilder to the StringBuilder.
		for (int number : numbers) {
			builder.append(number);
			builder.append(delimiter);
		}
		// Remove last delimiter with setLength.
		builder.setLength(builder.length() - delimiter.length());
		return builder.toString();
	}

	public static String formatyyMMddTHHmmss(Date date) {
		String fomat = "yyyyMMdd HHmmss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fomat);

		String dateStr = simpleDateFormat.format(date);
		dateStr = dateStr.replace(" ", "T");

		return dateStr;
	}

	public static Date findDay(Date startSemester, int week, int day) {
		// set date
		Calendar calen = Calendar.getInstance();
		calen.setTime(startSemester);
		// compute
		calen.set(Calendar.DAY_OF_MONTH, calen.get(Calendar.DAY_OF_MONTH) + (week - 1) * 7 + day);

		return calen.getTime();
	}

}
