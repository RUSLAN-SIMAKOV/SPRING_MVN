package spring_mvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring_mvn.UserResponseDto;

@Controller
public class HelloController {

	@ResponseBody
	@GetMapping(value = "/hello")
	public String sayHello() {
		return "hello";
	}
	
	@ResponseBody
	@GetMapping(value = "/user")
	public UserResponseDto getUser() {
		UserResponseDto userResponceDto = new UserResponseDto();
		userResponceDto.setId(1L);
		userResponceDto.setName("ADFD");
		userResponceDto.setSex(false);
		return userResponceDto;
	}
}
