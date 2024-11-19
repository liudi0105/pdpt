package com.pd.server;

import common.module.jpa.BaseJpaRepositoryFactoryBean;
import common.module.jpa.EnableAppJpa;
import common.module.webmvc.EnableAppWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAppWeb
@EnableAppJpa(repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}