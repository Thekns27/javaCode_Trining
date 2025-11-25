package org.example.restapidemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.List;
import java.util.Optional;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> converter = converters.stream()
                .filter(c->c instanceof AbstractJackson2HttpMessageConverter)
                .findFirst();
        if(converter.isPresent()) {
            AbstractJackson2HttpMessageConverter foundConverter =
                    (AbstractJackson2HttpMessageConverter) converter.get();
            foundConverter.getObjectMapper()
                    .configure(SerializationFeature.INDENT_OUTPUT,true);
        }

    }
}
