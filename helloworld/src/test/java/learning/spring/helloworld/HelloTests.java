package learning.spring.helloworld;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@SpringBootTest
@RunWith(Parameterized.class)
public class HelloTests {

    private final String name;
    private final String expected;

    public HelloTests(String name, String expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> initTestData() {
        return Arrays.asList(new Object[][]{{"world", "hello:world"}, {"", "hello:"}, {null, "hello:null"}, {"!@#$%^&*()_+", "hello:!@#$%^&*()_+"}});
    }

    @Test
    public void testSayHello() {
        Hello helloWorld = new Hello();
        assertEquals(this.expected, helloWorld.sayHello(this.name));
    }
}
