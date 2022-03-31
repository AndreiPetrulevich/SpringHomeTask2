package ru.gb.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.gb.beans")
@PropertySource("classpath:application.properties")
public class ProductConfiguration {
}
