package net.canway.demos.demo.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.swagger")
public class SwaggerProperties {
    private String title;
    private String version;
    private String description;

}
