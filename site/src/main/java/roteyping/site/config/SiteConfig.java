package roteyping.site.config;

import org.springframework.core.env.Environment;

public class SiteConfig {
    private Environment environment;

    public SiteConfig(Environment environment) {
        this.environment = environment;
    }

    public String serviceUrl(){
        return environment.getProperty("service.url");
    }
}
