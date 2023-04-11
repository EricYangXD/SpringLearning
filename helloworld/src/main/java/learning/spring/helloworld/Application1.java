package learning.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class Application1 {

    private ClassPathXmlApplicationContext parentContext;
    private ClassPathXmlApplicationContext childContext;

    public static void main(String[] args) {
        Application1 app = new Application1();
        app.runTests();
    }

    private void runTests() {
        testVisibility(parentContext,"parentHello");
        testVisibility(childContext,"parentHello");
        testVisibility(parentContext,"childHello");
        testVisibility(childContext,"childHello");
        testOverridden(parentContext,"parentHello");
        testOverridden(childContext,"childHello");
    }

    private void testVisibility(ApplicationContext context, String beanName) {
        System.out.println(context.getId()+" can see "+beanName+": "+context.containsBean(beanName));
    }

    private void testOverridden(ApplicationContext context, String beanName) {
        System.out.println("sayHello from "+context.getId()+": "+context.getBean(beanName, Hello.class).hello());
    }



}
