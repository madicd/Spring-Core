package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:configuration.xml")
public class CDPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        mediaPlayer.play();
        String expectedContent = "Playing Sgt. Pepper's Lonely hearts club band by The Beatles\r\n" +
                "-Track: Sgt. Pepper's Lonely hearts club band\r\n" +
                "-Track: With a Little Help from My Friends\r\n" +
                "-Track: Getting Better\r\n";
        assertEquals(expectedContent, systemOutRule.getLog());
    }
}
