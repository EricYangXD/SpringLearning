//package learning.spring.helloworld;
//
//import org.apache.naming.factory.BeanFactory;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * @author valtechwh
// */
//@SpringBootApplication
////@RestController
//public class Application {
////    private BeanFactory beanFactory;
//
//    private ApplicationContext applicationContext;
//
//    public static void main(String[] args) {
////		SpringApplication.run(Application.class, args);
//        Application app = new Application();
//        app.sayHello();
//    }
//
//    public Application() {
////        beanFactory = new DefaultListableBeanFactory();
////        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
////        reader.loadBeanDefinitions("beans.xml");
//        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//    }
//
//    private void sayHello() {
////		Hello hello = new Hello();
////        Hello hello = beanFactory.getBean("hello", Hello.class);
////        System.out.println(hello.hello());
//        Hello hello = applicationContext.getBean("hello", Hello.class);
//        System.out.println(hello.hello());
//    }
//
////	@RequestMapping("/hello")
////	public String hello() {
////		return "Hello World!";
////	}
//
//
//}


package learning.spring.helloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

@SpringBootApplication
public class Application {

    private ClassPathXmlApplicationContext parentContext;
    private ClassPathXmlApplicationContext childContext;

    public static void main(String[] args) {
        new Application().runTests();
    }

    public Application() {
        parentContext = new ClassPathXmlApplicationContext("parent-beans.xml");
        childContext = new ClassPathXmlApplicationContext("child-beans.xml");
        parentContext.setId("ParentContext");
        childContext.setId("ChildContext");
    }

    private void runTests() {
        testVisibility(parentContext, "parentHello");
        testVisibility(childContext, "parentHello");
        testVisibility(parentContext, "childHello");
        testVisibility(childContext, "childHello");
        testOverridden(parentContext, "hello");
        testOverridden(childContext, "hello");
    }

    private void testVisibility(ApplicationContext context, String beanName) {
        System.out.println(context.getId() + " can see " + beanName + ": " + context.containsBean(beanName));
    }

    private void testOverridden(ApplicationContext context, String beanName) {
        System.out.println("sayHello from " + context.getId() + ": " + context.getBean(beanName, Hello.class).hello());
    }


}
