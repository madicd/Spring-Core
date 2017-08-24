package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:configuration.xml")
public class CDPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}
