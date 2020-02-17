package spring_mvn.controller;

import spring_mvn.UserResponseDto;
import spring_mvn.model.User;
import spring_mvn.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public void userInjector() {

        userService.add(new User("First", true));
        userService.add(new User("Second", false));
        userService.add(new User("Forth", false));
        userService.add(new User("Third", false));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseDto get(@PathVariable Integer userId) {
        User user = userService.listUsers().get(--userId);
        UserResponseDto userDto = new UserResponseDto();
        userDto.setName(user.getName());
        userDto.setSex(user.getSex());
        return userDto;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        List<UserResponseDto> usersDto = new ArrayList<>();
        for (User user : users) {
            UserResponseDto userDto = new UserResponseDto();
            userDto.setName(user.getName());
            userDto.setSex(user.getSex());
            usersDto.add(userDto);
        }
        return usersDto;
    }
}
