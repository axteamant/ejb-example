package test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.interfaces.HelloStatefulWorld;
import test.interfaces.HelloStatelessWorld;

@RestController
public class HomeEndpoint {

    @Autowired
    HelloStatelessWorld helloStatelessWorld;
    @Autowired
    HelloStatefulWorld helloStatefulWorld;

    @GetMapping("/stateless")
    public String getStateless() {
        return helloStatelessWorld.getHelloWorld();
    }

    @GetMapping("/stateful")
    public String getStateful() {
        return helloStatefulWorld.getHelloWorld()
                + " called " + helloStatefulWorld.howManyTimes() + " times";
    }


}
