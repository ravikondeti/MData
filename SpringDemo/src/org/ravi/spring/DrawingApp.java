package org.ravi.spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("Spring.xml"));
		Triangle triangle =(Triangle)context.getBean("Triangle");
		triangle.draw();
		triangle.setApplicationContext(context);
		triangle.testContext();

	}

}
