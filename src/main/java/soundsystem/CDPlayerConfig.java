package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

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
    public CompactDisc compactDisc() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist(env.getProperty("disc.artist"));
        blankDisc.setTitle(env.getProperty("disc.title"));
        return blankDisc;
    }

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}
