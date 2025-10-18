// Randoop generation command:
// java -ea -classpath "C:\JTools\randoop-all-4.3.4.jar;." randoop.main.Main gentests --testclass=Solution --time-limit=50 --output-limit=10 --junit-output-dir=.

package basic_calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ RegressionTest0.class })
public class RegressionTest {
}

