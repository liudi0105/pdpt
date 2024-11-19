package common.module.boot;

import common.module.util.AppBootstrap;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SpringBoot2App {
    public static ConfigurableApplicationContext start(Class<?> clazz) {
        return AppBootstrap.start(clazz, springApplication ->
                springApplication.addPrimarySources(List.of(SpringBoot2App.class)));
    }

    @Bean
    public SpringBoot2App springBoot2App() {
        return new SpringBoot2App();
    }
}
