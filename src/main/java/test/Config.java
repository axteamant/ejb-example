package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
@Configuration
public class Config {

    @Bean
    public Context context() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put("java.naming.factory.initial",
                "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        jndiProps.put("java.naming.provider.url",
                "http-remoting://localhost:8080");
        return new InitialContext(jndiProps);
    }
    @Bean
    public HellowordInterface.HelloStatelessWorld helloStatelessWorld(Context context)
            throws NamingException {

        return (HellowordInterface.HelloStatelessWorld)
                context.lookup(this.getFullName(HellowordInterface.HelloStatelessWorld.class));
    }

    @Bean
    public HellowordInterface.HelloStatefulWorld helloStatefulWorld(Context context)
            throws NamingException {

        return (HellowordInterface.HelloStatefulWorld)
                context.lookup(this.getFullName(HellowordInterface.HelloStatefulWorld.class));
    }

    private String getFullName(Class classType) {
        String moduleName = "ejb-remote-for-spring/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();
        return moduleName + beanName + "!" + viewClassName;
    }
}
