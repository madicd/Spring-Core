package datasources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public String devSource() {
        return "Development Data Source";
    }

    @Bean
    @Profile("qa")
    public String qaSource() {
        return "Quality Assurance Data Source";
    }

    @Bean
    @Profile("prod")
    public String prodSource() {
        return "Production Data Source";
    }
}
