package ma.youcode.demosaasplatform.controller;

import ma.youcode.demosaasplatform.config.db.context.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenant")
public class TenantController {



    @GetMapping
    public String getTenant() {
        return TenantContext.getTenantId();
    }
}
