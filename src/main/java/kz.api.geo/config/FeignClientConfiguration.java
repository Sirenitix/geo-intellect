package kz.api.geo.config;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfiguration {

    @Value("${external.api-key-name}")
    private String externalApiKeyName;

    @Value("${external.api-key-value}")
    private String externalApiKeyValue;

    private static final String AUTHORIZATION_HEADER = "key";
    private static final String API_KEY_NAME = "ccode";

    @Bean
    public RequestInterceptor getRequestInterceptor() {
        return requestTemplate -> requestTemplate
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .header(API_KEY_NAME, externalApiKeyName)
                .header(AUTHORIZATION_HEADER, externalApiKeyValue);
    }
}
