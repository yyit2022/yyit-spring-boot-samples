package com.yyit.vault.base;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.net.URI;
import java.util.Collections;

@SpringBootTest
public class KeyValueTests {

    @Autowired
    private VaultTemplate vaultTemplate;



    @Test
    public void v1_put_get(){
        VaultOperations operations = vaultTemplate;



        operations.write("secret/elvis", Collections.singletonMap("social-security-number", "409-52-2002"));

        VaultResponse read = operations.read("secret/elvis");
        read.getRequiredData().get("social-security-number");
    }

    @Test
    public void v2_put_get(){

        VaultOperations operations = vaultTemplate;
        VaultKeyValueOperations keyValueOperations = operations.opsForKeyValue("secret",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);

        keyValueOperations.put("elvis", Collections.singletonMap("social-security-number", "409-52-2002"));

        VaultResponse read = keyValueOperations.get("elvis");
        read.getRequiredData().get("social-security-number");


    }


}
