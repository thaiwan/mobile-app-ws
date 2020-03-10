package com.thaiwan.app.ws.ui.controller;

import com.thaiwan.app.ws.service.UserService;
import com.thaiwan.app.ws.shared.dto.UserDto;
import com.thaiwan.app.ws.ui.model.request.UserDetailsRequestModel;
import com.thaiwan.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;

    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }


    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
