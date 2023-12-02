package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static utils.DriverFactory.getDriver;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        getDriver();
    }

//    @AfterAll
//    public static void afterAll() {
//        getDriver().quit();
//    }

    public void setUp() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get("https://fakestore.testelka.pl/");
    }
}
