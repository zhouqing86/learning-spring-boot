package wendll.controllers;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import wendll.customtag.User;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class BeanFactoryTest {
    @Test
    public void testXmlFactoryBeans() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("ap-test.xml");
        HelloController controller = (HelloController) context.getBean("helloController");
        System.out.println(controller.index());
    }

    @Test
    public void testResource() throws Exception {
        Resource resource = new ClassPathResource("ap-test.xml");

        InputStream inputStream = resource.getInputStream();

//        int data = inputStream.read();
//        while(data != -1) {
//            System.out.println(data);
//            data = inputStream.read();
//        }
//        inputStream.close();

//        Scanner scanner = new Scanner(inputStream);
//        System.out.println(scanner.next());

        BufferedInputStream bis = new BufferedInputStream(inputStream);
        String content=null;
        byte[] buffer=new byte[10240];
        int flag=0;
        while((flag=bis.read(buffer))!=-1){
            content+=new String(buffer, 0, flag);
        }
        System.out.println(content);
        bis.close();
    }

    @Test
    public void testCustomSpringTag() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("ap-test.xml");
        User user = (User) context.getBean("testbean");
        System.out.println(user.getUserName() + "," + user.getEmail());
    }
}
