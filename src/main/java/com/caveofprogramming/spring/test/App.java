package com.caveofprogramming.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Logger logger = (Logger) context.getBean("logger");
        logger.writeFile("This is a file");
        logger.writeConsole("This is in the console console");

		((ClassPathXmlApplicationContext)context).close();
	}

}
