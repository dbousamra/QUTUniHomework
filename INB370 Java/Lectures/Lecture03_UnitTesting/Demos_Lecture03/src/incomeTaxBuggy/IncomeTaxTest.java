package incomeTaxBuggy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({IncomeTaxTestNormal.class, IncomeTaxTestBoundary.class})

public class IncomeTaxTest {

}
