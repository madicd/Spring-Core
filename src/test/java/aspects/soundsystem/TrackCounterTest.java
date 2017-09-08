package aspects.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wiring.soundsystem.CDPlayerConfig;
import wiring.soundsystem.CompactDisc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class TrackCounterTest {

    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private CompactDisc cd;

    @Test
    public void countTrack() throws Exception {
        cd.playTrack(0);
        cd.playTrack(0);
        cd.playTrack(1);
        cd.playTrack(1);
        cd.playTrack(1);
        cd.playTrack(1);

        int expectedCountTrack0 = 2;
        int expectedCountTrack1 = 4;

        assertThat(trackCounter.getPlayCount(0), is(equalTo(expectedCountTrack0)));
        assertThat(trackCounter.getPlayCount(1), is(equalTo(expectedCountTrack1)));
    }

}