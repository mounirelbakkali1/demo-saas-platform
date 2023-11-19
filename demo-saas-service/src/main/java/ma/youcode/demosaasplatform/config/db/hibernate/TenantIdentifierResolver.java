package ma.youcode.demosaasplatform.config.db.hibernate;

import ma.youcode.demosaasplatform.config.db.context.TenantContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

// HibernatePropertiesCustomizer is used explicitly configure Hibernate to use this resolver
// Hibernate will not allow spring to define CurrentTenantIdentifierResolver
@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {
    @Override
    public String resolveCurrentTenantIdentifier() {
        return Objects.requireNonNullElse(TenantContext.getTenantId(), TenantContext.DEFAULT_TENANT_ID);
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
            hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
