import Base.BaseTest;
import pages.MainPage;
import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest {

    @Test
    public void Test() {

        mainPage = new MainPage(driver);

        mainPage.typeQuery("Wikipedia");

        mainPage.clickQuery();

    }

}
