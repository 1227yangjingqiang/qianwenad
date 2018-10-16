package com.qianwenad.controller.sys;

import com.qianwenad.common.ApiListResponse;
import com.qianwenad.common.ApiResponse;
import com.qianwenad.common.mapper.AutoMapper;
import com.qianwenad.common.uitl.JsonUtil;
import com.qianwenad.model.sys.User;
import com.qianwenad.service.sys.UserService;
import com.qianwenad.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
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

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getUserList(UserVO userVO) {
        log.info("getUserList param:{}", JsonUtil.toJson(userVO));
        User r = new User();
        AutoMapper.mapping(userVO, r);
        ApiListResponse al = new ApiListResponse();
        al.setCount(userService.selectCount(r));
        al.setList(userService.selectPage(r, new PageRequest(userVO.getPage() - 1, userVO.getPageSize(), Sort.Direction.DESC, "id")));
        log.info("getUserList res:{}", JsonUtil.toJson(al));
        return new ResponseEntity<>(ApiResponse.ok(al), HttpStatus.OK);
    }

}
