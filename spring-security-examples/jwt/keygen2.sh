#!/usr/bin/env bash

set -e

function usage {
  echo "Usage: $(basename $0) KEY [DIR]
    KEY     要生成的密钥对的名称, 必须
    DIR     可选, 存储密钥的目录。
此脚本使用 openssl 生成私有 (KEY.pem) 和公共 (KEY.pub) 对；
密钥是使用 Elliptic Cryptography 生成的。
也可以参考： https://github.com/auth0/java-jwt/issues/270
"
}

KEY=${1:-}
DIR=${2:-}

if [[ -z ${KEY} || ${1:-} == "--help" || ${1:-} == "-h" ]]; then
  usage
  exit 1
fi

PRIV=${KEY}.pem
PUB=${KEY}.pub
if [[ -n ${DIR} && -d ${DIR} ]]; then
  PRIV=${DIR}/${PRIV}
  PUB=${DIR}/${PUB}
fi

# Generate the EC Param
openssl ecparam -name prime256v1 -genkey -noout -out ${KEY}-param.pem

# Generate the Private Key
openssl pkcs8 -topk8 -inform pem -in ${KEY}-param.pem -outform pem \
    -nocrypt -out ${PRIV}

# From the Private key, extract the Public Key
openssl ec -in ${PRIV} -pubout -out ${PUB}

rm ${KEY}-param.pem

echo "[SUCCESS] Key Pair generated: ${PRIV} / ${PUB}"