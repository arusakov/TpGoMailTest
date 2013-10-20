package technopark;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.mail.go.MainPage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class CalendarTest {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "hub", "url"})
    public void setUp(String browser, String hub, String url) throws MalformedURLException {
        if (browser.toLowerCase().equals("chrome"))
            driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.chrome());
        else if (browser.toLowerCase().equals("firefox"))
            driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        else
            throw new NotImplementedException();
        driver.manage().window().maximize();
        driver.get(url);
    }

	@Test
	public void currentYearTest() {
		int yearWeb = new MainPage(driver).goToCalendar().getCurrentYear();
		int yearCur = Calendar.getInstance().get(Calendar.YEAR);
		Assert.assertEquals(yearCur, yearWeb);
	}

	@Test
	public void daysInYearTest() {
		int daysWeb = new MainPage(driver).goToCalendar().getDaysInCurrentYear();
		int daysCurYear = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR);
		Assert.assertEquals(daysCurYear, daysWeb);
	}

	@Test
	public void dayOfMonth() {
		int currentDayWeb = new MainPage(driver).goToCalendar().getCurrentDayOfMonth();
		int currentDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		Assert.assertEquals(currentDayOfMonth, currentDayWeb);
	}

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
