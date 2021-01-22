package Base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    public MainPage mainPage;
    private String port;

    @BeforeEach
    public void setUp() throws IOException {

        port = setEnvironment("src/main/resources/SetRemoteEnv.bat");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        driver = new RemoteWebDriver(
                new URL("http://0.0.0.0:" + port + "/wd/hub"),
                capabilities);

        mainPage = PageFactory.initElements(driver, MainPage.class);

        driver.get("https://www.google.com/");

    }

    private String setEnvironment(String path) throws IOException {

        InputStream inputStream = Runtime.getRuntime().exec(new String[]{path}).getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String string;

        while ((string = bufferedReader.readLine()) != null){
            stringBuffer.append(string);
        }

        String resultString = stringBuffer.toString();

        port = resultString.substring(resultString.indexOf("SelenoidPort selenoid is :") + 27,
                resultString.indexOf("/tcp"));

        System.out.println(port);

        return port;
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
