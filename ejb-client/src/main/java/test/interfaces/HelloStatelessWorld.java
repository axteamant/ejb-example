package test.interfaces;

import javax.ejb.Remote;

@Remote
public interface HelloStatelessWorld {
    String getHelloWorld();
}