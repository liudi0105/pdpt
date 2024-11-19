package common.module.boot;

import common.module.util.AppBootstrap;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SpringBoot3App {
    public static ConfigurableApplicationContext start(Class<?> clazz) {
        return AppBootstrap.start(clazz, springApplication ->
                springApplication.addPrimarySources(List.of(SpringBoot3App.class)));
    }

    @Bean
    public SpringBoot3App springBoot3App() {
        return new SpringBoot3App();
    }
}
