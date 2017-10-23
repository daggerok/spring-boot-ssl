spring-boot-ssl [![build](https://travis-ci.org/daggerok/spring-boot-ssl.svg?branch=master)](https://travis-ci.org/daggerok/spring-boot-ssl)
===============

This project contains simple spring-boot https example

```sh
gradle build bootRun
open https://localhost:8443/
```

using curl:

```sh
curl -k https://localhost:8443
```

using docker

```bash
docker build -t app .
docker run --rm -d -p 443:8443 --name=app app 
curl -k https://localhost/health
docker rm -f -v app
```

using docker-compose

```bash
docker-compose up --build -d 
curl -k https://localhost/health
docker-compose down -v
```

not worked shit...

```sh
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore build/keystore.p12 -validity 3650
    use password: password

openssl pkcs12 -in build/keystore.p12 -out build/file.key -nocerts -nodes
openssl pkcs12 -export -in "build/keystore.p12" -out "build/keystore.pem" -passin pass:password

openssl pkcs12 -in build/keystore.p12 -out build/keystore.crt.pem -clcerts -nokeys
openssl pkcs12 -in build/keystore.p12 -out build/keystore.key.pem -nocerts -nodes
openssl pkcs12 -in build/keystore.p12 -out build/keystore.pem

# old - not works
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore build/keystore.p12 -validity 3650
    use password: password
curl -k --cert build/keystore.p12:password https://localhost:8443
```
