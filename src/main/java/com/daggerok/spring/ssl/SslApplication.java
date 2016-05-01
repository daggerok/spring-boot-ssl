package com.daggerok.spring.ssl;
/*
import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SocketUtils;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
mkdir -p src/main/resources/ssl
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore src/main/resources/ssl/keystore.p12 -validity 3650
    set password as: password
curl -k --cert src/main/resources/ssl/keystore.p12:password https://localhost:8443
 */

@Controller
@SpringBootApplication
public class SslApplication {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

/* // redirect http -> https
    @Bean
    public EmbeddedServletContainerFactory tomcat() {
        return new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
    }
*/

/* // https + http
    @Bean
    public Integer port() {
        return SocketUtils.findAvailableTcpPort();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(port());
        return connector;
    }
*/
    public static void main(String[] args) {
        SpringApplication.run(SslApplication.class, args);
    }
}
