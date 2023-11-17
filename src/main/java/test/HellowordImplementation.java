package test;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

public class HellowordImplementation {
    @Stateful(name = "HelloStatefulWorld")
    public class HelloStatefulWorldBean implements HellowordInterface.HelloStatefulWorld {

        private int howManyTimes = 0;

        public int howManyTimes() {
            return howManyTimes;
        }

        public String getHelloWorld() {
            howManyTimes++;
            return "Hello Stateful World";
        }
    }

    @Stateless(name = "HelloStatelessWorld")
    public class HelloStatelessWorldBean implements HellowordInterface.HelloStatelessWorld {

        public String getHelloWorld() {
            return "Hello Stateless World!";
        }
    }
}
