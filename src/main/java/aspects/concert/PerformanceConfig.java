package aspects.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class PerformanceConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncorableIntroducer introducer() {
        return new EncorableIntroducer();
    }

    @Bean
    public Performance concert() {
        return new Concert();
    }
}
