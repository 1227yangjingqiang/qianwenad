package com.qianwenad.controller.sys;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.sys.Role;
import com.qianwenad.service.sys.RoleService;
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
public class RoleRestApiController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getRoleById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(roleService.findByPrimaryKey(id)), HttpStatus.OK);
    }


    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse> updateRoleByPrimaryKeySelective(@RequestBody Role role) throws Exception {
        return new ResponseEntity<>(ApiResponse.ok(roleService.updateByPrimaryKeySelective(role)), HttpStatus.OK);
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(ApiResponse.ok(roleService.create(role)), HttpStatus.OK);
    }

}
