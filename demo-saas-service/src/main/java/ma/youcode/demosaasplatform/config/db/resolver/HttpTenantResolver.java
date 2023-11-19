package ma.youcode.demosaasplatform.config.db.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class HttpTenantResolver implements TenantResolver<HttpServletRequest> {
    @Override
    public String resolveTenantId(HttpServletRequest request) {
        return request
                .getHeader("X-TenantID");
    }
}
