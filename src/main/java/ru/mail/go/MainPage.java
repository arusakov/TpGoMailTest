package ru.mail.go;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

	public CalendarPage goToCalendar() {
		WebElement searchForm = driver.findElement(By.id("q"));
		searchForm.sendKeys("календарь");
		WebElement searchButton = driver.findElement(By.className("go-form__submit"));
		searchButton.click();
		return new CalendarPage(driver);
	}
}
