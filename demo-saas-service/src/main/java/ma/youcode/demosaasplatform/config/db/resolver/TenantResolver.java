package ma.youcode.demosaasplatform.config.db.resolver;

import org.springframework.lang.NonNull;

@FunctionalInterface
public interface TenantResolver<T> {

    String resolveTenantId(@NonNull T obj);
}
