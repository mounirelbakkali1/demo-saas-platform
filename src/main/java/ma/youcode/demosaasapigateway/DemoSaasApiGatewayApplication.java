package ma.youcode.demosaasapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "ma.youcode.demosaasapigateway.config.multitenancy.security")
public class DemoSaasApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSaasApiGatewayApplication.class, args);
    }
}
