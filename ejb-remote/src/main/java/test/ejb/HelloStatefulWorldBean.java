package test.ejb;

import test.interfaces.HelloStatefulWorld;

import javax.ejb.Stateful;

@Stateful(name = "HelloStatefulWorld")
public class HelloStatefulWorldBean implements HelloStatefulWorld {

    private int howManyTimes = 0;

    public int howManyTimes() {
        return howManyTimes;
    }

    public String getHelloWorld() {
        howManyTimes++;
        return "Hello Stateful World";
    }
}