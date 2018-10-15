package com.qianwenad.controller;

import com.google.common.collect.Maps;
import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.product.Brand;
import com.qianwenad.model.sys.Resource;
import com.qianwenad.model.sys.Role;
import com.qianwenad.model.sys.RoleResourceRef;
import com.qianwenad.model.sys.User;
import com.qianwenad.model.sys.UserRoleRef;
import com.qianwenad.service.product.BrandService;
import com.qianwenad.service.sys.ResourceService;
import com.qianwenad.service.sys.RoleResourceRefService;
import com.qianwenad.service.sys.RoleService;
import com.qianwenad.service.sys.UserRoleRefService;
import com.qianwenad.service.sys.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: andy.yang
 * Date: 2018/10/11
 * Time: 10:52
 * Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleResourceRefService roleResourceRefService;
    @Autowired
    private UserRoleRefService userRoleRefService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private  ResourceService resourceService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getBrandById(@PathVariable Long id){
        log.info("getBrandById id:{}",id);
        Brand brand = brandService.findByPrimaryKey(id);
        Resource r = resourceService.findByPrimaryKey(id);
        RoleResourceRef roleResourceRef = roleResourceRefService.findByPrimaryKey(id);
        UserRoleRef userRoleRef = userRoleRefService.findByPrimaryKey(id);
        Role role = roleService.findByPrimaryKey(id);
        User u = userService.findByPrimaryKey(id);
        Map m = Maps.newHashMap();
        m.put("resource",r);
        m.put("brand",brand);
        m.put("roleResourceRef",roleResourceRef);
        m.put("userRoleRef",userRoleRef);
        m.put("role",role);
        m.put("u",u);
        return new ResponseEntity(ApiResponse.ok(m), HttpStatus.OK);
    }
}
