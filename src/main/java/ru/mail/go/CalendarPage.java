package ru.mail.go;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.util.List;

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

	public List<WebElement> getYearsList() {
		driver.findElement(By.id("yearsContainer")).click();
		List<WebElement> years = driver.findElements(By.cssSelector("li.calendar__year"));
		years.remove(0);
		return years;
	}

	public void expandCalendar() {
		driver.findElement(By.id("calExpand")).click();
	}

	public void unexpandCalendar() {
		driver.findElement(By.id("calCloseButton")).click();
	}

	public int getBeforeYear() {
		List<WebElement> years = getYearsList();
		return Integer.parseInt(years.get(2).getText());
	}

	public int getNextYear() {
		List<WebElement> years = getYearsList();
		return Integer.parseInt(years.get(0).getText());
	}

	public Dimension getCalendarSize() {
		return driver.findElement(By.id("calBlock")).getSize();
	}

	public int getMonthCount() {
		return driver.findElements(By.cssSelector("table.calendar__month")).size();
	}
}
