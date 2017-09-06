package wiring.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CompactDisc cdSecondCopy;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Value("${disc.title}")
    private String discTitle;

    @Test
    public void play() {
        mediaPlayer.play();
        String expectedContent = "Playing Sgt. Pepper's Lonely hearts club band by The Beatles\r\n";
        assertEquals(expectedContent, systemOutRule.getLog());
    }

    @Test
    public void prototypes() {
        assertNotEquals(cd, cdSecondCopy);
    }

    @Test
    public void importedDiscTitle() {
        assertEquals("Sgt. Pepper's Lonely hearts club band", discTitle);
    }
}
