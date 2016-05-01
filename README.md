spring-boot-ssl [![build](https://travis-ci.org/daggerok/spring-boot-ssl.svg?branch=master)](https://travis-ci.org/daggerok/spring-boot-ssl)
===============

spring boot https

```sh
git clone ... && cd $_
gradle bootRun
open https://localhost:8443/
```

using curl:

```sh
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore build/keystore.p12 -validity 3650
    use password: password
curl -k --cert build/keystore.p12:password https://localhost:8443
```
