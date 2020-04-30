package com.example.yuisma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class YuismaApplication {

	public static void main(String[] args) {

		//使用AnnotationConfigApplicationContext 作为Spring 容器，接受输入一个配置类作为
		//参数；
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfDemo.class);
		B b = context.getBean(B.class);
		System.out.println(b.sayHello("di"));
		context.close();
	}


}
