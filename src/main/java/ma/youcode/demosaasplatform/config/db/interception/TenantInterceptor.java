package ma.youcode.demosaasplatform.config.db.interception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.youcode.demosaasplatform.config.db.context.TenantContext;
import ma.youcode.demosaasplatform.config.db.resolver.HttpTenantResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
public class TenantInterceptor implements HandlerInterceptor{

    private final HttpTenantResolver tenantResolver;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = tenantResolver.resolveTenantId(request);
        if (tenantId != null) {
            TenantContext.setTenantId(tenantId);
        } else {
            TenantContext.setTenantId("default");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       clear();
    }

    private void clear() {
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        clear();
    }
}
