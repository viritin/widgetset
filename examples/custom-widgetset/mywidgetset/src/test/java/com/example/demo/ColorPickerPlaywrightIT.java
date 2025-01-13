package com.example.demo;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import in.virit.mopo.Mopo;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;

/**
 * An example of end-to-end test for the widgetset module. This tests the
 * color picker component, but could have e.g. theme checks as well. Note,
 * not configure to run automatically (rename to *Test, or configure your setup
 * to also run *ITs).
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ColorPickerPlaywrightIT {

    @LocalServerPort
    private int port;

    private String rootUrl;

    static Playwright playwright = Playwright.create();


    private Browser browser;
    private Page page;
    private Mopo mopo;

    // fake location for Playwright, close enough so animation is shorter :-)
    double lat = 60.452;
    double lon = 22.290;

    @PostConstruct
    public void init() {
        rootUrl = "http://localhost:" + port + "/";
    }

    @BeforeEach
    public void setup() {
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
//                        .setDevtools(true)
                );


        // Define geolocation and permissions for Playwright to use
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setGeolocation(lat, lon)
                .setPermissions(Arrays.asList("geolocation")));
        page = context.newPage();
        mopo = new Mopo(page);
    }

    @AfterEach
    public  void closePlaywright() {
        page.close();
        browser.close();
    }

    @Test
    public void smokeTest() {
        String url = rootUrl + "colorpicker";
        page.navigate(url);
        
        Locator colorPicker = page.locator("#cp");
        System.out.println("Picker rendered!");
        // pick an attribute value inside the webcomponent, just as a smoke test
        Locator hueBar = colorPicker.locator("hue-bar");
        String attr = hueBar.getAttribute("hue");
        Assertions.assertEquals("120", attr);
        
    }

}