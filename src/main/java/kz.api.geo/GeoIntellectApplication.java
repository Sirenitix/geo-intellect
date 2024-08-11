package kz.api.geo;

import kz.api.geo.external.GeoIntellectFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients(clients = {GeoIntellectFeignClient.class})
public class GeoIntellectApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeoIntellectApplication.class);
    }
}

