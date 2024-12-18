package fr.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"fr.vod.controller","fr.vod.security","fr.vod.service", "fr.vod.dto","fr.vod.exception","fr.vod.model","fr.vod.repository",})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
