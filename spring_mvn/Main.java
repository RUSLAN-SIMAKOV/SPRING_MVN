package spring_mvn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_mvn.config.AppConfig;
import spring_mvn.model.User;
import spring_mvn.service.UserService;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService userService = context.getBean(UserService.class);
		
		
		userService.add(new User("First", true));
		userService.add(new User("Second", false));
		
		userService.listUsers().stream().forEach(System.out::println);

	}
}
