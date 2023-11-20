package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.interfaces.HelloStatefulWorld;
import test.interfaces.HelloStatelessWorld;

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
    public HelloStatelessWorld helloStatelessWorld(Context context)
            throws NamingException {
/*
java:global/ejb-remote-1.0-SNAPSHOT/HelloStatefulWorld!test.HellowordInterface$HelloStatefulWorld
[INFO] [talledLocalContainer] 	java:app/ejb-remote-1.0-SNAPSHOT/HelloStatefulWorld!test.HellowordInterface$HelloStatefulWorld
[INFO] [talledLocalContainer] 	java:module/HelloStatefulWorld!test.HellowordInterface$HelloStatefulWorld
[INFO] [talledLocalContainer] 	java:jboss/exported/ejb-remote-1.0-SNAPSHOT/HelloStatefulWorld!test.HellowordInterface$HelloStatefulWorld
[INFO] [talledLocalContainer] 	java:global/ejb-remote-1.0-SNAPSHOT/HelloStatefulWorld
[INFO] [talledLocalContainer] 	java:app/ejb-remote-1.0-SNAPSHOT/HelloStatefulWorld
[INFO] [talledLocalContainer] 	java:module/HelloStatefulWorld
${appName}/${moduleName}/${distinctName}/${beanName}!${viewClassName}
 */
        return (HelloStatelessWorld)
                context.lookup("ejb-remote-1.0-SNAPSHOT/HelloStatelessWorld!test.interfaces.HelloStatelessWorld");
    }
    @Bean
    public HelloStatefulWorld helloStatefulWorld(Context context)
            throws NamingException {

        return (HelloStatefulWorld)
                context.lookup("ejb-remote-1.0-SNAPSHOT/HelloStatefulWorld!test.interfaces.HelloStatefulWorld");
    }
    private String getFullName(Class classType) {
        String moduleName = "ejb-remote-1.0-SNAPSHOT/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();
        return moduleName + beanName + "!" + viewClassName;
    }

}
