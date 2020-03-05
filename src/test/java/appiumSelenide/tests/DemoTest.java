package appiumSelenide.tests;

import appiumSelenide.utils.AndroidDriverDemo;
import com.codeborne.selenide.Configuration;
import io.appium.java_client.MobileBy;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class DemoTest {

    private static final String COUNTRY = "Израиль";
    private static final String PHONE_NUMBER = "0526995057";

    @Before
    public void setUp() {
        closeWebDriver();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverDemo.class.getName();
        open();
    }

    @Test
    public void verifyIncorrectSMSCode() {
//        Select country
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/et_country_prefix']")).click();
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/search_src_text']")).setValue(COUNTRY);
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/row_title']")).click();

//        Verify Terms & Policy page
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/tv_terms_and_conditions']")).click();

        $(By.xpath("//*[@text='Terms Of Use & Privacy Policy']")).should(visible);

//        Put your phone
        $(MobileBy.AccessibilityId("Перейти вверх")).click();
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/etInsertPhoneNumber']")).val(PHONE_NUMBER);
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/btn_send_phone_number']")).click();

        $(By.xpath("//*[@text='EDIT']")).click();
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/btn_send_phone_number']")).click();
        $(By.xpath("//*[@text='YES']")).click();

//        wait(60000);
//
//        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/btn_resend_code']")).click();

//      Put incorrect SMS number
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/input_cell_1']")).val("4");
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/input_cell_2']")).val("4");
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/input_cell_3']")).val("4");
        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/input_cell_4']")).val("4");

        $(By.xpath("//*[@resource-id='com.reporty.reporty:id/tv_code_status']")).should(visible);
    }
}
