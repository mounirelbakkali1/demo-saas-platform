package ma.youcode.demosaasapigateway.config.multitenancy.security;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "multi-tenancy.security")
public record TenantSecurityProperties(
        String clientId,
        String clientSecret,
        URI issuerUri
) {

}

