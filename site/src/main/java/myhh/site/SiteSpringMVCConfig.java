package myhh.site;


import myhh.site.config.SiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateMode;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@PropertySource("classpath:site.properties")
@EnableWebMvc
@ComponentScan("myhh.site")
public class SiteSpringMVCConfig extends WebMvcConfigurerAdapter {

    @Autowired
    Environment environment;

    @Bean
    public SiteConfig siteConfig(){
        return new SiteConfig(environment);
    }

    @Bean
    public ITemplateResolver templateResolver(){
        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver();
        servletContextTemplateResolver.setPrefix("/WEB-INF/pages/");
        servletContextTemplateResolver.setSuffix(".html");
        servletContextTemplateResolver.setTemplateMode(TemplateMode.HTML5);
        return servletContextTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver());
        return springTemplateEngine;
    }

    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        return thymeleafViewResolver;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/scripts/");
        registry.addResourceHandler("/style/**").addResourceLocations("/WEB-INF/style/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/static/partials/**").addResourceLocations("/WEB-INF/pages/partials/");
    }

}
