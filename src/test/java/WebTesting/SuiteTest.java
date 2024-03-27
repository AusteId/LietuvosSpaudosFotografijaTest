package WebTesting;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({HomePageTest.class, RegisterPageTest.class, LoginPageTest.class, CompetitionManagementTest.class})
public class SuiteTest {
}
