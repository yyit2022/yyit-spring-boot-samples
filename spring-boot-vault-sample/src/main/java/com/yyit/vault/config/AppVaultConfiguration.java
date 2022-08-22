package com.yyit.vault.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;

@Configuration
public class AppVaultConfiguration extends AbstractVaultConfiguration {
    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(URI.create("http://192.168.56.130:8200"));
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication("hvs.qGQdgYRKRjh1RfGxvXUvv5Wj");

    }
}
