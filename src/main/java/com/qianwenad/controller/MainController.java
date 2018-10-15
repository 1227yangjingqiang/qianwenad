package com.qianwenad.controller;

/**
 * Created with IntelliJ IDEA.
 * Author: andy.yang
 * Date: 2018/10/10
 * Time: 21:18
 * Description:
 */

import com.qianwenad.common.ApiResponse;
import com.qianwenad.model.sys.User;
import com.qianwenad.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    public static final String INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> index(HttpServletRequest request, HttpServletResponse response) {

        List<User> userList = userService.selectPage(new User(), new PageRequest(0, 1, Sort.Direction.DESC, "id"));
        System.out.println("......" + userList.size());

        return new ResponseEntity(ApiResponse.ok(userList), HttpStatus.OK);
    }


}
