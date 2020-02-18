package spring_mvn.controller;

import spring_mvn.UserResponseDto;
import spring_mvn.model.User;
import spring_mvn.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return getDto(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        return users.stream().map(this::getDto).collect(Collectors.toList());
    }

        private UserResponseDto getDto(User user) {
            UserResponseDto userDto = new UserResponseDto();
            userDto.setName(user.getName());
            userDto.setSex(user.getSex());
            return userDto;
        }
}
