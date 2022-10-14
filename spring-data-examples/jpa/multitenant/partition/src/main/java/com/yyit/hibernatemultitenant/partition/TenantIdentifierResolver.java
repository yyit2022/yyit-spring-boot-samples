package com.yyit.hibernatemultitenant.partition;

import java.util.Map;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer{
    
	private String currentTenant = "unknown";

	public void setCurrentTenant(String tenant) {
		currentTenant = tenant;
	}

	@Override
	public String resolveCurrentTenantIdentifier() {
		return currentTenant;
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
