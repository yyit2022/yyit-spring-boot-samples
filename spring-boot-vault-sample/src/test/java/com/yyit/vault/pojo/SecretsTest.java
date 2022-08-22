package com.yyit.vault.pojo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;


class SecretsTest {

    private VaultTemplate vaultTemplate;

    @BeforeEach
    void setup(){
        URI uri = URI.create("http://192.168.56.130:8200");

        vaultTemplate = new VaultTemplate(VaultEndpoint.from(uri),new TokenAuthentication("hvs.qGQdgYRKRjh1RfGxvXUvv5Wj"));


    }

    @Test
    void testKvVault(){
        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        vaultTemplate.write("kvdemo/myapp", secrets);

        VaultResponseSupport<Secrets> response = vaultTemplate.read("kvdemo/myapp", Secrets.class);
        System.out.println(response.getData().getUsername());

    }

}