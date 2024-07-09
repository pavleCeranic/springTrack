package dev.pavleceranic.content_calendar.controller;

import dev.pavleceranic.content_calendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    @Value("${cc.welcomeMessage: klasika}")
    private String welcomeMessage;

    @Value("${cc.about}")
    private String about;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("test1")
    public Map<String, String> Home1(){
        return Map.of("welcomeMessage", welcomeMessage, "about", about);
    }

    @GetMapping("test2")
    public Map<String, String> Home2(){
        return Map.of("welcomeMessage", welcomeMessage, "about", about);
    }

    @GetMapping("/")
    public ContentCalendarProperties home() {
        return properties;
    }
}
