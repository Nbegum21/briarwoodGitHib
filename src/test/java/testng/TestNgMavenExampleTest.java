package testng;

import Utilities.DateUtils;
import Utilities.ReadConfigFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

public class TestNgMavenExampleTest {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(TestNgMavenExampleTest.class);


    @Test
    public void run() {
        System.out.println(DateUtils.returnNextMonth());
    }
}
