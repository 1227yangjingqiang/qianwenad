package com.qianwenad.controller.sys;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.sys.User;
import com.qianwenad.service.sys.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ad")
public class UserRestApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(userService.findByPrimaryKey(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse> updateUserByPrimaryKeySelective(@RequestBody User user) {
        return new ResponseEntity<>(ApiResponse.ok(userService.updateByPrimaryKeySelective(user)), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user) {
        return new ResponseEntity<>(ApiResponse.ok(userService.create(user)), HttpStatus.OK);
    }

}
