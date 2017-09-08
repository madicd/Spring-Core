package wiring.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class CDPlayerConfig {

    private final Environment env;

    @Autowired
    public CDPlayerConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CompactDisc compactDisc() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist(env.getProperty("disc.artist"));
        blankDisc.setTitle(env.getProperty("disc.title"));

        List<String> trackList = new ArrayList<>();
        trackList.add("Super duper track");
        trackList.add("I don't like Beatles");
        blankDisc.setTrackList(trackList);

        return blankDisc;
    }

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}
