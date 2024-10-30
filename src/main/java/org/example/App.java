package org.example;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, SecurityAutoConfiguration.class})
@EnableScheduling

public class App  implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);



    @Value("${app.datasource.flyway-clean-on-startup:false}")
    private boolean runFlywayCleanOnStartup;


    public static void main( String[] args )
    {
        logger.debug("main() started");

        // Start up Spring Boot but disable the banner
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("App is Up");

    }
}
