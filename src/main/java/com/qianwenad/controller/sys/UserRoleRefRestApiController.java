package com.qianwenad.controller.sys;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.sys.UserRoleRef;
import com.qianwenad.service.sys.UserRoleRefService;
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
public class UserRoleRefRestApiController {


    @Autowired
    private UserRoleRefService userRoleRefService;

    @RequestMapping(value = "/userRoleRef/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getUserRoleRefById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(userRoleRefService.findByPrimaryKey(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/userRoleRef/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> deleteUserRoleRefByPrimaryKey(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(userRoleRefService.deleteByPrimaryKey(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/userRoleRef", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse> updateUserRoleRefByPrimaryKeySelective(@RequestBody UserRoleRef userRoleRef) {
        return new ResponseEntity<>(ApiResponse.ok(userRoleRefService.updateByPrimaryKeySelective(userRoleRef)), HttpStatus.OK);
    }

    @RequestMapping(value = "/userRoleRef", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> createUserRoleRef(@RequestBody UserRoleRef userRoleRef) {
        return new ResponseEntity<>(ApiResponse.ok(userRoleRefService.create(userRoleRef)), HttpStatus.OK);
    }

}
