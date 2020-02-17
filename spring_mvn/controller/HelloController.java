package spring_mvn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_mvn.UserResponseDto;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping(value = "/userdto")
	public UserResponseDto getUser() {
		UserResponseDto userDto = new UserResponseDto();
		userDto.setName("ADFD");
		userDto.setSex(false);
		return userDto;
	}
}
