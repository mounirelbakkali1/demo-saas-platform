package ma.youcode.demosaasplatform.config.db.hibernate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.demosaasplatform.config.db.context.TenantContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;


@Component
@RequiredArgsConstructor
@Slf4j
public class ConnectionProvider implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {

    private final DataSource dataSource;

    @Override
    public Connection getAnyConnection() throws SQLException {
        log.info("Connection to {} created",TenantContext.DEFAULT_TENANT_ID);
        return getConnection(TenantContext.DEFAULT_TENANT_ID);
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
            connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        var connection = dataSource.getConnection();
        connection.setSchema(tenantIdentifier);
        // connection.createStatement().execute("USE " + tenantIdentifier); instead of connection.setSchema(tenantIdentifier); when using MySQL
        log.info("Connection to tenant {} created", tenantIdentifier);
        return  connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        connection.setSchema(TenantContext.DEFAULT_TENANT_ID);
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return true;
    }

    @Override
    public boolean isUnwrappableAs(Class<?> unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
            hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, this);
            hibernateProperties.remove(AvailableSettings.DEFAULT_SCHEMA);

    }
}
