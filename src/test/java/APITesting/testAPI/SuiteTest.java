package APITesting.testAPI;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({AuthentificationTest.class, CompetitionCreationTest.class})
public class SuiteTest {
}
