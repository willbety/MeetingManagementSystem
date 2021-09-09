package net.canway.demos.demo.web.intercepors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MyHandler implements WebMvcConfigurer {

    @Autowired
    private MyInterceptors myInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePaths = Arrays.asList("/error", "/csrf", "/", "/user/dep/**", "/swagger-ui.html", "/webjars/**", "/**/swagger-resources/**");
        registry.addInterceptor(myInterceptors)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);
    }



}
