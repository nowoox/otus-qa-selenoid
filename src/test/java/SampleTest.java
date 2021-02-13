import Base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class SampleTest extends BaseTest {

    @Test
    public void Test() {

        String q = "Wikipedia";

        mainPage = new MainPage(driver);

        mainPage.typeQuery(q);

        mainPage.clickQuery();

        mainPage.checkQuery(q);

    }

}
