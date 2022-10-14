#!/usr/bin/env bash

echo "生成 RSA PUBLIC 和 PRIVATE KEYS ..."

# create rsa key pair
openssl genrsa -out ./src/main/resources/certs/keypair.pem 2048

# extract public key
openssl rsa -in ./src/main/resources/certs/keypair.pem -pubout -out ./src/main/resources/certs/public.pem

# create private key in PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in ./src/main/resources/certs/keypair.pem -out ./src/main/resources/certs/private.pem

