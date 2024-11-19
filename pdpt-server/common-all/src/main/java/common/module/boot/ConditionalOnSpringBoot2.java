package common.module.boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

@ConditionalOnBean(SpringBoot2App.class)
public @interface ConditionalOnSpringBoot2 {
}
