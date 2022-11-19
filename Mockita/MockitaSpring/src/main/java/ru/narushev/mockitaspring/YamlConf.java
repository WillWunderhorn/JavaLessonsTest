package ru.narushev.mockitaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class YamlConf {

    @Configuration
    @ConfigurationProperties(prefix = "datasource.yml")
    @PropertySource(value = "classpath:/src/main/resources/datasource.yml")

    public class Config {

        private String datasource;
        private List<String> url;

        @Value("${datasource.database}")
        private static String database;

        @RequestMapping("/")
        public static String data(){
            System.out.println("DB: " + database);
            return "DB: " + database;
        }
    }
}
