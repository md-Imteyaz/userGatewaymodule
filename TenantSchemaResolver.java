package com.ZuuleGateway.Interceptors;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {
	private String defaultTanent = "public";

	@Override
	public String resolveCurrentTenantIdentifier() {
		String t = TenantContext.getCurrentTenant();

		if (t != null) {
			return t;

		} else {
			return defaultTanent;
		}

	}

	public boolean validateExistingCurrentSessions() {
		return true;
	}
}
