package learning.spring.helloworld;

public class Hello {

    private String name;

    public String hello() {
        return "Hello World!" + name;
    }

    public String sayHello(String name) {
        return "hello:" + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
