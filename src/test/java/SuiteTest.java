import APITesting.testAPI.AuthentificationTest;
import APITesting.testAPI.CompetitionCreationTest;
import WebTesting.CompetitionManagementTest;
import WebTesting.HomePageTest;
import WebTesting.LoginPageTest;
import WebTesting.RegisterPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({AuthentificationTest.class, CompetitionCreationTest.class, HomePageTest.class, RegisterPageTest.class,
        LoginPageTest.class, CompetitionManagementTest.class})
public class SuiteTest {
}