package test;

import javax.ejb.Remote;

public class HellowordInterface {
    @Remote
    public interface HelloStatefulWorld {
        int howManyTimes();
        String getHelloWorld();
    }

    @Remote
    public interface HelloStatelessWorld {
        String getHelloWorld();
    }
}
