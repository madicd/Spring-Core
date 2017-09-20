package aspects.concert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformanceConfig.class)
public class ConcertTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private Performance performance;

    @Test
    public void testIntroducer() throws Exception {
        Encorable performanceAsEncorable = (Encorable) performance;
        performanceAsEncorable.performEncore();

        String consoleOuput = systemOutRule.getLog();
        assertThat(consoleOuput, containsString("Performing encore."));
    }

    @Test
    public void testAudienceAspect() throws Exception {
        performance.perform();

        String consoleOutput = systemOutRule.getLog();
        assertThat(consoleOutput, containsString("Silencing cell phones."));
        assertThat(consoleOutput, containsString("Taking a seat."));
        assertThat(consoleOutput, containsString("LA LA LA Concert performance."));
        assertThat(consoleOutput, containsString("CLAP CLAP CLAP!!!"));
    }

}