package dev.pavleceranic.content_calendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// this is so that properties defined in application.properties can be a java class (in this case a record) so it can be used in code more obvious
@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties(String welcomeMessage, String about) {

}
