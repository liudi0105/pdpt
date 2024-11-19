package common.module.boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

@ConditionalOnBean(SpringBoot3App.class)
public @interface ConditionalOnSpringBoot3 {
}
