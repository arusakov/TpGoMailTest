package ru.mail.go;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarPage {
	WebDriver driver;

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getCurrentDayOfMonth() {
		WebElement currentDay = driver.findElement(By.cssSelector(".calendar__currentday div"));
		return Integer.parseInt(currentDay.getText());
	}

	public int getDaysInCurrentYear() {
		return driver.findElements(By.cssSelector(".calendar__day:not(.calendar__day_other-month)")).size();
	}

	public int getCurrentYear() {
		WebElement currentYear = driver.findElement(By.cssSelector("span.calendar__year-current"));
		return Integer.parseInt(currentYear.getText().substring(0, 4));
	}
}
