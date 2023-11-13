package ma.youcode.demosaasplatform.config.db.context;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public final class TenantContext {

    private static final ThreadLocal<String> tenantId = new InheritableThreadLocal<>();


    public static void setTenantId(String tenant) {
        log.info("Setting tenant to " + tenant);
        tenantId.set(tenant);
    }


    public static String getTenantId() {
        return tenantId.get();
    }


    public static void clear() {
        tenantId.remove();
    }
}
