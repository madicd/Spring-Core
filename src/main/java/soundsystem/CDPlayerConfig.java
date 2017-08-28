package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@Configuration
@ImportResource("classpath:configuration.xml")
public class CDPlayerConfig {

    @Bean
    public CompactDisc compactDisc() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist("The Beatles");
        blankDisc.setTitle("Sgt. Pepper's Lonely hearts club band");
        return blankDisc;
    }

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}
