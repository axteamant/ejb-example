package test.interfaces;

import javax.ejb.Remote;

@Remote
public interface HelloStatefulWorld {
    int howManyTimes();
    String getHelloWorld();
}
