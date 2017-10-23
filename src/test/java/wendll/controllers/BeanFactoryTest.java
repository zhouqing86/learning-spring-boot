package wendll.controllers;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryTest {
    @Test
    public void testXmlFactoryBeans() throws Exception {
        Resource resource = new ClassPathResource("ap-test.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("ap-test.xml");
        HelloController controller = (HelloController) context.getBean("helloController");
        System.out.println(controller.index());
    }
}
