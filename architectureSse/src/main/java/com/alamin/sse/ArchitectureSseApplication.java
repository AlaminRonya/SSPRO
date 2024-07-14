package com.alamin.sse;

import com.alamin.sse.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ArchitectureSseApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext run =SpringApplication.run(ArchitectureSseApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("our_bean.xml");
		var student = context.getBean("student", Student.class);
		System.out.println(student);
	}

}
